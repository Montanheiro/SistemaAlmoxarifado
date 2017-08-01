package persistence;

import constructor.EntradaDoacaoTransferencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class EntradaDoacaoTransferenciaDAO {

    private EntradaDoacaoTransferenciaDAO() {
    }

    public static EntradaDoacaoTransferencia create(EntradaDoacaoTransferencia edot) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO entradas_doacaotransferencia (`entrada`, `doacao_ou_transferencia`) VALUES ('"
                + edot.getEntrada().getId() + "','"
                + edot.getDoacaoTransferencia().getId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        edot.setId(key);
        return edot;
    }

    public static EntradaDoacaoTransferencia retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM entradas_doacaotransferencia where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new EntradaDoacaoTransferencia(id,
                EntradaDAO.retreave(rs.getInt("entrada")),
                DoacaoOuTransferenciaDAO.retreave(rs.getInt("doacao_ou_transferencia")));

    }

    public static ArrayList<EntradaDoacaoTransferencia> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM entradas_doacaotransferencia";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<EntradaDoacaoTransferencia> edot = new ArrayList<>();
        while (rs.next()) {
            edot.add(new EntradaDoacaoTransferencia(
                    rs.getInt("id"),
                    EntradaDAO.retreave(rs.getInt("entrada")),
                    DoacaoOuTransferenciaDAO.retreave(rs.getInt("doacao_ou_transferencia"))));
        }
        rs.next();
        return edot;
    }

    public static void delete(EntradaDoacaoTransferencia edot) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM entradas_doacaotransferencia WHERE `id`="
                + edot.getId();
        stm.execute(sql);
    }

    public static void update(EntradaDoacaoTransferencia edot) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE entradas_doacaotransferencia SET "
                + "`entrada` = '" + edot.getEntrada().getId()
                + "', `doacao_ou_transferencia` = '" + edot.getDoacaoTransferencia().getId()
                + "' WHERE `id` = "
                + edot.getId();
        stm.execute(sql);
    }

}
