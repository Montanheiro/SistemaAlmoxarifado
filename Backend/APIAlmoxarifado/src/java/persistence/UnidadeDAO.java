package persistence;

import constructor.Unidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class UnidadeDAO {

    private UnidadeDAO() {
    }

    public static Unidade create(Unidade unidade) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO unidades (`nome`, `abreviacao`) VALUES ('"
                + unidade.getNome() + "','"
                + unidade.getAbreviacao() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        unidade.setId(rs.getInt(1));
        return unidade;
    }

    public static Unidade retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM unidades where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Unidade(id,
                rs.getString("nome"),
                rs.getString("abreviacao"));

    }

    public static ArrayList<Unidade> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM unidades";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Unidade> unidade = new ArrayList<>();
        while (rs.next()) {
            unidade.add(new Unidade(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("abreviacao")));
        }
        rs.next();
        return unidade;
    }

    public static void delete(Unidade unidade) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM unidades WHERE `id`="
                + unidade.getId();
        stm.execute(sql);
    }

    public static void update(Unidade tipo) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE unidades SET "
                + "`nome`= '" + tipo.getNome()
                + "', `abreviacao`= '" + tipo.getAbreviacao()
                + "' WHERE `id`= "
                + tipo.getId();
        stm.execute(sql);
    }

}
