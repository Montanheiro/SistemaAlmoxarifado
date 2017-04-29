package persistence;

import constructor.Requisicao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class RequisicaoDAO {

    
    private RequisicaoDAO() {
    }

    public static int create(Requisicao requisicao) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO requisicoes (`quantidade`, `setor`) VALUES ('"
                + requisicao.getQtd() + "','"
                + requisicao.getSetor() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        requisicao.setId(key);
        return key;
    }

    public static Requisicao retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM requisicoes where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Requisicao(id,
                rs.getDouble("quantidade"),
                rs.getInt("setor"));

    }

    public static ArrayList<Requisicao> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM requisicoes";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Requisicao> visitante = new ArrayList<>();
        while (rs.next()) {
            visitante.add(new Requisicao(
                    rs.getInt("id"),
                    rs.getInt("quantidade"),
                    rs.getString("setor")));
        }
        rs.next();
        return visitante;
    }

    public static void delete(Requisicao visitante) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM requisicoes WHERE `id`="
                + visitante.getId();
        stm.execute(sql);
    }

    public static void update(Requisicao visitante) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE requisicoes SET "
                + "`quantidade`='" + visitante.getQtd()
                + "', `setor`= '" + visitante.getSetor()
                + "' WHERE `id`= "
                + visitante.getId();
        stm.execute(sql);
    }

}
