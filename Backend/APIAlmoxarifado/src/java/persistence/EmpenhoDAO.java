package persistence;

import constructor.Empenho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class EmpenhoDAO {

    private EmpenhoDAO() {
    }

    public static Empenho create(Empenho empenho) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO empenhos (`fornecedor`, `emissao`, `numero`, `observacao`, `valor_total`) VALUES ('"
                + empenho.getFornecedor().getId() + "','"
                + empenho.getEmissao() + "','"
                + empenho.getNumero() + "','"
                + empenho.getObservacao() + "','"
                + empenho.getValorTotal() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        empenho.setId(key);
        return empenho;
    }

    public static Empenho retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM empenhos where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Empenho(id,
                FornecedorDAO.retreave(rs.getInt("fornecedor")),
                rs.getDate("emissao"),
                rs.getString("numero"),
                rs.getString("observacao"),
                rs.getDouble("valor_total"));

    }

    public static ArrayList<Empenho> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM empenhos";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Empenho> empenho = new ArrayList<>();
        while (rs.next()) {
            empenho.add(new Empenho(
                    rs.getInt("id"),
                    FornecedorDAO.retreave(rs.getInt("fornecedor")),
                    rs.getDate("emissao"),
                    rs.getString("numero"),
                    rs.getString("observacao"),
                    rs.getDouble("valor_total")));
        }
        rs.next();
        return empenho;
    }

    public static void delete(Empenho empenho) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM empenhos WHERE `id`="
                + empenho.getId();
        stm.execute(sql);
    }

    public static void update(Empenho empenho) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE empenhos SET "
                + "`fornecedor` = '" + empenho.getFornecedor().getId()
                + "', `emissao` = '" + empenho.getEmissao()
                + "', `numero` = '" + empenho.getNumero()
                + "', `observacao` = '" + empenho.getObservacao()
                + "', `valor_total` = '" + empenho.getValorTotal()
                + "' WHERE `id` = "
                + empenho.getId();
        stm.execute(sql);
    }

}
