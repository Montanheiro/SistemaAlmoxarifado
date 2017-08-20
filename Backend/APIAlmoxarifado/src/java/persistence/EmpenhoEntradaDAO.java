package persistence;

import constructor.EmpenhoEntrada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpenhoEntradaDAO {
 
    public static EmpenhoEntrada create(EmpenhoEntrada eie) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO `empenhos_entradas` (`empenho`, `entrada`) VALUES ("
                + eie.getEmpenhoId()+ ","
                + eie.getEntradaid()+ ")";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        eie.setId(key);
        return eie;
    }

    public static EmpenhoEntrada retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM empenhos_entradas where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new EmpenhoEntrada(id,
                rs.getInt("empenho"),
                rs.getInt("entrada"));

    }

    public static ArrayList<EmpenhoEntrada> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM empenhos_entradas";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<EmpenhoEntrada> eie = new ArrayList<>();
        while (rs.next()) {
            eie.add(new EmpenhoEntrada(
                    rs.getInt("id"),
                    rs.getInt("empenho"),
                    rs.getInt("entrada")));
        }
        rs.next();
        return eie;
    }

    public static void delete(EmpenhoEntrada eie) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM empenhos_entradas WHERE `id`="
                + eie.getId();
        stm.execute(sql);
    }

    public static void update(EmpenhoEntrada eie) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE empenhos_entradas SET "
                + "`empenho` = " + eie.getEmpenhoId()
                + ", `entrada` = " + eie.getEntradaid()
                + " WHERE `id` = "
                + eie.getId();
        stm.execute(sql);
    }
                    
}
