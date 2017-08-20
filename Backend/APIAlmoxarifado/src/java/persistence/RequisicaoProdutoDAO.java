package persistence;

import constructor.RequisicaoProduto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class RequisicaoProdutoDAO {

    private RequisicaoProdutoDAO() {
    }

    public static RequisicaoProduto create(RequisicaoProduto pr) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO produtos_requisicoes (`requisicao`, `produto`, `quantidade`) VALUES ('"
                + pr.getRequisicaoId() + "','"
                + pr.getProduto().getId() + "','"
                + pr.getQtd() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        pr.setId(rs.getInt(1));
        return pr;
    }

    public static RequisicaoProduto retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produtos_requisicoes where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new RequisicaoProduto(id,
                rs.getInt("requisicao"),
                ProdutoDAO.retreave(rs.getInt("produto")),
                rs.getDouble("quantidade"));
    }

    public static ArrayList<RequisicaoProduto> retreaveByRequisicao(int requisicaoId) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produtos_requisicoes WHERE requisicao = " + requisicaoId;
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<RequisicaoProduto> pr = new ArrayList<>();
        while (rs.next()) {
            pr.add(new RequisicaoProduto(
                    rs.getInt("id"),
                    rs.getInt("requisicao"),
                    ProdutoDAO.retreave(rs.getInt("produto")),
                    rs.getDouble("quantidade")));
        }
        rs.next();
        return pr;
    }
    
    public static ArrayList<RequisicaoProduto> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produtos_requisicoes";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<RequisicaoProduto> pr = new ArrayList<>();
        while (rs.next()) {
            pr.add(new RequisicaoProduto(
                    rs.getInt("id"),
                    rs.getInt("requisicao"),
                    ProdutoDAO.retreave(rs.getInt("produto")),
                    rs.getDouble("quantidade")));
        }
        rs.next();
        return pr;
    }

    public static void delete(RequisicaoProduto pr) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM produtos_requisicoes WHERE `id`="
                + pr.getId();
        stm.execute(sql);
    }

    public static void update(RequisicaoProduto pr) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE produtos_requisicoes SET "
                + "`requisicao`='" + pr.getRequisicaoId()
                + "', `produto`= '" + pr.getProduto().getId()
                + "', `quantidade`= '" + pr.getQtd()
                + "' WHERE `id`= "
                + pr.getId();
        stm.execute(sql);
    }

}
