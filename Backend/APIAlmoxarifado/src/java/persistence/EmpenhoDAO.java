package persistence;

import constructor.Empenho;
import constructor.EmpenhoItem;
import constructor.ProdutoFornecedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpenhoDAO {

    private EmpenhoDAO() {
    }

    public static Empenho create(Empenho empenho) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO empenhos (`fornecedor`, `emissao`, `numero`, `observacao`, `valor_total`) VALUES ('"
                + empenho.getFornecedor().getId() + "','"
                + empenho.getEmissao() + "','"
                + empenho.getNumero() + "','"
                + empenho.getObservacao() + "','"
                + empenho.getValorTotal() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        empenho.setId(key);
        
        if(empenho.getItens() != null){
            for (EmpenhoItem item : empenho.getItens()) {
                item.setEmpenhoId(key);
                EmpenhoItemDAO.create(item);
                
                if(ProdutoFornecedorDAO.checkNotExist(
                        empenho.getFornecedor().getId(), 
                        item.getProduto().getId()))
                    ProdutoFornecedorDAO.create(
                            new ProdutoFornecedor(empenho.getFornecedor().getId(), 
                                    item.getProduto().getId()));
            }
        }
        
        return empenho;
    }

    public static Empenho retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM empenhos where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        ArrayList<EmpenhoItem> itens = EmpenhoItemDAO.retreaveByEmpenho(id);
        return new Empenho(id,
                FornecedorDAO.retreave(rs.getInt("fornecedor")),
                rs.getTimestamp("emissao"),
                rs.getString("numero"),
                rs.getString("observacao"),
                rs.getDouble("valor_total"),
                itens);

    }

    public static ArrayList<Empenho> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM empenhos";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Empenho> empenho = new ArrayList<>();
        while (rs.next()) {
            ArrayList<EmpenhoItem> itens = EmpenhoItemDAO.retreaveByEmpenho(rs.getInt("id"));
            empenho.add(new Empenho(
                    rs.getInt("id"),
                    FornecedorDAO.retreave(rs.getInt("fornecedor")),
                    rs.getTimestamp("emissao"),
                    rs.getString("numero"),
                    rs.getString("observacao"),
                    rs.getDouble("valor_total"),
                    itens));
        }
        rs.next();
        return empenho;
    }

    public static void delete(Empenho empenho) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM empenhos WHERE `id`="
                + empenho.getId();
        stm.execute(sql);
    }

    public static void update(Empenho empenho) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE empenhos SET "
                + "`fornecedor` = '" + empenho.getFornecedor().getId()
                + "', `emissao` = '" + empenho.getEmissao()
                + "', `numero` = '" + empenho.getNumero()
                + "', `observacao` = '" + empenho.getObservacao()
                + "', `valor_total` = '" + empenho.getValorTotal()
                + "' WHERE `id` = "
                + empenho.getId();
        stm.execute(sql);
        
        for (EmpenhoItem item : empenho.getItens()) {
            if (item.getId() != 0) {
                EmpenhoItemDAO.update(item);
            } else {
                item.setEmpenhoId(empenho.getId());
                EmpenhoItemDAO.create(item);
            }
        }
    }

}
