package persistence;

import constructor.Contato;
import constructor.DoacaoOuTransferencia;
import constructor.Empenho;
import constructor.Endereco;
import constructor.EntradaItem;
import constructor.EntradaItemEmpenho;
import constructor.Fornecedor;
import constructor.ItemEmpenho;
import constructor.NaturezaDespesa;
import constructor.Produto;
import constructor.Tipo;
import constructor.Unidade;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EntradaItemEmpenhoDAOTest {
    
    public EntradaItemEmpenhoDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00, 2.0));
        EntradaItem entrada = new EntradaItem(produto, 23, new Timestamp((System.currentTimeMillis())), 
                new Timestamp((System.currentTimeMillis())), "8fs89", "002940", 0);
        entrada = EntradaItemDAO.create(entrada);
        
        Endereco end = new Endereco("cidade", "bairro", "cep", "numero", "complemento", "logradouro", "estado");
        Contato contato = new Contato("nome", "telefone");        
        ArrayList<Endereco> enderecos = new ArrayList<Endereco>() {{
            add(end);
        }};
        ArrayList<Contato> contatos = new ArrayList<Contato>() {{
            add(contato);
        }};
        Fornecedor fornecedor = new Fornecedor("razão", "fantasia", "cnpj", enderecos, contatos);
        fornecedor = FornecedorDAO.create(fornecedor);
        NaturezaDespesa natureza = new NaturezaDespesa("3305039", "02", "Alimentos");
        natureza = NaturezaDespesaDAO.create(natureza);
        Empenho empenho = new Empenho(fornecedor, new Timestamp(System.currentTimeMillis()), "8375584", 
                "observação bla bla bla bla bla bla", 12.2);
        empenho = EmpenhoDAO.create(empenho);
        
        ItemEmpenho itemEmpenho = new ItemEmpenho(empenho, natureza, 2, 2.5, 5.99, "2895t579");
        itemEmpenho = ItemEmpenhoDAO.create(itemEmpenho);
        
        EntradaItemEmpenho obj = new EntradaItemEmpenho(itemEmpenho, entrada);
        EntradaItemEmpenho expResult = obj;
        EntradaItemEmpenho result = EntradaItemEmpenhoDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        EntradaItemEmpenhoDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        EntradaItemEmpenhoDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00, 2.0));
        EntradaItem entrada = new EntradaItem(produto, 23, new Timestamp((System.currentTimeMillis())), 
                new Timestamp((System.currentTimeMillis())), "8fs89", "002940", 0);
        entrada = EntradaItemDAO.create(entrada);
        
        Endereco end = new Endereco("cidade", "bairro", "cep", "numero", "complemento", "logradouro", "estado");
        Contato contato = new Contato("nome", "telefone");        
        ArrayList<Endereco> enderecos = new ArrayList<Endereco>() {{
            add(end);
        }};
        ArrayList<Contato> contatos = new ArrayList<Contato>() {{
            add(contato);
        }};
        Fornecedor fornecedor = new Fornecedor("razão", "fantasia", "cnpj", enderecos, contatos);
        fornecedor = FornecedorDAO.create(fornecedor);
        NaturezaDespesa natureza = new NaturezaDespesa("3305039", "02", "Alimentos");
        natureza = NaturezaDespesaDAO.create(natureza);
        Empenho empenho = new Empenho(fornecedor, new Timestamp(System.currentTimeMillis()), "8375584", 
                "observação bla bla bla bla bla bla", 12.2);
        empenho = EmpenhoDAO.create(empenho);
        
        ItemEmpenho itemEmpenho = new ItemEmpenho(empenho, natureza, 2, 2.5, 5.99, "2895t579");
        itemEmpenho = ItemEmpenhoDAO.create(itemEmpenho);
        
        EntradaItemEmpenho obj1 = new EntradaItemEmpenho(itemEmpenho, entrada);
        EntradaItemEmpenhoDAO.update(obj1);
        EntradaItemEmpenho obj2 = new EntradaItemEmpenho(itemEmpenho, entrada);
        EntradaItemEmpenhoDAO.update(obj2);
        EntradaItemEmpenhoDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00, 2.0));
        EntradaItem entrada = new EntradaItem(produto, 23, new Timestamp((System.currentTimeMillis())), 
                new Timestamp((System.currentTimeMillis())), "8fs89", "002940", 0);
        entrada = EntradaItemDAO.create(entrada);
        
        Endereco end = new Endereco("cidade", "bairro", "cep", "numero", "complemento", "logradouro", "estado");
        Contato contato = new Contato("nome", "telefone");        
        ArrayList<Endereco> enderecos = new ArrayList<Endereco>() {{
            add(end);
        }};
        ArrayList<Contato> contatos = new ArrayList<Contato>() {{
            add(contato);
        }};
        Fornecedor fornecedor = new Fornecedor("razão", "fantasia", "cnpj", enderecos, contatos);
        fornecedor = FornecedorDAO.create(fornecedor);
        NaturezaDespesa natureza = new NaturezaDespesa("3305039", "02", "Alimentos");
        natureza = NaturezaDespesaDAO.create(natureza);
        Empenho empenho = new Empenho(fornecedor, new Timestamp(System.currentTimeMillis()), "8375584", 
                "observação bla bla bla bla bla bla", 12.2);
        empenho = EmpenhoDAO.create(empenho);
        
        ItemEmpenho itemEmpenho = new ItemEmpenho(empenho, natureza, 2, 2.5, 5.99, "2895t579");
        itemEmpenho = ItemEmpenhoDAO.create(itemEmpenho);
        
        EntradaItemEmpenho obj = new EntradaItemEmpenho(itemEmpenho, entrada);
        EntradaItemEmpenhoDAO.create(obj);
        EntradaItemEmpenhoDAO.delete(obj);
    }
    
}
