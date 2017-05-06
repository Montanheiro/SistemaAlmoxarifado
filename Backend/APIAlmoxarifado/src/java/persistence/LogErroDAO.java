/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.LogErro;
import constructor.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class LogErroDAO {
    
    public static int create(LogErro logErro) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO logs_erros (`usuario`, `data`, `erro`) VALUES ('"
                + logErro.getUsuario().getId() + "','"
                + new Timestamp((System.currentTimeMillis()/1000)*1000) + "','"
                + logErro.getErro() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        return key;
    }
    
    public static LogErro retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM logs_erros where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Usuario usuario = UsuarioDAO.retreave(rs.getInt("id"));
        return new LogErro(id, 
                usuario, 
                rs.getTimestamp("data"), 
                rs.getString("erro"));

    }
    
        public static ArrayList<LogErro> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM logs_erros";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<LogErro> logErro = new ArrayList<>();
        while (rs.next()) {
            Usuario usuario = UsuarioDAO.retreave(rs.getInt("id"));
            logErro.add(new LogErro(
                    rs.getInt("id"),
                    usuario, 
                    rs.getTimestamp("data"), 
                    rs.getString("erro")));
        }
        rs.next();
        return logErro;
    }
    
}
