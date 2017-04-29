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

    public static int create(Estoque estoque) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO Estoque (`produto`, `minimo`, `quantidade`) VALUES ('"
                + estoque.getProduto() + "','"
                + estoque.getMinimo() + "','"
                + estoque.getQtd() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        estoque.setId(key);
        return key;
    }

    public static Estoque retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM Estoque where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Estoque(id,
                rs.getInt("produto"),
                rs.getDouble("minimo"),
                rs.getDouble("quantidade"));

    }

    public static ArrayList<Estoque> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM Estoque";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Estoque> estoque = new ArrayList<>();
        while (rs.next()) {
            estoque.add(new Estoque(
                    rs.getInt("id"),
                rs.getInt("produto"),
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
        String sql = "DELETE FROM Estoque WHERE `id`="
                + estoque.getId();
        stm.execute(sql);
    }

    public static void update(Estoque estoque) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE Estoque SET "
                + "`produto`='" + estoque.getProduto()
                + "', `minimo`= '" + estoque.getMinimo()
                + "', `quantidade`= '" + estoque.getQtd()
                + "' WHERE `id`= "
                + estoque.getId();
        stm.execute(sql);
    }

}
