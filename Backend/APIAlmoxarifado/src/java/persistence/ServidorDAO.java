package persistence;

import constructor.Servidor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class ServidorDAO {

    private ServidorDAO() {
    }

    public static int create(Servidor servidor) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO servidores (`nome`, `siape`, `funcao`) VALUES ('"
                + servidor.getNome() + "','"
                + servidor.getSiape() + "','"
                + servidor.getFuncao() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        servidor.setId(key);
        return key;
    }

    public static Servidor retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM servidores where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Servidor(id,
                rs.getString("nome"),
                rs.getString("siape"),
                rs.getString("funcao"));

    }

    public static ArrayList<Servidor> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM servidores";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Servidor> servidor = new ArrayList<>();
        while (rs.next()) {
            servidor.add(new Servidor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("siape"),
                    rs.getString("funcao")));
        }
        rs.next();
        return servidor;
    }

    public static void delete(Servidor servidor) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM servidores WHERE `id`="
                + servidor.getId();
        stm.execute(sql);
    }

    public static void update(Servidor servidor) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE servidores SET "
                + "`nome`='" + servidor.getNome()
                + "', `siape`= '" + servidor.getSiape()
                + "', `matricula`= '" + servidor.getFuncao()
                + "' WHERE `id`= "
                + servidor.getId();
        stm.execute(sql);
    }

}
