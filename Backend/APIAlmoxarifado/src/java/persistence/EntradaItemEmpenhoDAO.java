package persistence;

import constructor.EntradaItemEmpenho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EntradaItemEmpenhoDAO {
 
    public static EntradaItemEmpenho create(EntradaItemEmpenho eie) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO `entradas_itensempenho` (`itens_empenho`, `entrada`) VALUES ('"
                + eie.getItemEmpenho().getId() + "','"
                + eie.getEntrada().getId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        eie.setId(key);
        return eie;
    }

    public static EntradaItemEmpenho retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM entradas_itensempenho where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new EntradaItemEmpenho(id,
                ItemEmpenhoDAO.retreave(rs.getInt("itens_empenho")),
                EntradaDAO.retreave(rs.getInt("entrada")));

    }

    public static ArrayList<EntradaItemEmpenho> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM entradas_itensempenho";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<EntradaItemEmpenho> eie = new ArrayList<>();
        while (rs.next()) {
            eie.add(new EntradaItemEmpenho(
                    rs.getInt("id"),
                    ItemEmpenhoDAO.retreave(rs.getInt("itens_empenho")),
                    EntradaDAO.retreave(rs.getInt("entrada"))));
        }
        rs.next();
        return eie;
    }

    public static void delete(EntradaItemEmpenho eie) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM entradas_itensempenho WHERE `id`="
                + eie.getId();
        stm.execute(sql);
    }

    public static void update(EntradaItemEmpenho eie) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE entradas_itensempenho SET "
                + "`itens_empenho` = " + eie.getItemEmpenho().getId()
                + ", `entrada` = " + eie.getEntrada().getId()
                + " WHERE `id` = "
                + eie.getId();
        stm.execute(sql);
    }
                    
}
