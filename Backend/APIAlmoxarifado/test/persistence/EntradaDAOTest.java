/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.Endereco;
import constructor.Entrada;
import constructor.EntradaItem;
import constructor.Produto;
import constructor.Unidade;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EntradaDAOTest {
    
    public EntradaDAOTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        UnidadeDAO.create(unidade);
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00, 2.0));
        ProdutoDAO.create(produto);
        EntradaItem item = new EntradaItem(produto, 1, 23.00, new Timestamp((System.currentTimeMillis())), 
                "lote8fs89", 1, 0.0);
        
        ArrayList<EntradaItem> itens = new ArrayList<EntradaItem>() {{
            add(item);
        }};
        
        Entrada obj = new Entrada(new Timestamp((System.currentTimeMillis())), "245", 2, "obs isufgsif", itens);
        
        Entrada expResult = obj;
        Entrada result = EntradaDAO.create(obj);
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
        UnidadeDAO.create(unidade);
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00, 2.0));
        ProdutoDAO.create(produto);
        
        EntradaItem item = new EntradaItem(produto, 1, 23.00, new Timestamp((System.currentTimeMillis())), 
                "lote8fs89", 1, 0.0);
        
        ArrayList<EntradaItem> itens = new ArrayList<EntradaItem>() {{
            add(item);
        }};
        
        Entrada obj1 = new Entrada(1, new Timestamp((System.currentTimeMillis())), "245", 0, "fhehgjdjf", itens);
        EntradaDAO.update(obj1);
        Entrada obj2 = new Entrada(1, new Timestamp((System.currentTimeMillis())), "6464", 6, "46yyif", itens);
        EntradaDAO.update(obj2);
        
        EntradaDAO.retreave(1);        
    }
    
//    @Test
//    public void testDelete() throws Exception {
//        System.out.println("delete");
//        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
//        Produto produto = ProdutoDAO.create(new Produto("Placa de trânsito", unidade, 23.00, 2.0));
//        EntradaItem obj = new EntradaItem(produto, 1, 23.00, new Timestamp((System.currentTimeMillis())), 
//                "lote8fs89", 1, 0.0);
//        EntradaItemDAO.create(obj);
//        EntradaItemDAO.delete(obj);
//    }
}
