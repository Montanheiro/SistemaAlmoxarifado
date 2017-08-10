/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.Contato;
import constructor.Fornecedor;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContatoDAOTest {
    
    public ContatoDAOTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
       
        System.out.println("create");
        Contato contato = new Contato("José Martins", "2848592585385", 1);
        Contato expResult = contato;
        Contato result = ContatoDAO.create(contato);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        ContatoDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        ContatoDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
            
//        Fornecedor fornecedor = new Fornecedor("razao", "fanatsia", "cnpj", null, null);
//        FornecedorDAO.create(fornecedor);
        
        Contato contato = new Contato(1, "José Osmar", "535392842824");
        ContatoDAO.update(contato);
        Contato contato2 = new Contato(1, "Josefa Maria", "32358256838");
        ContatoDAO.update(contato2);
        ContatoDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Contato contato = new Contato("Jusé Farias", "6436357544564", 1);
        ContatoDAO.create(contato);
        ContatoDAO.delete(contato);
    }
    
}