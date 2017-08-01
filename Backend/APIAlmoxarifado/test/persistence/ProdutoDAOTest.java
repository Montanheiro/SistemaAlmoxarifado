/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.Produto;
import constructor.Unidade;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto obj = new Produto("Caneta preta", unidade);
        Produto expResult = obj;
        Produto result = ProdutoDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        ProdutoDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        ProdutoDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto obj1 = new Produto(1, "Canetão Azul", unidade);
        ProdutoDAO.update(obj1);
        Produto obj2 = new Produto(1, "Quadro Negro", unidade);
        ProdutoDAO.update(obj2);
        ProdutoDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto obj = new Produto("Placa de trânsito", unidade);
        ProdutoDAO.create(obj);
        ProdutoDAO.delete(obj);
    }
    
}
