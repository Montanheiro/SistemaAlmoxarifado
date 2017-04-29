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
                = "INSERT INTO pessoa (`razao_social`, `Nome_fantasia`, `cnpj`) VALUES ('"
                + fornecedor.getRazaoSocial() + "','"
                + fornecedor.getNomeFantasia() + "','"
                + fornecedor.getCnpj() + "')";
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        fornecedor.setId(key);
       
        EnderecoDAO.create(fornecedor.getEndereco());
        
        for (Contato c : fornecedor.getContato()) {
            c.setFornecedorId(key);
            ContatoDAO.create(c);
        }

        return key;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static Fornecedor retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM pessoa where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Endereco e = EnderecoDAO.retreaveByFornecedor(id);
        ArrayList<Contato> todosOscontatos = ContatoDAO.retreaveByFornecedor(id);
        return new Fornecedor(id,
                rs.getString("cpf_cnpj"),
                rs.getString("Nome"),
                e, todosOscontatos);
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static ArrayList<Fornecedor> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM pessoa";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Fornecedor> p = new ArrayList<>();
        ArrayList<Contato> todosOscontatos;
        ArrayList<Email> todosOsEmails;
        while (rs.next()) {
            todosOscontatos = ContatoDAO.retreaveByPessoa(rs.getInt("id"));
            Endereco e = EnderecoDAO.retreaveByPessoa(rs.getInt("id"));
            todosOsEmails = EmailDAO.retreaveByPessoa(rs.getInt("id"));
            p.add(new Fornecedor(
                    rs.getInt("id"),
                    rs.getString("cpf_cnpj"),
                    rs.getString("Nome"),
                    e, todosOscontatos, todosOsEmails));
        }
        rs.next();
        return p;
    }
    
    //Metodo UPDATE esta OK, testado e funcionando
    public static void update(Fornecedor c) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE pessoa SET "
                + "`cpf_cnpj`= '" + c.getCpf_cnpj()
                + "', `Nome`= '" + c.getNome()
                + "' WHERE `id`= "
                + c.getId();
        stm.execute(sql);

        EnderecoDAO.update(c.getEndereco());

        for (Contato cs : c.getContato()) {
            if (cs.getId() != 0) {
                ContatoDAO.update(cs);
            } else {
                cs.setPessoaId(c.getId());
                ContatoDAO.create(cs);
            }
        }

        for (Email em : c.getEmail()) {
            if (em.getId() != 0) {
                EmailDAO.update(em);
            } else {
                em.setPessoaId(c.getId());
                EmailDAO.create(em);
            }
        }

    }

    //Metodo DELETE esta OK, testado e funcionando
    public static void delete(Fornecedor p) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM pessoa WHERE `id`="
                + p.getId();
        stm.execute(sql);
    }

}
