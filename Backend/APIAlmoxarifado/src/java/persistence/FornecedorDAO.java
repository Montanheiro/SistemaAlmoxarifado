package persistence;

import constructor.Contato;
import constructor.Endereco;
import constructor.Fornecedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class FornecedorDAO {

    private FornecedorDAO() {
    }

    public static int create(Fornecedor fornecedor) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO fornecedores (`razao_social`, `nome_fantasia`, `cnpj`) VALUES ('"
                + fornecedor.getRazaoSocial() + "','"
                + fornecedor.getNomeFantasia() + "','"
                + fornecedor.getCnpj() + "')";
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        fornecedor.setId(key);

        EnderecoDAO.create(fornecedor.getEndereco());

        for (Contato contato : fornecedor.getContato()) {
            contato.setFornecedorId(key);
            ContatoDAO.create(contato);
        }

        return key;
    }

    public static Fornecedor retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM fornecedores where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Endereco endereco = EnderecoDAO.retreaveByFornecedor(id);
        ArrayList<Contato> contatos = ContatoDAO.retreaveByFornecedor(id);
        return new Fornecedor(id,
                rs.getString("razao_social"),
                rs.getString("nome_fantasia"),
                rs.getString("cnpj"),
                endereco, contatos);
    }

    public static ArrayList<Fornecedor> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM fornecedores";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Fornecedor> fornecedor = new ArrayList<>();
        ArrayList<Contato> contatos;
        while (rs.next()) {
            contatos = ContatoDAO.retreaveByFornecedor(rs.getInt("id"));
            Endereco endereco = EnderecoDAO.retreaveByFornecedor(rs.getInt("id"));
            fornecedor.add(new Fornecedor(
                    rs.getInt("id"),
                    rs.getString("razao_social"),
                    rs.getString("nome_fantasia"),
                    rs.getString("cnpj"),
                    endereco, contatos));
        }
        rs.next();
        return fornecedor;
    }

    public static void update(Fornecedor fornecedor) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE fornecedores SET "
                + "`razao_social`= '" + fornecedor.getRazaoSocial()
                + "', `nome_fantasia`= '" + fornecedor.getNomeFantasia()
                + "', `cnpj`= '" + fornecedor.getCnpj()
                + "' WHERE `id`= "
                + fornecedor.getId();
        stm.execute(sql);

        EnderecoDAO.update(fornecedor.getEndereco());

        for (Contato contato : fornecedor.getContato()) {
            if (contato.getId() != 0) {
                ContatoDAO.update(contato);
            } else {
                contato.setFornecedorId(fornecedor.getId());
                ContatoDAO.create(contato);
            }
        }

    }

    public static void delete(Fornecedor fornecedor) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM fornecedores WHERE `id`="
                + fornecedor.getId();
        stm.execute(sql);
    }

}
