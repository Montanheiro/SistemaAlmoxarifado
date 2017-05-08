/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.NaturezaDespesa;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NaturezaDespesaDAOTest {
    
    public NaturezaDespesaDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        NaturezaDespesa obj = new NaturezaDespesa("3305039", "02", "Alimentos");
        NaturezaDespesa expResult = obj;
        NaturezaDespesa result = NaturezaDespesaDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        NaturezaDespesaDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        NaturezaDespesaDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        NaturezaDespesa obj1 = new NaturezaDespesa("3303539", "04", "Material de laboratório");
        NaturezaDespesaDAO.update(obj1);
        NaturezaDespesa obj2 = new NaturezaDespesa("3305039", "06", "Livros escolares");
        NaturezaDespesaDAO.update(obj2);
        NaturezaDespesaDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        NaturezaDespesa obj = new NaturezaDespesa("3305039", "32", "Material de construção");
        NaturezaDespesaDAO.create(obj);
        NaturezaDespesaDAO.delete(obj);
    }
    
}
