/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import constructor.LogErro;
import constructor.Usuario;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import persistence.LogErroDAO;
import persistence.UsuarioDAO;

/**
 *
 * @author lucas
 */
public class Resposta {
    
    public static Response retornar(int status, String erro, String token){
        
        Usuario usuario = verificaUsuario(token);
        
        LogErro log = new LogErro(usuario, new Timestamp(System.currentTimeMillis()), erro);
        
        try {
            LogErro logErro = LogErroDAO.create(log);
            
            String frase = "Um erro insperado foi encontrado, código: " + 
                    logErro.getId() + ". Anote esse código e entre em contato com " +
                    "o suporte para resolver.";
            
            switch (status) {
                case 304:
                    return Response.status(Response.Status.NOT_MODIFIED)
                            .entity(frase).build();
                case 400:
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity(frase).build();
                case 404:
                    return Response.status(Response.Status.NOT_FOUND)
                            .entity(frase).build();
                default:
                     return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(frase).build();
            }
            
        } catch (SQLException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao gerar o erro " + ex.getMessage()).build();
        }    
        
    }
    
    public static Usuario verificaUsuario(String token){
        
        try {
            int id = Token.getSubject(token);
            return UsuarioDAO.retreave(id);
        } catch (Exception ex) {
            Logger.getLogger(Resposta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }          
    }
}
