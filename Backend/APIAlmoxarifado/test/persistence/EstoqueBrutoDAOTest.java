package persistence;

import constructor.EstoqueBruto;
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
public class EstoqueBrutoDAOTest {
    
    public EstoqueBrutoDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade));
        EstoqueBruto obj = new EstoqueBruto(produto, 535, 536767.94);
        EstoqueBruto expResult = obj;
        EstoqueBruto result = EstoqueBrutoDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        EstoqueBrutoDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        EstoqueBrutoDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade));
        EstoqueBruto obj1 = new EstoqueBruto(produto, 5, 79.9);
        EstoqueBrutoDAO.update(obj1);
        EstoqueBruto obj2 = new EstoqueBruto(produto, 20, 30);
        EstoqueBrutoDAO.update(obj2);
        EstoqueBrutoDAO.retreave(1);        
    }
    
}
