package persistence;

import constructor.Setor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class SetorDAO {

    private SetorDAO() {
    }

    public static int create(Setor setor) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO setores (`nome`, `sigla`) VALUES ('"
                + setor.getNome() + "','"
                + setor.getSigla() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        setor.setId(key);
        return key;
    }

    public static Setor retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM setores where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Setor(id,
                rs.getString("nome"),
                rs.getString("sigla"));

    }

    public static ArrayList<Setor> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM setores";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Setor> setor = new ArrayList<>();
        while (rs.next()) {
            setor.add(new Setor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("sigla")));
        }
        rs.next();
        return setor;
    }

    public static void delete(Setor setor) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM setores WHERE `id`="
                + setor.getId();
        stm.execute(sql);
    }

    public static void update(Setor setor) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE setores SET "
                + "`nome`='" + setor.getNome() + "'"
                + "`sigla`='" + setor.getSigla() + "'"
                + "' WHERE `id`= "
                + setor.getId();
        stm.execute(sql);
    }

}
