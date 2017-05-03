package persistence;

import constructor.ProdutoEmpenho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class ProdutoEmpenhoDAO {
    
    
    private ProdutoEmpenhoDAO() {
    }

    public static int create(ProdutoEmpenho pe) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO produtos_empenho (`empenho`, `natureza_despesa`, `produto`, `sequencia`, `qtd`, `valor_unitario`, `valor_sequencia`, `item_processo`, `item_material`) VALUES ('"
                + pe.getEmpenho().getId() + "','"
                + pe.getNaturezaDespesa().getId()+ "','"
                + pe.getProduto().getId()+ "','"
                + pe.getSequencia()+ "','"
                + pe.getQtd()+ "','"
                + pe.getValorUnitario()+ "','"
                + pe.getValorSequencia()+ "','"
                + pe.getItemProcesso()+ "','"
                + pe.getItemMaterial()+ "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        pe.setId(key);
        return key;
    }

    public static ProdutoEmpenho retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produtos_empenho where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new ProdutoEmpenho(id,
                EmpenhoDAO.retreave(rs.getInt("empenho")),
                rs.getDouble("quantidade"),
                rs.getDouble("preco_unitario"),
                rs.getDate("data"),
                rs.getInt("produto"));

    }

    public static ArrayList<ProdutoEmpenho> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produtos_empenho";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<ProdutoEmpenho> pe = new ArrayList<>();
        while (rs.next()) {
            pe.add(new ProdutoEmpenho(
                    rs.getInt("id"),
                    ProdutoEmpenhoDAO.retreave(rs.getInt("produto_empenho")),
                    rs.getDouble("quantidade"),
                    rs.getDouble("preco_unitario"),
                    rs.getDate("data"),
                    rs.getInt("produto")));
        }
        rs.next();
        return pe;
    }

    public static void delete(ProdutoEmpenho pe) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM produtos_empenho WHERE `id`="
                + pe.getId();
        stm.execute(sql);
    }

    public static void update(ProdutoEmpenho pe) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE produtos_empenho SET "
                + "`produto_empenho` = '" + pe.getProdutoEmpenho().getId()
                + "', `quantidade` = '" + pe.getQtd()
                + "', `preco_unitario` = '" + pe.getPrecoUnitario()
                + "', `data` = '" + pe.getData()
                + "', `validade` = '" + pe.getValidade()
                + "', `lote` = '" + pe.getLote()
                + "', `nf_numero` = '" + pe.getNfNumero()
                + "' WHERE `id` = "
                + pe.getId();
        stm.execute(sql);
    }

}
