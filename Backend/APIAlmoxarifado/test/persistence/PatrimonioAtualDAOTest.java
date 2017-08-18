package persistence;

import constructor.PatrimonioAtual;
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
public class PatrimonioAtualDAOTest {
    
    public PatrimonioAtualDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00, 2.0));
        PatrimonioAtual obj = new PatrimonioAtual(produto, 535, 536767.94);
        PatrimonioAtual expResult = obj;
        PatrimonioAtual result = PatrimonioAtualDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        PatrimonioAtualDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        PatrimonioAtualDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00, 2.0));
        PatrimonioAtual obj1 = new PatrimonioAtual(produto, 5, 79.9);
        PatrimonioAtualDAO.update(obj1);
        PatrimonioAtual obj2 = new PatrimonioAtual(produto, 20, 30);
        PatrimonioAtualDAO.update(obj2);
        PatrimonioAtualDAO.retreave(1);        
    }
    
}
