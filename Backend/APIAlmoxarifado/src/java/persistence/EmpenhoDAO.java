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

    public static int create(Empenho empenho) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO empenhos (`emissao`, `numero`, `observacao`, `valor_total`, `fornecedor`) VALUES ('"
                + empenho.getEmissao() + "','"
                + empenho.getNumero() + "','"
                + empenho.getObservacao() + "','"
                + empenho.getValorTotal() + "','"
                + empenho.getFornecedor().getId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        empenho.setId(key);
        return key;
    }

    public static Empenho retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM empenhos where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Empenho(id,
                rs.getDate("emissao"),
                rs.getString("numero"),
                rs.getString("observacao"),
                rs.getDouble("valor_total"),
                FornecedorDAO.retreave(rs.getInt("fornecedor")));

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
                    rs.getDate("emissao"),
                    rs.getString("numero"),
                    rs.getString("observacao"),
                    rs.getDouble("valor_total"),
                    FornecedorDAO.retreave(rs.getInt("fornecedor"))));
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
                + "`emissao` = '" + empenho.getEmissao()
                + "', `numero` = '" + empenho.getNumero()
                + "', `observacao` = '" + empenho.getObservacao()
                + "', `valor_total` = '" + empenho.getValorTotal()
                + "', `fornecedor` = '" + empenho.getFornecedor().getId()
                + "' WHERE `id` = "
                + empenho.getId();
        stm.execute(sql);
    }

}
