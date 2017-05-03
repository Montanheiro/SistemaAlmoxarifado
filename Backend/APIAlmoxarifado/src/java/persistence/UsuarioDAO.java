package persistence;

import constructor.Usuario;
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

    public static int create(Usuario usuario) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO usuarios (`email`, `senha`, `servidor`) VALUES ('"
                + usuario.getEmail() + "','"
                + usuario.getSenha() + "','"
                + usuario.getServidor().getId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        usuario.setId(key);
        return key;
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
                rs.getString("senha"),
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
                    rs.getString("senha"),
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

    public static void update(Usuario usuario) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE usuarios SET "
                + "`email`= '" + usuario.getEmail()
                + "', `senha`= '" + usuario.getSenha()
                + "', `servidor`= '" + usuario.getServidor().getId()
                + " ' WHERE `id`= "
                + usuario.getId();
        stm.execute(sql);
    }

}
