package persistence;

import constructor.DoacaoOuTransferencia;
import constructor.Entrada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
        
        Entrada entrada = new Entrada(new Timestamp(System.currentTimeMillis()), dot.getNfNumero(),
                2, "Entrada feita automáticamente através de uma doação ou transferencia", dot.getItens());
        entrada = EntradaDAO.create(entrada);
        
        String sql
                = "INSERT INTO doacoes_ou_transferencias (`tipo`, `entrada`, `responsavel`) VALUES ('"
                + dot.getTipo().getId() + "','"
                + entrada.getId() + "','"
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
        Entrada entrada = EntradaDAO.retreave(rs.getInt("entrada"));
                
        return new DoacaoOuTransferencia(id,
                TipoDAO.retreave(rs.getInt("tipo")),
                rs.getString("responsavel"),
                entrada.getData(),
                entrada.getNfNumero(),
                entrada.getObservacao(),
                entrada.getItens());
        
    }

    public static ArrayList<DoacaoOuTransferencia> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM doacoes_ou_transferencias";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<DoacaoOuTransferencia> dot = new ArrayList<>();
        while (rs.next()) {
            Entrada entrada = EntradaDAO.retreave(rs.getInt("entrada"));
            dot.add(new DoacaoOuTransferencia(
                    rs.getInt("id"),
                    TipoDAO.retreave(rs.getInt("tipo")),
                    rs.getString("responsavel"),
                    entrada.getData(),
                    entrada.getNfNumero(),
                    entrada.getObservacao(),
                    entrada.getItens()));
        }
        rs.next();
        return dot;
    }

//    public static void delete(DoacaoOuTransferencia dot) throws SQLException {
//        Statement stm
//                = Database.createConnection().
//                        createStatement();
//        String sql = "DELETE FROM doacoes_ou_transferencias WHERE `id`="
//                + dot.getId();
//        stm.execute(sql);
//    }

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
