/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.Endereco;
import constructor.Fornecedor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class EnderecoDAOTest {
    
    public EnderecoDAOTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
       
        Fornecedor fornecedor = new Fornecedor("razao", "fanatsia", "cnpj", null, null);
        FornecedorDAO.create(fornecedor);
        
        System.out.println("create");
        Endereco end = new Endereco("cidade", "bairro", "cep", "numero", "complemento", "logradouro", "estado", 1);
        Endereco expResult = end;
        Endereco result = EnderecoDAO.create(end);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        EnderecoDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        EnderecoDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        
        Endereco end = new Endereco(1, "cidade", "bairro", "cep", "numero", "complemento", "logradouro", "estado", 1);
        EnderecoDAO.update(end);
        Endereco end2 = new Endereco(1,"cidade", "bairro", "cep", "numero", "complemento", "logradouro", "estado", 1);
        EnderecoDAO.update(end2);
        EnderecoDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Endereco end = new Endereco("cidade", "bairro", "cep", "numero", "complemento", "logradouro", "estado", 1);
        EnderecoDAO.create(end);
        EnderecoDAO.delete(end);
    }
    
}
