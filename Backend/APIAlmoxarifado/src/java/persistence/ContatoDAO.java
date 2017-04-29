package persistence;

import constructor.Contato;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class ContatoDAO {

    private ContatoDAO() {
    }

    public static int create(Contato contato) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO contatos (`nome`, `telefone`) VALUES ('"
                + contato.getNome() + "','"
                + contato.getTelefone() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        contato.setId(key);
        return key;
    }

    public static Contato retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM contatos where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Contato(id,
                rs.getString("nome"),
                rs.getString("telefone"),
                rs.getInt("fornecedor_id"));

    }

    public static ArrayList<Contato> retreaveByFornecedor(int fornecedorId) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM contatos where fornecedor_id =" + fornecedorId;
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Contato> temp = new ArrayList<>();
        while (rs.next()) {
            temp.add(new Contato(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("Telefone"),
                    rs.getInt("fornecedor_id")));
        }
        return temp;
    }

    public static ArrayList<Contato> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM contatos";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Contato> contato = new ArrayList<>();
        while (rs.next()) {
            contato.add(new Contato(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getInt("id")));
        }
        rs.next();
        return contato;
    }

    public static void delete(Contato contato) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM contatos WHERE `id`="
                + contato.getId();
        stm.execute(sql);
    }

    public static void update(Contato contato) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE contatos SET "
                + "`nome`='" + contato.getNome()
                + "', `telefone`= '" + contato.getTelefone()
                + "' WHERE `id`= "
                + contato.getId();
        stm.execute(sql);
    }

}
