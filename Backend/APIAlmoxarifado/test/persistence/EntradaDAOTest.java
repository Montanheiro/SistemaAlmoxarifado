/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.Entrada;
import constructor.Produto;
import constructor.Unidade;
import java.sql.Timestamp;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class EntradaDAOTest {
    
    public EntradaDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade));
        Entrada obj = new Entrada(produto, 23, new Timestamp((System.currentTimeMillis())), 
                new Timestamp((System.currentTimeMillis())), "8fs89", "002940", 0);
        Entrada expResult = obj;
        Entrada result = EntradaDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        EntradaDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        EntradaDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade));
        Entrada obj1 = new Entrada(produto, 549.24, new Timestamp((System.currentTimeMillis())), 
                new Timestamp((System.currentTimeMillis())), "853858", "88593", 1);
        EntradaDAO.update(obj1);
        Entrada obj2 = new Entrada(produto, 37522, new Timestamp((System.currentTimeMillis())), 
                new Timestamp((System.currentTimeMillis())), "8295838", "466464", 0);
        EntradaDAO.update(obj2);
        EntradaDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Placa de trânsito", unidade));
        Entrada obj = new Entrada(produto, 4324.25, new Timestamp((System.currentTimeMillis())), 
                new Timestamp((System.currentTimeMillis())), "4665665", "7564355", 0);
        EntradaDAO.create(obj);
        EntradaDAO.delete(obj);
    }
    
}
