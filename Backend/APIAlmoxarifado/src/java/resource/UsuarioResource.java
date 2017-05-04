package resource;

import business.Token;
import com.google.gson.Gson;
import constructor.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import persistence.UsuarioDAO;

/**
 * REST Web Service
 *
 * @author lucas
 */
@Path("generic")
public class UsuarioResource {

    @Context
    private UriInfo context;

    public UsuarioResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public String login(String body) throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        Usuario u = gson.fromJson(body, Usuario.class);
        u = UsuarioDAO.retreaveLogin(u.getEmail(), u.getSenha());

        String token;
        if(u.isAdmin() == 1) token = new Token().Gerate("admin", u.getId(), 8);
        else token = new Token().Gerate("user", u.getId(), 8);
        
        return token;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/verify")
    public String verify(@HeaderParam("token") String token) throws Exception {
        
        if(!new Token().Verify(token, "admin") && !new Token().Verify(token, "user")) 
            throw new Exception("Token invalido.");
        
        return "200";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public String create(@HeaderParam("token") String token, String body) 
            throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        if(!new Token().Verify(token, "admin")) throw new Exception("Token invalido.");
        
        Usuario c = gson.fromJson(body, Usuario.class);
        UsuarioDAO.create(c);
        
        return "200";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public String get(@HeaderParam("token") String token) throws Exception {
        
        String type;
        
        if(new Token().Verify(token, "admin")) type = "admin";
        else if(new Token().Verify(token, "user")) type = "user";
        else throw new Exception("Token invalido.");
        
        int id = new Token().getSubject(token, type);
        Usuario c = UsuarioDAO.retreave(id);
        
        Gson gson = new Gson();
        return gson.toJson(c);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getid")
    public String  getId(@HeaderParam("token") String token, 
            @QueryParam("id") int id) throws SQLException, Exception {
        
        if(!new Token().Verify(token, "admin")) 
            throw new Exception("Token invalido.");
        
        Gson gson = new Gson();
        Usuario a = UsuarioDAO.retreave(id);
        
        return gson.toJson(a);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getall")
    public String getAll(@HeaderParam("token") String token) 
            throws SQLException, Exception{
        
        if(!new Token().Verify(token, "admin")) 
            throw new Exception("Token invalido.");
        
        Gson gson = new Gson();
        ArrayList<Usuario> admin = UsuarioDAO.retreaveAll();
        return gson.toJson(admin);  
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updatepassword")
    public String updatePassword(@HeaderParam("token") String token, String body) 
            throws SQLException, Exception{
        
        Gson gson = new Gson();
        Usuario u = gson.fromJson(body, Usuario.class);  
        
        String type;
        if(new Token().Verify(token, "admin")) type = "admin";
        else if(new Token().Verify(token, "user")) type = "user";
        else throw new Exception("Token invalido.");
        
        int id = new Token().getSubject(token, type);    
        u.setId(id);
        UsuarioDAO.updatePassword(u);

        return "200";  
    }
}
