package persistence;

import constructor.ProdutoRequisicao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class ProdutoRequisicaoDAO {

    private ProdutoRequisicaoDAO() {
    }

    public static ProdutoRequisicao create(ProdutoRequisicao pr) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO produtos_requisicoes (`requisicao`, `produto`, `quantidade`) VALUES ('"
                + pr.getRequisicao().getId() + "','"
                + pr.getProduto().getId() + "','"
                + pr.getQtd() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        pr.setId(rs.getInt(1));
        return pr;
    }

    public static ProdutoRequisicao retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produtos_requisicoes where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new ProdutoRequisicao(id,
                RequisicaoDAO.retreave(rs.getInt("requisicao")),
                ProdutoDAO.retreave(rs.getInt("produto")),
                rs.getDouble("quantidade"));
    }

    public static ArrayList<ProdutoRequisicao> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produtos_requisicoes";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<ProdutoRequisicao> pr = new ArrayList<>();
        while (rs.next()) {
            pr.add(new ProdutoRequisicao(
                    rs.getInt("id"),
                    RequisicaoDAO.retreave(rs.getInt("requisicao")),
                    ProdutoDAO.retreave(rs.getInt("produto")),
                    rs.getDouble("quantidade")));
        }
        rs.next();
        return pr;
    }

    public static void delete(ProdutoRequisicao pr) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM produtos_requisicoes WHERE `id`="
                + pr.getId();
        stm.execute(sql);
    }

    public static void update(ProdutoRequisicao pr) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE produtos_requisicoes SET "
                + "`requisicao`='" + pr.getRequisicao().getId()
                + "', `produto`= '" + pr.getProduto().getId()
                + "', `quantidade`= '" + pr.getQtd()
                + "' WHERE `id`= "
                + pr.getId();
        stm.execute(sql);
    }

}
