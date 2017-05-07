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

    public static Entrada create(Entrada entrada) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO entradas (`produto`, `quantidade`, `data`, `validade`, `lote`, `nf_numero`, `considerar_valorsequencia`) VALUES ('"
                + entrada.getProduto().getId() + "','"
                + entrada.getQtd() + "','"
                + entrada.getData() + "','"
                + entrada.getValidade() + "','"
                + entrada.getLote() + "','"
                + entrada.getNfNumero() + "','"
                + entrada.getConsiderarValorSequencia() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        entrada.setId(key);
        return entrada;
    }

    public static Entrada retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM entradas where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Entrada(id,
                ProdutoDAO.retreave(rs.getInt("produto_empenho")),
                rs.getDouble("quantidade"),
                rs.getTimestamp("data"),
                rs.getTimestamp("validade"),
                rs.getString("lote"),
                rs.getString("nf_numero"),
                rs.getInt("considerar_valorsequencia"));
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
                    ProdutoDAO.retreave(rs.getInt("produto_empenho")),
                    rs.getDouble("quantidade"),
                    rs.getTimestamp("data"),
                    rs.getTimestamp("validade"),
                    rs.getString("lote"),
                    rs.getString("nf_numero"),
                    rs.getInt("considerar_valorsequencia")));
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
                + "`produto` = '" + entrada.getProduto().getId()
                + "', `quantidade` = '" + entrada.getQtd()
                + "', `data` = '" + entrada.getData()
                + "', `validade` = '" + entrada.getValidade()
                + "', `lote` = '" + entrada.getLote()
                + "', `nf_numero` = '" + entrada.getNfNumero()
                + "', `considerar_valorsequencia` = '" + entrada.getConsiderarValorSequencia()
                + "' WHERE `id` = "
                + entrada.getId();
        stm.execute(sql);
    }

}
