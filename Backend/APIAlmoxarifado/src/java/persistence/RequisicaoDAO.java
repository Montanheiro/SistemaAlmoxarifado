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
                = "INSERT INTO requisicoes (`servidor`, `data`, `observacao`) VALUES ('"
                + requisicao.getServidor().getId() + "','"
                + requisicao.getData() + "','"
                + requisicao.getObservacao() + "')";

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
                ServidorDAO.retreave(rs.getInt("servidor")),
                rs.getTimestamp("data"),
                rs.getString("observacao"));

    }

    public static ArrayList<Requisicao> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM requisicoes";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Requisicao> requisicao = new ArrayList<>();
        while (rs.next()) {
            requisicao.add(new Requisicao(
                    rs.getInt("id"),
                    ServidorDAO.retreave(rs.getInt("servidor")),
                    rs.getTimestamp("data"),
                    rs.getString("observacao")));
        }
        rs.next();
        return requisicao;
    }

    public static void delete(Requisicao requisicao) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM requisicoes WHERE `id`="
                + requisicao.getId();
        stm.execute(sql);
    }

    public static void update(Requisicao requisicao) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE requisicoes SET "
                + "`servidor`='" + requisicao.getServidor().getId()
                + "', `data`= '" + requisicao.getData()
                + "', `observacao`= '" + requisicao.getObservacao()
                + "' WHERE `id`= "
                + requisicao.getId();
        stm.execute(sql);
    }

}
