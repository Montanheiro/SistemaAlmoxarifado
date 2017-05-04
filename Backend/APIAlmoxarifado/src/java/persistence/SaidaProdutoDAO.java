package persistence;

import constructor.SaidaProduto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class SaidaProdutoDAO {

    private SaidaProdutoDAO() {
    }

    public static int create(SaidaProduto saidaProduto) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO saidas_produtos (`produto_requisicao`, `quantidade`, `data`) VALUES ('"
                + saidaProduto.getProdutoRequisicao().getId() + "','"
                + saidaProduto.getQtd() + "','"
                + saidaProduto.getData() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        saidaProduto.setId(key);
        return key;
    }

    public static SaidaProduto retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM saidas_produtos where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new SaidaProduto(id,
                ProdutoRequisicaoDAO.retreave(rs.getInt("produto_requisicao")),
                rs.getDouble("quantidade"),
                rs.getDate("data"));
    }

    public static ArrayList<SaidaProduto> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM saidas_produtos";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<SaidaProduto> saidaProduto = new ArrayList<>();
        while (rs.next()) {
            saidaProduto.add(new SaidaProduto(
                    rs.getInt("id"),
                ProdutoRequisicaoDAO.retreave(rs.getInt("produto_requisicao")),
                rs.getDouble("quantidade"),
                rs.getDate("data")));
        }
        rs.next();
        return saidaProduto;
    }

    public static void delete(SaidaProduto saidaProduto) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM saidas_produtos WHERE `id`="
                + saidaProduto.getId();
        stm.execute(sql);
    }

    public static void update(SaidaProduto saidaProduto) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE saidas_produtos SET "
                + "`produto_requisicao`='" + saidaProduto.getProdutoRequisicao().getId()
                + "', `quantidade`= '" + saidaProduto.getQtd()
                + "', `data`= '" + saidaProduto.getData()
                + "' WHERE `id`= "
                + saidaProduto.getId();
        stm.execute(sql);
    }

}
