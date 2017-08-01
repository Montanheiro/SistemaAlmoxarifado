/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.Servidor;
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
public class ServidorDAOTest {
    
    public ServidorDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor obj = new Servidor(setor, "Jucelino", "2858935", "Presidente");
        Servidor expResult = obj;
        Servidor result = ServidorDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        ServidorDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        ServidorDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor obj1 = new Servidor(setor, "Josefa", "6385634", "Secretária");
        ServidorDAO.update(obj1);
        Servidor obj2 = new Servidor(setor, "Janaina", "3568395", "Impeachment");
        ServidorDAO.update(obj2);
        ServidorDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor obj = new Servidor(setor, "Josue", "754732456", "Senador");
        ServidorDAO.create(obj);
        ServidorDAO.delete(obj);
    }
    
}
