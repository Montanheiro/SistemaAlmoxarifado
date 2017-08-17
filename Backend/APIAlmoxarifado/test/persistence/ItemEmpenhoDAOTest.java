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
import constructor.ItemEmpenho;
import constructor.NaturezaDespesa;
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
public class ItemEmpenhoDAOTest {
    
    public ItemEmpenhoDAOTest() {
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
        
        NaturezaDespesa natureza = new NaturezaDespesa("3305039", "02", "Alimentos");
        natureza = NaturezaDespesaDAO.create(natureza);
        
        Empenho empenho = new Empenho(fornecedor, new Timestamp(System.currentTimeMillis()), "8375584", 
                "observação bla bla bla bla bla bla", 12.2);
        empenho = EmpenhoDAO.create(empenho);
        
        ItemEmpenho obj = new ItemEmpenho(empenho, natureza, 2, 2.5, 5.99, "2895t579");
                
        ItemEmpenho expResult = obj;
        ItemEmpenho result = ItemEmpenhoDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        ItemEmpenhoDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        ItemEmpenhoDAO.retreaveAll();
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
        
        NaturezaDespesa natureza = new NaturezaDespesa("3305039", "02", "Alimentos");
        natureza = NaturezaDespesaDAO.create(natureza);
        
        Empenho empenho = new Empenho(fornecedor, new Timestamp(System.currentTimeMillis()), "8375584", 
                "observação bla bla bla bla bla bla", 12.2);
        empenho = EmpenhoDAO.create(empenho);
        
        ItemEmpenho obj1 = new ItemEmpenho(empenho, natureza, 2, 2.5, 5.99, "2895t579");
        ItemEmpenhoDAO.update(obj1);
        ItemEmpenho obj2 = new ItemEmpenho(empenho, natureza, 7, 5.58, 10.00, "893597659");
        ItemEmpenhoDAO.update(obj2);
        ItemEmpenhoDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
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
        
        ItemEmpenho obj = new ItemEmpenho(empenho, natureza, 2, 2.5, 5.99, "2895t579");

        ItemEmpenhoDAO.create(obj);
        ItemEmpenhoDAO.delete(obj);
    }
    
}
