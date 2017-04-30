/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import business.Token;
import com.google.gson.Gson;
import constructor.Contato;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import persistence.ContatoDAO;

/**
 *
 * @author dione
 */

    @Path("contato")
public class ContatoResource {
    @Context
    private UriInfo context;
    
    public ContatoResource(){
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public String create(@HeaderParam("token") String token, String body) 
            throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        if(!new Token().Verify(token, "almoxarifado")) throw new Exception("Token invalido.");
        
        Contato c = gson.fromJson(body, Contato.class);
         ContatoDAO.create(c);
        
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
        Contato c = ContatoDAO.retreave(id);
        return gson.toJson(c);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/retreaveAll")
    public String getAll(@HeaderParam("token") String token) 
            throws SQLException, Exception{
        
        if(!new Token().Verify(token, "almoxarifado")) 
            throw new Exception("Token invalido.");
        
        Gson gson = new Gson();
        ArrayList<Contato> contato = ContatoDAO.retreaveAll();
        return gson.toJson(contato); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete")
    public String delete(@HeaderParam("token") String token, String body) 
            throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        if(!new Token().Verify(token, "almoxarifado")) throw new Exception("Token invalido.");
        
        Contato c = gson.fromJson(body, Contato.class);
         ContatoDAO.delete(c);
         return "200";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public String upate(@HeaderParam("token") String token, String body) 
            throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        if(!new Token().Verify(token, "almoxarifado")) throw new Exception("Token invalido.");
        
        Contato c = gson.fromJson(body, Contato.class);
         ContatoDAO.update(c);
        
        return "200";
    }
    
}
