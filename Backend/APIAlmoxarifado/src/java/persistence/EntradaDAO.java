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
                = "INSERT INTO entradas (`quantidade`, `preco_unitario`, `data`, `validade`, `lote`, `nf_numero`, `produto_empenho`) VALUES ('"
                + entrada.getQtd() + "','"
                + entrada.getPrecoUnitario() + "','"
                + entrada.getData() + "','"
                + entrada.getValidade() + "','"
                + entrada.getLote() + "','"
                + entrada.getNfNumero() + "','"
                + entrada.getProdutoEmpenho().getId() + "')";

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
                ProdutoEmpenhoDAO.retreave(rs.getInt("produto_empenho")),
                rs.getDouble("quantidade"),
                rs.getDouble("preco_unitario"),
                rs.getDate("data"),
                rs.getDate("validade"),
                rs.getString("lote"),
                rs.getString("nf_numero"));

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
                    ProdutoEmpenhoDAO.retreave(rs.getInt("produto_empenho")),
                    rs.getDouble("quantidade"),
                    rs.getDouble("preco_unitario"),
                    rs.getDate("data"),
                    rs.getDate("validade"),
                    rs.getString("lote"),
                    rs.getString("nf_numero")));
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
                + "`produto_empenho` = '" + entrada.getProdutoEmpenho().getId()
                + "', `quantidade` = '" + entrada.getQtd()
                + "', `preco_unitario` = '" + entrada.getPrecoUnitario()
                + "', `data` = '" + entrada.getData()
                + "', `validade` = '" + entrada.getValidade()
                + "', `lote` = '" + entrada.getLote()
                + "', `nf_numero` = '" + entrada.getNfNumero()
                + "' WHERE `id` = "
                + entrada.getId();
        stm.execute(sql);
    }

}
