package persistence;

import constructor.NaturezaDespesa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class NaturezaDespesaDAO {

    private NaturezaDespesaDAO() {
    }

    public static NaturezaDespesa create(NaturezaDespesa natureza) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO naturezas_despesas (`codigo`, `subitem`, `descricao`) VALUES ('"
                + natureza.getCodigo() + "','"
                + natureza.getSubItem() + "','"
                + natureza.getDescricao() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        natureza.setId(rs.getInt(1));
        return natureza;
    }

    public static NaturezaDespesa retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM naturezas_despesas where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new NaturezaDespesa(id,
                rs.getString("codigo"),
                rs.getString("subitem"),
                rs.getString("descricao"));

    }

    public static ArrayList<NaturezaDespesa> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM naturezas_despesas";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<NaturezaDespesa> natureza = new ArrayList<>();
        while (rs.next()) {
            natureza.add(new NaturezaDespesa(
                    rs.getInt("id"),
                    rs.getString("codigo"),
                    rs.getString("subitem"),
                    rs.getString("descricao")));
        }
        rs.next();
        return natureza;
    }

    public static void delete(NaturezaDespesa natureza) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM naturezas_despesas WHERE `id`="
                + natureza.getId();
        stm.execute(sql);
    }

    public static void update(NaturezaDespesa natureza) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE naturezas_despesas SET "
                + "`codigo`='" + natureza.getCodigo()
                + "', `subitem`= '" + natureza.getSubItem()
                + "', `descricao`= '" + natureza.getDescricao()
                + "' WHERE `id`= "
                + natureza.getId();
        stm.execute(sql);
    }

}
