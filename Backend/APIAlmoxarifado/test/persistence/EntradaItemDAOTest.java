/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.EntradaItem;
import constructor.Produto;
import constructor.Unidade;
import java.sql.Timestamp;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EntradaItemDAOTest {
    
    public EntradaItemDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00, 2.0));
        EntradaItem obj = new EntradaItem(produto, 1, 23.00, new Timestamp((System.currentTimeMillis())), 
                "lote8fs89", 1, 0.0);
        EntradaItem expResult = obj;
        EntradaItem result = EntradaItemDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        EntradaItemDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        EntradaItemDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00, 2.0));
        EntradaItem obj1 = new EntradaItem(produto, 1, 23.00, new Timestamp((System.currentTimeMillis())), 
                "lote8fs89", 0, 24.99);
        EntradaItemDAO.update(obj1);
        EntradaItem obj2 = new EntradaItem(produto, 1, 23.00, new Timestamp((System.currentTimeMillis())), 
                "lote8fs89", 1, 0.0);
        EntradaItemDAO.update(obj2);
        EntradaItemDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Placa de trânsito", unidade, 23.00, 2.0));
        EntradaItem obj = new EntradaItem(produto, 1, 23.00, new Timestamp((System.currentTimeMillis())), 
                "lote8fs89", 1, 0.0);
        EntradaItemDAO.create(obj);
        EntradaItemDAO.delete(obj);
    }
    
}
