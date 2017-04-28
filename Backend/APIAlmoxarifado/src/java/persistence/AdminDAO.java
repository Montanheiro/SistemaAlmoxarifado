/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import constructor.Admin;
import business.Token;

/**
 *
 * @author lucas
 */
public class AdminDAO {  
    
    public static Admin create(Admin a) throws SQLException {
            Statement stm
                    = Database.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO admin (`user`, `password`, `created`, `status` , `type`) VALUES ('"
                    + a.getUser() + "','"
                    + a.getPassword() + "','"
                    + a.getCreated() + "','" 
                    + a.getStatus() + "','"
                    + a.getType() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            a.setId(key);
            return a;
    }

    public static Admin retreave(int id) throws SQLException {
            Statement stm
                    = Database.createConnection().
                            createStatement();
            String sql = "SELECT * FROM admin where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            return new Admin(
                    id, 
                    rs.getString("user"), 
                    rs.getTimestamp("created"), 
                    rs.getInt("status"),
                    rs.getInt("type"));
                    
    }
    
    public static Admin retreave(String user, String password) throws SQLException, 
            NoSuchAlgorithmException, UnsupportedEncodingException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM admin WHERE user = '" + user 
                + "' AND password = '" + new Token().Password(password) + "' AND status = 1";
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        
        return new Admin(
                rs.getInt("id"),
                rs.getString("user"), 
                rs.getTimestamp("created"), 
                rs.getInt("status"),
                rs.getInt("type"));
    }

    public static ArrayList<Admin> retreaveAll() throws SQLException {
            Statement stm
                    = Database.createConnection().
                            createStatement();
            String sql = "SELECT * FROM admin";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Admin> a = new ArrayList<>();
            while (rs.next()) {
                a.add(new Admin(
                    rs.getInt("id"),
                    rs.getString("user"), 
                    rs.getTimestamp("created"), 
                    rs.getInt("status"),
                    rs.getInt("type")));
            }
            rs.next();
            return a;
    }
    
    public static void update(Admin a) throws SQLException {
            Statement stm
                    = Database.createConnection().
                            createStatement();
            String sql = "UPDATE admin SET "
                    + "`user`='" + a.getUser() + "',"
                    + "`created`='" + a.getCreated() + "',"
                    + "`status`=" + a.getStatus() + " , "
                    + "`type`=" + a.getType()
                    + " WHERE `id`= " + a.getId();
            stm.execute(sql);
    }
    
    public static void updatePassword(Admin a) throws SQLException, 
            NoSuchAlgorithmException, UnsupportedEncodingException {
            Statement stm
                    = Database.createConnection().
                            createStatement();
            String sql = "UPDATE admin SET "
                    + "`password`='" + new Token().Password(a.getPassword()) + "'"
                    + " WHERE `id`= " + a.getId();
            stm.execute(sql);
    }

    public static void delete(Admin a) throws SQLException {
            Statement stm
                    = Database.createConnection().
                            createStatement();
            String sql = "DELETE FROM admin WHERE `id`=" + a.getId();
            stm.execute(sql);
    }

}
