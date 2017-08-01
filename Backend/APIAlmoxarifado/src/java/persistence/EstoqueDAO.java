package persistence;

import constructor.Estoque;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class EstoqueDAO {

    private EstoqueDAO() {
    }

    public static Estoque create(Estoque estoque) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO estoque (`produto`, `minimo`, `quantidade`) VALUES ('"
                + estoque.getProduto().getId() + "','"
                + estoque.getMinimo() + "','"
                + estoque.getQtd() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        estoque.setId(key);
        return estoque;
    }

    public static Estoque retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM estoque where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Estoque(id,
                ProdutoDAO.retreave(rs.getInt("produto")),
                rs.getDouble("minimo"),
                rs.getDouble("quantidade"));

    }

    public static ArrayList<Estoque> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM estoque";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Estoque> estoque = new ArrayList<>();
        while (rs.next()) {
            estoque.add(new Estoque(
                    rs.getInt("id"),
                    ProdutoDAO.retreave(rs.getInt("produto")),
                    rs.getDouble("minimo"),
                    rs.getDouble("quantidade")));
        }
        rs.next();
        return estoque;
    }

    public static void delete(Estoque estoque) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM estoque WHERE `id`="
                + estoque.getId();
        stm.execute(sql);
    }

    public static void update(Estoque estoque) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE estoque SET "
                + "`produto`='" + estoque.getProduto().getId()
                + "', `minimo`= '" + estoque.getMinimo()
                + "', `quantidade`= '" + estoque.getQtd()
                + "' WHERE `id`= "
                + estoque.getId();
        stm.execute(sql);
    }

}
