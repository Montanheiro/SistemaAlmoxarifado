package persistence;

import constructor.Saida;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class SaidaDAO {

    private SaidaDAO() {
    }

    public static int create(Saida saida) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO saidas (`quantidade_geral`, `preco_unitario`, `requisicao`) VALUES ('"
                + saida.getQtdGeral() + "','"
                + saida.getPrecoUnitario() + "','"
                + saida.getRequisicao() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        saida.setId(key);
        return key;
    }

    public static Saida retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM saidas where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Saida(id,
                rs.getDouble("quantidade_geral"),
                rs.getDouble("preco_unitario"),
                rs.getInt("requisicao"));

    }

    public static ArrayList<Saida> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM saidas";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Saida> saida = new ArrayList<>();
        while (rs.next()) {
            saida.add(new Saida(
                    rs.getInt("id"),
                    rs.getDouble("quantidade_geral"),
                    rs.getDouble("preco_unitario"),
                    rs.getInt("requisicao")));
        }
        rs.next();
        return saida;
    }

    public static void delete(Saida saida) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM saidas WHERE `id`="
                + saida.getId();
        stm.execute(sql);
    }

    public static void update(Saida saida) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE saidas SET "
                + "`quantidade_geral`='" + saida.getQtdGeral()
                + "', `preco_unitario`= '" + saida.getPrecoUnitario()
                + "', `requisicao`= '" + saida.getRequisicao()
                + "' WHERE `id`= "
                + saida.getId();
        stm.execute(sql);
    }

}
