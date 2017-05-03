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
                = "INSERT INTO saidas (`requisicao`, `quantidade_geral`, `preco_unitario`) VALUES ('"
                + saida.getRequisicao().getId() + "','"
                + saida.getQtdGeral() + "','"
                + saida.getPrecoUnitario() + "')";

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
                RequisicaoDAO.retreave(rs.getInt("requisicao")),
                rs.getDouble("quantidade_geral"),
                rs.getDouble("preco_unitario"));
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
                    RequisicaoDAO.retreave(rs.getInt("requisicao")),
                    rs.getDouble("quantidade_geral"),
                    rs.getDouble("preco_unitario")));
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
                + "`requisicao`='" + saida.getRequisicao().getId()
                + "', `quantidade_geral`= '" + saida.getQtdGeral()
                + "', `preco_unitario`= '" + saida.getPrecoUnitario()
                + "' WHERE `id`= "
                + saida.getId();
        stm.execute(sql);
    }

}
