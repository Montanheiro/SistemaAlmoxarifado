/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.Contato;
import constructor.Endereco;
import constructor.Empenho;
import constructor.Fornecedor;
import constructor.EmpenhoItem;
import constructor.NaturezaDespesa;
import constructor.Produto;
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
public class EmpenhoDAOTest {
    
    public EmpenhoDAOTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        
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
        
        Unidade un = new Unidade("Unidade", "un");
        un = UnidadeDAO.create(un);
        Produto produto = new Produto("Arroz", un, 23.00);
        produto = ProdutoDAO.create(produto);
        NaturezaDespesa natureza = new NaturezaDespesa("3305039", "02", "Alimentos");
        natureza = NaturezaDespesaDAO.create(natureza);
        EmpenhoItem item = new EmpenhoItem(natureza, produto, 1, 5, 0.0, "ufuu295728");
        ArrayList<EmpenhoItem> itens = new ArrayList<EmpenhoItem>() {{
            add(item);
        }};
        
        Empenho obj = new Empenho(fornecedor, new Timestamp(System.currentTimeMillis()), "8375584", 
                "observação bla bla bla bla bla bla", 12.2, itens);        

        Empenho expResult = obj;
        Empenho result = EmpenhoDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        EmpenhoDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        EmpenhoDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
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
        
        Unidade un = new Unidade("Unidade", "un");
        UnidadeDAO.create(un);
        Produto produto = new Produto("Arroz", un, 23.00);
        ProdutoDAO.create(produto);
        NaturezaDespesa natureza = new NaturezaDespesa("3305039", "02", "Alimentos");
        NaturezaDespesaDAO.create(natureza);
        EmpenhoItem item = new EmpenhoItem(natureza, produto, 1, 5, 0.0, "uhsakbjfaskjbfk");
        ArrayList<EmpenhoItem> itens = new ArrayList<EmpenhoItem>() {{
            add(item);
        }};
  
        
        Empenho obj1 = new Empenho(1, fornecedor, new Timestamp(System.currentTimeMillis()), "8375584", 
                "observação bla bla bla bla bla bla", 12.2, itens);
        EmpenhoDAO.update(obj1);
        Empenho obj2 = new Empenho(1, fornecedor, new Timestamp(System.currentTimeMillis()), "67485738", 
                "observação bsgiougeohg uoshof bla", 1544.99, itens);
        EmpenhoDAO.update(obj2);
        EmpenhoDAO.retreave(1);        
    }
    
//    @Test
//    public void testDelete() throws Exception {
//        System.out.println("delete");
//        Endereco end = new Endereco("cidade", "bairro", "cep", "numero", "complemento", "logradouro", "estado");
//        Contato contato = new Contato("nome", "telefone");        
//        ArrayList<Endereco> enderecos = new ArrayList<Endereco>() {{
//            add(end);
//        }};
//        ArrayList<Contato> contatos = new ArrayList<Contato>() {{
//            add(contato);
//        }};
//        Fornecedor fornecedor = new Fornecedor("razão", "fantasia", "cnpj", enderecos, contatos);
//        fornecedor = FornecedorDAO.create(fornecedor);
//        
//        Unidade un = new Unidade("Unidade", "un");
//        un = UnidadeDAO.create(un);
//        Produto produto = new Produto("Arroz", un, 23.00, 2.0);
//        produto = ProdutoDAO.create(produto);
//        NaturezaDespesa natureza = new NaturezaDespesa("3305039", "02", "Alimentos");
//        natureza = NaturezaDespesaDAO.create(natureza);
//        EmpenhoItem item = new EmpenhoItem(natureza, produto, 0, 0, 0, "ufuu295728");
//        ArrayList<ItemEmpenho> itens = new ArrayList<ItemEmpenho>() {{
//            add(item);
//        }};
//        
//        Empenho obj = new Empenho(fornecedor, new Timestamp(System.currentTimeMillis()), "8375584", 
//                "observação bla bla bla bla bla bla", 12.2, itens);
//        EmpenhoDAO.create(obj);
//        EmpenhoDAO.delete(obj);
//    }
    
}
