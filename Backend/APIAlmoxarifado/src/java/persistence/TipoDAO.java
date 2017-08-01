package persistence;

import constructor.Tipo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class TipoDAO {

    private TipoDAO() {
    }

    public static Tipo create(Tipo tipo) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO tipos (`tipo`) VALUES ('"
                + tipo.getTipo() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        tipo.setId(rs.getInt(1));
        return tipo;
    }

    public static Tipo retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM tipos where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Tipo(id,
                rs.getString("tipo"));

    }

    public static ArrayList<Tipo> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM tipos";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Tipo> tipo = new ArrayList<>();
        while (rs.next()) {
            tipo.add(new Tipo(
                    rs.getInt("id"),
                    rs.getString("tipo")));
        }
        rs.next();
        return tipo;
    }

    public static void delete(Tipo tipo) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM tipos WHERE `id`="
                + tipo.getId();
        stm.execute(sql);
    }

    public static void update(Tipo tipo) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE tipos SET "
                + "`tipo`= '" + tipo.getTipo()
                + "' WHERE `id`= " + tipo.getId();
        stm.execute(sql);
    }

}
