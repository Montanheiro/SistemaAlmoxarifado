package persistence;

import constructor.Endereco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EnderecoDAO {

    private EnderecoDAO() {
    }

    public static Endereco create(Endereco endereco) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO enderecos (`fornecedor`, `cidade`, `bairro`, `cep`, `numero`, `complemento`, `logradouro`, estado) VALUES ('"
                + endereco.getFornecedorId() + "','"
                + endereco.getCidade() + "','"
                + endereco.getBairro() + "','"
                + endereco.getCep() + "','"
                + endereco.getNumero() + "','"
                + endereco.getComplemento() + "','"
                + endereco.getEstado() + "','"
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
                rs.getString("cidade"),
                rs.getString("bairro"),
                rs.getString("cep"),
                rs.getString("numero"),
                rs.getString("complemento"),
                rs.getString("logradouro"),
                rs.getString("estado"),
                rs.getInt("fornecedor"));
    }

    public static ArrayList<Endereco> retreaveByFornecedor(int fornecedorId) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM enderecos WHERE fornecedor = " + fornecedorId;
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Endereco> temp = new ArrayList<>();
        while (rs.next()) {
            temp.add(new Endereco(
                    rs.getInt("id"),
                    rs.getString("cidade"),
                    rs.getString("bairro"),
                    rs.getString("cep"),
                    rs.getString("numero"),
                    rs.getString("complemento"),
                    rs.getString("logradouro"),
                    rs.getString("estado"),
                    rs.getInt("fornecedor")));
        }
        return temp;
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
                    rs.getString("cidade"),
                    rs.getString("bairro"),
                    rs.getString("cep"),
                    rs.getString("numero"),
                    rs.getString("complemento"),
                    rs.getString("logradouro"),
                    rs.getString("estado"),
                    rs.getInt("fornecedor")));
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
