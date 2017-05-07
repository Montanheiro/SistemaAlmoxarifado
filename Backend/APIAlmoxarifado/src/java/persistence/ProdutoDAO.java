package persistence;

import constructor.Produto;
import constructor.Unidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class ProdutoDAO {

    private ProdutoDAO() {
    }

    public static Produto create(Produto produto) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO produtos (`descricao`, `unidade`) VALUES ('"
                + produto.getDescricao() + "','"
                + produto.getUnidade().getId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        produto.setId(key);
        return produto;
    }

    public static Produto retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produtos where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Unidade un = UnidadeDAO.retreave(rs.getInt("unidade"));
        return new Produto(id,
                rs.getString("descricao"),
                un);

    }

    public static ArrayList<Produto> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produtos";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Produto> produto = new ArrayList<>();
        while (rs.next()) {
            Unidade un = UnidadeDAO.retreave(rs.getInt("unidade"));
            produto.add(new Produto(
                    rs.getInt("id"),
                    rs.getString("descricao"),
                    un));
        }
        rs.next();
        return produto;
    }

    public static void delete(Produto produto) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM produtos WHERE `id`="
                + produto.getId();
        stm.execute(sql);
    }

    public static void update(Produto produto) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE produtos SET "
                + "`descricao`='" + produto.getDescricao()
                + "', `unidade`= '" + produto.getUnidade().getId()
                + "' WHERE `id`= "
                + produto.getId();
        stm.execute(sql);
    }

}
