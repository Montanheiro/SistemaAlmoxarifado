package persistence;

import constructor.SaidaProduto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SaidaProdutoDAO {

    private SaidaProdutoDAO() {
    }

    public static SaidaProduto create(SaidaProduto saidaProduto) throws SQLException {
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
        saidaProduto.setId(rs.getInt(1));
        return saidaProduto;
    }

    public static SaidaProduto retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM saidas_produtos where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new SaidaProduto(id,
                RequisicaoProdutoDAO.retreave(rs.getInt("produto_requisicao")),
                rs.getDouble("quantidade"),
                rs.getTimestamp("data"));
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
                RequisicaoProdutoDAO.retreave(rs.getInt("produto_requisicao")),
                rs.getDouble("quantidade"),
                rs.getTimestamp("data")));
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
