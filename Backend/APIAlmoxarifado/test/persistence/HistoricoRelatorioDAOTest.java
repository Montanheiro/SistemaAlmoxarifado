/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.HistoricoRelatorio;
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
public class HistoricoRelatorioDAOTest {
    
    public HistoricoRelatorioDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.09));
        HistoricoRelatorio obj = new HistoricoRelatorio(produto,
                new Timestamp((System.currentTimeMillis())), 20, 1394.09);
        HistoricoRelatorio expResult = obj;
        HistoricoRelatorio result = HistoricoRelatorioDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        HistoricoRelatorioDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        HistoricoRelatorioDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 230.0));
        HistoricoRelatorio obj1 = new HistoricoRelatorio(produto, 
                new Timestamp((System.currentTimeMillis())), 434, 3857353.10);
        HistoricoRelatorioDAO.update(obj1);
        HistoricoRelatorio obj2 = new HistoricoRelatorio(produto, 
                new Timestamp((System.currentTimeMillis())), 73, 1847394.73);
        HistoricoRelatorioDAO.update(obj2);
        HistoricoRelatorioDAO.retreave(1);        
    }
        
}
