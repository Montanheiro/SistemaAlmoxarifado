/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.Setor;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SetorDAOTest {
    
    public SetorDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Setor obj = new Setor("Direção de Ensino", "DIREN");
        Setor expResult = obj;
        Setor result = SetorDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        SetorDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        SetorDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Setor obj1 = new Setor(1, "Centro Assistência Estudantil", "CAE");
        SetorDAO.update(obj1);
        Setor obj2 = new Setor(1, "Núcleo de Computação", "INFO");
        SetorDAO.update(obj2);
        SetorDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Setor obj = new Setor("Alunos", "ALN");
        SetorDAO.create(obj);
        SetorDAO.delete(obj);
    }
    
}
