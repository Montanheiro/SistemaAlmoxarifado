package persistence;

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
public class UnidadeDAOTest {
    
    public UnidadeDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Unidade obj = new Unidade("Metros", "mt");
        Unidade expResult = obj;
        Unidade result = UnidadeDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        UnidadeDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        UnidadeDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Unidade obj1 = new Unidade(1, "Litros", "lt");
        UnidadeDAO.update(obj1);
        Unidade obj2 = new Unidade(1, "Centimetros", "cm");
        UnidadeDAO.update(obj2);
        UnidadeDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Unidade obj = new Unidade("Pacotes", "pct");
        UnidadeDAO.create(obj);
        UnidadeDAO.delete(obj);
    }
    
}
