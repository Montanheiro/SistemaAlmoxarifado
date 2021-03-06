package persistence;

import constructor.Visitante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class VisitanteDAO {

    private VisitanteDAO() {
    }

    public static Visitante create(Visitante visitante) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO visitantes (`quantidade`, `setor`) VALUES ('"
                + visitante.getQtd() + "','"
                + visitante.getSetor().getId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        visitante.setId(rs.getInt(1));
        return visitante;
    }

    public static Visitante retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM visitantes where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Visitante(id,
                rs.getInt("quantidade"),
                SetorDAO.retreave(rs.getInt("setor")));

    }

    public static ArrayList<Visitante> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM visitantes";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Visitante> visitante = new ArrayList<>();
        while (rs.next()) {
            visitante.add(new Visitante(
                    rs.getInt("id"),
                    rs.getInt("quantidade"),
                    SetorDAO.retreave(rs.getInt("setor"))));
        }
        rs.next();
        return visitante;
    }

    public static void delete(Visitante visitante) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM visitantes WHERE `id`="
                + visitante.getId();
        stm.execute(sql);
    }

    public static void update(Visitante visitante) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE visitantes SET "
                + "`quantidade`= '" + visitante.getQtd()
                + "', `setor`= '" + visitante.getSetor().getId()
                + " ' WHERE `id`= "
                + visitante.getId();
        stm.execute(sql);
    }

}
