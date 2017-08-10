/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.Contato;
import constructor.Endereco;
import constructor.Fornecedor;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FornecedorDAOTest {
    
    public FornecedorDAOTest() {
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
        
        Fornecedor expResult = fornecedor;
        Fornecedor result = FornecedorDAO.create(fornecedor);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        FornecedorDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        FornecedorDAO.retreaveAll();
    }

//    @Test
//    public void testUpdate() throws Exception {
//        System.out.println("update");
//        Fornecedor fornecedor = new Fornecedor(1, "José Osmar", "535392842824");
//        FornecedorDAO.update(fornecedor);
//        Fornecedor fornecedor2 = new Fornecedor(1, "Josefa Maria", "32358256838");
//        FornecedorDAO.update(fornecedor2);
//        FornecedorDAO.retreave(1);        
//    }
//    
//    @Test
//    public void testDelete() throws Exception {
//        System.out.println("delete");  
//        Fornecedor fornecedor = new Fornecedor("Jusé Farias", "6436357544564");
//        FornecedorDAO.create(fornecedor);
//        FornecedorDAO.delete(fornecedor);
//    }
}
