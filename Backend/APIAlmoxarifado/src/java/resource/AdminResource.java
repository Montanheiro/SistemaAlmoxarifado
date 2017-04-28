package resource;

import business.Token;
import com.google.gson.Gson;
import constructor.Admin;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import persistence.AdminDAO;

@Path("admin")
public class AdminResource {

    @Context
    private UriInfo context;

    public AdminResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public String login(String body) throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        Admin a = gson.fromJson(body, Admin.class);
        a = AdminDAO.retreave(a.getUser(), a.getPassword());

        String token;
        if(a.getType() == 1) token = new Token().Gerate("superadmin", a.getId(), 8);
        else token = new Token().Gerate("admin", a.getId(), 8);
        
        return token;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/verify")
    public String verify(@HeaderParam("token") String token) throws Exception {
        
        if(!new Token().Verify(token, "admin") && !new Token().Verify(token, "superadmin")) 
            throw new Exception("Token invalido.");
        
        return "200";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public String create(@HeaderParam("token") String token, String body) 
            throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        if(!new Token().Verify(token, "superadmin")) throw new Exception("Token invalido.");
        
        Admin a = gson.fromJson(body, Admin.class);
        AdminDAO.create(a);
        
        return "200";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public String get(@HeaderParam("token") String token) throws Exception {
        
        String type;
        
        if(new Token().Verify(token, "superadmin")) type = "superadmin";
        else if(new Token().Verify(token, "admin")) type = "admin";
        else throw new Exception("Token invalido.");
        
        int id = new Token().getSubject(token, type);
        Admin a = AdminDAO.retreave(id);
        
        Gson gson = new Gson();
        return gson.toJson(a);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getid")
    public String  getId(@HeaderParam("token") String token, 
            @QueryParam("id") int id) throws SQLException, Exception {
        
        if(!new Token().Verify(token, "superadmin")) 
            throw new Exception("Token invalido.");
        
        Gson gson = new Gson();
        Admin a = AdminDAO.retreave(id);
        
        return gson.toJson(a);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getall")
    public String getAll(@HeaderParam("token") String token) 
            throws SQLException, Exception{
        
        if(!new Token().Verify(token, "superadmin")) 
            throw new Exception("Token invalido.");
        
        Gson gson = new Gson();
        ArrayList<Admin> admin = AdminDAO.retreaveAll();
        return gson.toJson(admin);  
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updatepassword")
    public String updatePassword(@HeaderParam("token") String token, String body) 
            throws SQLException, Exception{
        
        Gson gson = new Gson();
        Admin a = gson.fromJson(body, Admin.class);  
        
        String type;
        if(new Token().Verify(token, "superadmin")) type = "superadmin";
        else if(new Token().Verify(token, "admin")) type = "admin";
        else throw new Exception("Token invalido.");
        
        int id = new Token().getSubject(token, type);    
        a.setId(id);
        AdminDAO.updatePassword(a);

        return "200";  
    }
}
