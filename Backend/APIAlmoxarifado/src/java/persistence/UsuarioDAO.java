package persistence;

import business.Token;
import constructor.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class UsuarioDAO {

    private UsuarioDAO() {
    }

    public static Usuario create(Usuario usuario) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO usuarios (`email`, `senha`, `status`, `admin`, `servidor`) VALUES ('"
                + usuario.getEmail() + "','"
                + usuario.getSenha() + "','"
                + usuario.isAtivo() + "','"
                + usuario.isAdmin() + "','"
                + usuario.getServidor().getId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        usuario.setId(rs.getInt(1));
        return usuario;
    }

    public static Usuario retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM usuarios where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Usuario(id,
                rs.getString("email"),
                rs.getInt("ativo"),
                rs.getInt("admin"),
                ServidorDAO.retreave(rs.getInt("servidor")));
    }
    
    public static Usuario retreaveLogin(String email, String senha) throws SQLException,
            NoSuchAlgorithmException, UnsupportedEncodingException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM usuarios where email = '" + email
                + "' AND senha = '" + new Token().Password(senha) + "' AND ativo = 1";
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Usuario(
                rs.getInt("id"),
                rs.getString("email"),
                rs.getInt("ativo"),
                rs.getInt("admin"),
                ServidorDAO.retreave(rs.getInt("servidor")));
    }

    public static ArrayList<Usuario> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM usuarios";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Usuario> usuario = new ArrayList<>();
        while (rs.next()) {
            usuario.add(new Usuario(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getInt("ativo"),
                    rs.getInt("admin"),
                    ServidorDAO.retreave(rs.getInt("servidor"))));
        }
        rs.next();
        return usuario;
    }

    public static void delete(Usuario usuario) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM usuarios WHERE `id`="
                + usuario.getId();
        stm.execute(sql);
    }

    public static void update(Usuario usuario) throws SQLException, 
            NoSuchAlgorithmException, UnsupportedEncodingException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE usuarios SET "
                + "`email`= '" + usuario.getEmail()
                + "', `ativo`= '" + usuario.isAtivo()
                + "', `admin`= '" + usuario.isAdmin()
                + "', `servidor`= '" + usuario.getServidor().getId()
                + " ' WHERE `id`= "
                + usuario.getId();
        stm.execute(sql);
    }
    
        public static void updatePassword(Usuario u) throws SQLException, 
            NoSuchAlgorithmException, UnsupportedEncodingException {
            Statement stm
                    = Database.createConnection().
                            createStatement();
            String sql = "UPDATE usuarios SET "
                    + "`senha`='" + new Token().Password(u.getSenha()) + "'"
                    + " WHERE `id`= " + u.getId();
            stm.execute(sql);
    }

}
