package resource;

import business.Token;
import com.google.gson.Gson;
import constructor.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import persistence.UsuarioDAO;

/**
 * REST Web Service
 *
 * @author lucas
 */
@Path("usuario")
public class UsuarioResource {

    @Context
    private UriInfo context;

    public UsuarioResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(String body){
                
        try {
            Gson gson = new Gson();
        
            Usuario u = gson.fromJson(body, Usuario.class);
            u = UsuarioDAO.retreaveLogin(u.getEmail(), u.getSenha());
            String token;
            if(u.isAdmin() == 1) token = new Token().Gerate("admin", u.getId(), 8);
            else token = new Token().Gerate("user", u.getId(), 8);

            return Response.status(Response.Status.OK).entity(token).build();
            
        } catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(ex.getMessage()).build();
        } 
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/verify")
    public Response verify(@HeaderParam("token") String token){
              
        try {
            if(!new Token().Verify(token, "admin") && !new Token().Verify(token, "user"))
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Token invalido").build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(ex.getMessage()).build();
        }
    
        return Response.status(Response.Status.OK).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response create(@HeaderParam("token") String token, String body) 
           {
        
        Gson gson = new Gson();
        
        try {
            if(!new Token().Verify(token, "admin"))
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Token invalido").build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(ex.getMessage()).build();
        }
        
        try {
            Usuario c = gson.fromJson(body, Usuario.class);
            UsuarioDAO.create(c);
        } catch (SQLException ex) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(ex.getMessage()).build();
        }
        
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
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
    @Consumes(MediaType.APPLICATION_JSON)
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
    @Consumes(MediaType.APPLICATION_JSON)
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
