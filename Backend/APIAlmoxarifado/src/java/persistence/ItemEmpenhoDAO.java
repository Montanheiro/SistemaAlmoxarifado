package persistence;

import constructor.ItemEmpenho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class ItemEmpenhoDAO {

    private ItemEmpenhoDAO() {
    }

    public static ItemEmpenho create(ItemEmpenho item) throws SQLException {
        Statement stm = Database.createConnection().createStatement();
        String sql
                = "INSERT INTO produtos_empenho (`empenho`, `natureza_despesa`,"
                + "`sequencia`, `quantidade`, `valor_sequencia`, `item_processo`) VALUES ('"
                + item.getEmpenho().getId() + "','"
                + item.getNaturezaDespesa().getId() + "','"
                + item.getSequencia() + "','"
                + item.getQtd() + "','"
                + item.getValorSequencia() + "','"
                + item.getItemProcesso() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        item.setId(rs.getInt(1));
        return item;
    }

    public static ItemEmpenho retreave(int id) throws SQLException {
        Statement stm = Database.createConnection().createStatement();
        String sql = "SELECT * FROM produtos_empenho where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new ItemEmpenho(id,
                EmpenhoDAO.retreave(rs.getInt("empenho")),
                NaturezaDespesaDAO.retreave(rs.getInt("natureza_despesa")),
                rs.getInt("sequencia"),
                rs.getDouble("quantidade"),
                rs.getDouble("valor_sequencia"),
                rs.getString("item_processo"));

    }

    public static ArrayList<ItemEmpenho> retreaveAll() throws SQLException {
        Statement stm = Database.createConnection().createStatement();
        String sql = "SELECT * FROM produtos_empenho";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<ItemEmpenho> pe = new ArrayList<>();
        while (rs.next()) {
            pe.add(new ItemEmpenho(
                    rs.getInt("id"),
                    EmpenhoDAO.retreave(rs.getInt("empenho")),
                    NaturezaDespesaDAO.retreave(rs.getInt("natureza_despesa")),
                    rs.getInt("sequencia"),
                    rs.getDouble("quantidade"),
                    rs.getDouble("valor_sequencia"),
                    rs.getString("item_processo")));
        }
        rs.next();
        return pe;
    }
 
    public static void delete(ItemEmpenho pe) throws SQLException {
        Statement stm = Database.createConnection().createStatement();
        String sql = "DELETE FROM produtos_empenho WHERE `id`= " + pe.getId();
        stm.execute(sql);
    }

    public static void update(ItemEmpenho pe) throws SQLException {
        Statement stm = Database.createConnection().createStatement();
        String sql = "UPDATE produtos_empenho SET "
                + "`empenho` = '" + pe.getEmpenho().getId()
                + "', `natureza_despesa` = '" + pe.getNaturezaDespesa().getId()
                + "', `sequencia` = '" + pe.getSequencia()
                + "', `quantidade` = '" + pe.getQtd()
                + "', `valor_sequencia` = '" + pe.getValorSequencia()
                + "', `item_processo` = '" + pe.getItemProcesso()
                + "' WHERE `id` = "
                + pe.getId();
        stm.execute(sql);
    }

}
