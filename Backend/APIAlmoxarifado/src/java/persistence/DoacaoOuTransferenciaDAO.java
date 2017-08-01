package persistence;

import constructor.DoacaoOuTransferencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class DoacaoOuTransferenciaDAO {

    private DoacaoOuTransferenciaDAO() {
    }

    public static DoacaoOuTransferencia create(DoacaoOuTransferencia dot) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO doacoes_ou_transferencias (`tipo`, `responsavel`) VALUES ('"
                + dot.getTipo().getId() + "','"
                + dot.getResponsavel() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        dot.setId(key);
        return dot;
    }

    public static DoacaoOuTransferencia retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM doacoes_ou_transferencias where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new DoacaoOuTransferencia(id,
                TipoDAO.retreave(rs.getInt("tipo")),
                rs.getString("responsavel"));

    }

    public static ArrayList<DoacaoOuTransferencia> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM doacoes_ou_transferencias";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<DoacaoOuTransferencia> dot = new ArrayList<>();
        while (rs.next()) {
            dot.add(new DoacaoOuTransferencia(
                    rs.getInt("id"),
                    TipoDAO.retreave(rs.getInt("tipo")),
                    rs.getString("responsavel")));
        }
        rs.next();
        return dot;
    }

    public static void delete(DoacaoOuTransferencia dot) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM doacoes_ou_transferencias WHERE `id`="
                + dot.getId();
        stm.execute(sql);
    }

    public static void update(DoacaoOuTransferencia dot) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE doacoes_ou_transferencias SET "
                + "`tipo` = '" + dot.getTipo().getId()
                + "', `responsavel` = '" + dot.getResponsavel()
                + "' WHERE `id` = "
                + dot.getId();
        stm.execute(sql);
    }

}
