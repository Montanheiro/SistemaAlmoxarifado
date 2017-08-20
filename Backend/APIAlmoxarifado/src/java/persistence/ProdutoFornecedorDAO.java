package persistence;

import constructor.ProdutoFornecedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoFornecedorDAO {
 
    public static ProdutoFornecedor create(ProdutoFornecedor pf) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO `produtos_fornecedores` (`fornecedor`, `produto`) VALUES ("
                + pf.getFornecedorId()+ ","
                + pf.getProdutoId()+ ")";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        pf.setId(key);
        return pf;
    }

    public static ProdutoFornecedor retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produtos_fornecedores where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new ProdutoFornecedor(id,
                rs.getInt("fornecedor"),
                rs.getInt("produto"));

    }
    
    public static Boolean checkNotExist(int fornecedorId, int produtoId) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produtos_fornecedores where fornecedor = " + fornecedorId 
                + " AND produto = " + produtoId;
        ResultSet rs = stm.executeQuery(sql);
        return !rs.next();

    }

    public static ArrayList<ProdutoFornecedor> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produtos_fornecedores";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<ProdutoFornecedor> pf = new ArrayList<>();
        while (rs.next()) {
            pf.add(new ProdutoFornecedor(
                    rs.getInt("id"),
                    rs.getInt("fornecedor"),
                    rs.getInt("produto")));
        }
        rs.next();
        return pf;
    }

    public static void delete(ProdutoFornecedor pf) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM produtos_fornecedores WHERE `id`="
                + pf.getId();
        stm.execute(sql);
    }

    public static void update(ProdutoFornecedor pf) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE produtos_fornecedores SET "
                + "`fornecedor` = " + pf.getFornecedorId()
                + ", `produto` = " + pf.getProdutoId()
                + " WHERE `id` = "
                + pf.getId();
        stm.execute(sql);
    }
                    
}
