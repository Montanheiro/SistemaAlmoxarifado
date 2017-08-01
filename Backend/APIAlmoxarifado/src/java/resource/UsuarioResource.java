package resource;

import business.Resposta;
import static business.Token.*;
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
            
            if(u.isAdmin() == 1) token = Gerate("admin", u.getId(), 8);
            else token = Gerate("user", u.getId(), 8);

            return Response.ok().entity(token).build();
            
        } catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Usuário ou senha incorretos").build();
        } 
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/verify")
    public Response verify(@HeaderParam("token") String token){
              
        try {
            if(!Verify(token, "admin") && !Verify(token, "user"))
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Usuário ou senha incorretos").build();
        } catch (Exception ex) {
            return Resposta.retornar(400, ex.toString(), token);
        }
    
        return Response.status(Response.Status.OK).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response create(@HeaderParam("token") String token, String body) 
           {
        
               // ESSA REGRA DE CRIAR USUÁRIO NÃO SE APLICA A ESSE SISTEMA
               
        Gson gson = new Gson();
        
        try {
            if(!Verify(token, "admin"))
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Usuário ou senha incorretos").build();
        } catch (Exception ex) {
            return Resposta.retornar(400, ex.toString(), token);
        }
        
        try {
            Usuario u = gson.fromJson(body, Usuario.class);
            UsuarioDAO.create(u);
        } catch (SQLException ex) {
            return Resposta.retornar(400, ex.toString(), token);
        }
        
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/get")
    public Response get(@HeaderParam("token") String token) throws Exception {
        
     
        if (!Verify(token, "admin") || !Verify(token, "user"))
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Usuário ou senha incorretos").build();
        
        int id = getSubject(token);
        Usuario u = UsuarioDAO.retreave(id);
        
        Gson gson = new Gson();
        return Response.status(Response.Status.OK)
                .entity(gson.toJson(u)).build();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getid")
    public Response  getId(@HeaderParam("token") String token, 
            @QueryParam("id") int id) throws SQLException, Exception {
        
        if(!Verify(token, "admin")) 
            return Response.status(Response.Status.UNAUTHORIZED).build();
        
        Gson gson = new Gson();
        Usuario u = UsuarioDAO.retreave(id);
        
        return Response.status(Response.Status.OK)
                .entity(gson.toJson(u)).build();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getall")
    public Response getAll(@HeaderParam("token") String token) 
            throws SQLException, Exception{
        
        if(!Verify(token, "admin")) 
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Usuário ou senha incorretos").build();
        
        Gson gson = new Gson();
        ArrayList<Usuario> admin = UsuarioDAO.retreaveAll();
        return Response.status(Response.Status.OK)
                .entity(gson.toJson(admin)).build(); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updatepassword")
    public Response updatePassword(@HeaderParam("token") String token, String body) 
            throws SQLException, Exception{
        
        Gson gson = new Gson();
        Usuario u = gson.fromJson(body, Usuario.class);  
        
        try {
            if(!Verify(token, "admin") && !Verify(token, "user"))
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Usuário ou senha incorretos").build();
        } catch (Exception ex) {
            return Resposta.retornar(400, ex.toString(), token);
        }
        
        int id = getSubject(token);    
        u.setId(id);
        UsuarioDAO.updatePassword(u);

        return Response.ok().build();
    }
}
