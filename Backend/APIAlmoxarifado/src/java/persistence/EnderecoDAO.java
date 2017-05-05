package persistence;

import constructor.Endereco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class EnderecoDAO {

    private EnderecoDAO() {
    }

    public static Endereco create(Endereco endereco) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO enderecos (`fornecedor`, `cidade`, `bairro`, `cep`, `numero`, `complemento`, `logradouro`) VALUES ('"
                + endereco.getFornecedor().getId() + "','"
                + endereco.getCidade() + "','"
                + endereco.getBairro() + "','"
                + endereco.getCep() + "','"
                + endereco.getNumero() + "','"
                + endereco.getComplemento() + "','"
                + endereco.getLogradouro() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        endereco.setId(key);
        return endereco;
    }

    public static Endereco retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM enderecos where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Endereco(id,
                FornecedorDAO.retreave(rs.getInt("fornecedor")),
                rs.getString("cidade"),
                rs.getString("bairro"),
                rs.getString("cep"),
                rs.getString("numero"),
                rs.getString("complemento"),
                rs.getString("logradouro"));
    }

    public static Endereco retreaveByFornecedor(int fornecedorId) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM enderecos WHERE fornecedor = " + fornecedorId;
        ResultSet rs = stm.executeQuery(sql);
        if (rs.next()) {

            return new Endereco(
                    rs.getInt("id"),
                    FornecedorDAO.retreave(rs.getInt("fornecedor")),
                    rs.getString("logradouro"),
                    rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("cep"));
        }
        return null;
    }

    public static ArrayList<Endereco> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM enderecos";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Endereco> endereco = new ArrayList<>();
        while (rs.next()) {
            endereco.add(new Endereco(
                    rs.getInt("id"),
                    FornecedorDAO.retreave(rs.getInt("fornecedor")),
                    rs.getString("cidade"),
                    rs.getString("bairro"),
                    rs.getString("cep"),
                    rs.getString("numero"),
                    rs.getString("complemento"),
                    rs.getString("logradouro")));
        }
        rs.next();
        return endereco;
    }

    public static void delete(Endereco endereco) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM enderecos WHERE `id`="
                + endereco.getId();
        stm.execute(sql);
    }

    public static void update(Endereco endereco) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE enderecos SET "
                + "`cidade`='" + endereco.getCidade()
                + "', `bairro`= '" + endereco.getBairro()
                + "', `cep`= '" + endereco.getCep()
                + "', `numero`= '" + endereco.getNumero()
                + "', `complemento`= '" + endereco.getComplemento()
                + "', `logradouro`= '" + endereco.getLogradouro()
                + "' WHERE `id`= "
                + endereco.getId();
        stm.execute(sql);
    }

}
