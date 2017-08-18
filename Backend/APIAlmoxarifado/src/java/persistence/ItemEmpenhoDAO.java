package persistence;

import constructor.ItemEmpenho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemEmpenhoDAO {

    private ItemEmpenhoDAO() {
    }

    public static ItemEmpenho create(ItemEmpenho item) throws SQLException {
        Statement stm = Database.createConnection().createStatement();
        String sql
                = "INSERT INTO itens_empenho (`empenho`, `natureza_despesa`,"
                + "`sequencia`, `quantidade`, `valor_unitario`, `item_processo`) VALUES ('"
                + item.getEmpenhoId() + "','"
                + item.getNaturezaDespesa().getId() + "','"
                + item.getSequencia() + "','"
                + item.getQtd() + "','"
                + item.getValorUnitario() + "','"
                + item.getItemProcesso() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        item.setId(rs.getInt(1));
        return item;
    }

    public static ItemEmpenho retreave(int id) throws SQLException {
        Statement stm = Database.createConnection().createStatement();
        String sql = "SELECT * FROM itens_empenho where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new ItemEmpenho(id,
                rs.getInt("empenho"),
                NaturezaDespesaDAO.retreave(rs.getInt("natureza_despesa")),
                ProdutoDAO.retreave(rs.getInt("produto")),
                rs.getInt("sequencia"),
                rs.getDouble("quantidade"),
                rs.getDouble("valor_unitario"),
                rs.getString("item_processo"));

    }
    
    public static ArrayList<ItemEmpenho> retreaveByEmpenho(int empenhoId) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM itens_empenho WHERE empenho = " + empenhoId;
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<ItemEmpenho> temp = new ArrayList<>();
        while (rs.next()) {
            temp.add(new ItemEmpenho(
                    rs.getInt("id"),
                    rs.getInt("empenho"),
                    NaturezaDespesaDAO.retreave(rs.getInt("natureza_despesa")),
                    ProdutoDAO.retreave(rs.getInt("produto")),
                    rs.getInt("sequencia"),
                    rs.getDouble("quantidade"),
                    rs.getDouble("valor_unitario"),
                    rs.getString("item_processo")));
        }
        return temp;
    }

    public static ArrayList<ItemEmpenho> retreaveAll() throws SQLException {
        Statement stm = Database.createConnection().createStatement();
        String sql = "SELECT * FROM itens_empenho";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<ItemEmpenho> pe = new ArrayList<>();
        while (rs.next()) {
            pe.add(new ItemEmpenho(
                    rs.getInt("id"),
                    rs.getInt("empenho"),
                    NaturezaDespesaDAO.retreave(rs.getInt("natureza_despesa")),
                    ProdutoDAO.retreave(rs.getInt("produto")),
                    rs.getInt("sequencia"),
                    rs.getDouble("quantidade"),
                    rs.getDouble("valor_unitario"),
                    rs.getString("item_processo")));
        }
        rs.next();
        return pe;
    }
 
    public static void delete(ItemEmpenho pe) throws SQLException {
        Statement stm = Database.createConnection().createStatement();
        String sql = "DELETE FROM itens_empenho WHERE `id`= " + pe.getId();
        stm.execute(sql);
    }

    public static void update(ItemEmpenho pe) throws SQLException {
        Statement stm = Database.createConnection().createStatement();
        String sql = "UPDATE itens_empenho SET "
                + "`empenho` = '" + pe.getEmpenhoId()
                + "', `natureza_despesa` = '" + pe.getNaturezaDespesa().getId()
                + "', `produto` = '" + pe.getProduto().getId()
                + "', `sequencia` = '" + pe.getSequencia()
                + "', `quantidade` = '" + pe.getQtd()
                + "', `valor_unitario` = '" + pe.getValorUnitario()
                + "', `item_processo` = '" + pe.getItemProcesso()
                + "' WHERE `id` = "
                + pe.getId();
        stm.execute(sql);
    }

}
