package persistence;

import constructor.EntradaItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class EntradaItemDAO {

    private EntradaItemDAO() {
    }

    public static EntradaItem create(EntradaItem entradaItem) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO entrada_itens (`produto`, `entrada`, `quantidade`,"
                + "`validade`, `lote`, `considerar_valorempenho`, `valor_unitario`) VALUES ('"
                + entradaItem.getProduto().getId() + "','"
                + entradaItem.getEntradaId() + "','"
                + entradaItem.getQtd() + "','"
                + entradaItem.getValidade() + "','"
                + entradaItem.getLote() + "','"
                + entradaItem.getConsiderarValorEmpenho() + "','"
                + entradaItem.getValor_unitario() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        entradaItem.setId(key);
        return entradaItem;
    }

    public static EntradaItem retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM entrada_itens where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new EntradaItem(id,
                ProdutoDAO.retreave(rs.getInt("produto")),
                rs.getInt("entrada"),
                rs.getDouble("quantidade"),
                rs.getTimestamp("validade"),
                rs.getString("lote"),
                rs.getInt("considerar_valorempenho"),
                rs.getDouble("valor_unitario"));
    }
    
    public static ArrayList<EntradaItem> retreaveByEntrada(int entradaId) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM entrada_itens where entrada = " + entradaId;
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<EntradaItem> entrada = new ArrayList<>();
        while (rs.next()) {
            entrada.add(new EntradaItem(
                    rs.getInt("id"),
                    ProdutoDAO.retreave(rs.getInt("produto")),
                    rs.getInt("entrada"),
                    rs.getDouble("quantidade"),
                    rs.getTimestamp("validade"),
                    rs.getString("lote"),
                    rs.getInt("considerar_valorempenho"),
                    rs.getDouble("valor_unitario")));
        }
        rs.next();
        return entrada;
    }

    public static ArrayList<EntradaItem> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM entrada_itens";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<EntradaItem> entrada = new ArrayList<>();
        while (rs.next()) {
            entrada.add(new EntradaItem(
                    rs.getInt("id"),
                    ProdutoDAO.retreave(rs.getInt("produto")),
                    rs.getInt("entrada"),
                    rs.getDouble("quantidade"),
                    rs.getTimestamp("validade"),
                    rs.getString("lote"),
                    rs.getInt("considerar_valorempenho"),
                    rs.getDouble("valor_unitario")));
        }
        rs.next();
        return entrada;
    }

    public static void delete(EntradaItem entrada) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM entrada_itens WHERE `id`="
                + entrada.getId();
        stm.execute(sql);
    }

    public static void update(EntradaItem entradaItem) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE entrada_itens SET "
                + "`produto` = '" + entradaItem.getProduto().getId()
                + "', `entrada` = '" + entradaItem.getEntradaId()
                + "', `quantidade` = '" + entradaItem.getQtd()
                + "', `validade` = '" + entradaItem.getValidade()
                + "', `lote` = '" + entradaItem.getLote()
                + "', `considerar_valorempenho` = '" + entradaItem.getConsiderarValorEmpenho()
                + "', `valor_unitario` = '" + entradaItem.getValor_unitario()
                + "' WHERE `id` = "
                + entradaItem.getId();
        stm.execute(sql);
    }

}
