package persistence;

import constructor.Entrada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class EntradaDAO {

    private EntradaDAO() {
    }

    public static int create(Entrada entrada) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO entradas (`quantidade`, `preco_unitario`, `data`, `validade`, `lote`, `nf_numero`) VALUES ('"
                + entrada.getQtd() + "','"
                + entrada.getPrecoUnitario() + "','"
                + entrada.getData() + "','"
                + entrada.getValidade() + "','"
                + entrada.getLote() + "','"
                + entrada.getNfNumero() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        entrada.setId(key);
        return key;
    }

    public static Entrada retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM entradas where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Entrada(id,
                rs.getDouble("quantidade"),
                rs.getDouble("preco_unitario"),
                rs.getDate("data"),
                rs.getInt("produto"));

    }

    public static ArrayList<Entrada> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM entradas";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Entrada> entrada = new ArrayList<>();
        while (rs.next()) {
            entrada.add(new Entrada(
                    rs.getInt("id"),
                    rs.getDouble("quantidade"),
                    rs.getDouble("preco_unitario"),
                    rs.getInt("produto"),
                    rs.getDate("data")));
        }
        rs.next();
        return entrada;
    }

    public static void delete(Entrada entrada) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM entradas WHERE `id`="
                + entrada.getId();
        stm.execute(sql);
    }

    public static void update(Entrada entrada) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE entradas SET "
                + "`quantidade`='" + entrada.getQtd()
                + "', `preco_unitario`= '" + entrada.getPrecoUnitario()
                + "', `produto`= '" + entrada.getProduto()
                + "', `data`= '" + entrada.getData()
                + "' WHERE `id`= "
                + entrada.getId();
        stm.execute(sql);
    }

}
