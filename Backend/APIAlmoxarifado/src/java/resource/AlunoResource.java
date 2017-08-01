/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import business.Token;
import com.google.gson.Gson;
import constructor.Aluno;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import persistence.AlunoDAO;

/**
 *
 * @author dione
 */
@Path("alunos")
public class AlunoResource {
    @Context
    private UriInfo context;
    
    public AlunoResource(){
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public String create(@HeaderParam("token") String token, String body) 
            throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        if(!new Token().Verify(token, "almoxarifado")) throw new Exception("Token invalido.");
        
        Aluno a = gson.fromJson(body, Aluno.class);
         AlunoDAO.create(a);
        
        return "200";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/retreave")
    public String retreave(@HeaderParam("token") String token, 
            @QueryParam("id") int id) throws SQLException, Exception {
        if(!new Token().Verify(token, "almoxarifado")) 
            throw new Exception("Token invalido.");
        Gson gson = new Gson();
        Aluno a = AlunoDAO.retreave(id);
        return gson.toJson(a);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/retreaveAll")
    public String getAll(@HeaderParam("token") String token) 
            throws SQLException, Exception{
        
        if(!new Token().Verify(token, "almoxarifado")) 
            throw new Exception("Token invalido.");
        
        Gson gson = new Gson();
        ArrayList<Aluno> aluno = AlunoDAO.retreaveAll();
        return gson.toJson(aluno); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete")
    public String delete(@HeaderParam("token") String token, String body) 
            throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        if(!new Token().Verify(token, "almoxarifado")) throw new Exception("Token invalido.");
        
        Aluno a = gson.fromJson(body, Aluno.class);
         AlunoDAO.delete(a);
         return "200";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public String upate(@HeaderParam("token") String token, String body) 
            throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        if(!new Token().Verify(token, "almoxarifado")) throw new Exception("Token invalido.");
        
        Aluno a = gson.fromJson(body, Aluno.class);
         AlunoDAO.update(a);
        
        return "200";
    }
}
