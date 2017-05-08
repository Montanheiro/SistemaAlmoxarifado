/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.Estoque;
import constructor.Produto;
import constructor.Unidade;
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
public class EstoqueDAOTest {
    
    public EstoqueDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade));
        Estoque obj = new Estoque(produto, 20, 729.32);
        Estoque expResult = obj;
        Estoque result = EstoqueDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        EstoqueDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        EstoqueDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade));
        Estoque obj1 = new Estoque(produto, 5, 79.9);
        EstoqueDAO.update(obj1);
        Estoque obj2 = new Estoque(produto, 20, 30);
        EstoqueDAO.update(obj2);
        EstoqueDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Placa de trânsito", unidade));
        Estoque obj = new Estoque(produto, 20, 759.21);
        EstoqueDAO.create(obj);
        EstoqueDAO.delete(obj);
    }
    
}
