package persistence;

import constructor.Tipo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TipoDAOTest {
    
    public TipoDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Tipo obj = new Tipo("Doação Pessoa Física");
        Tipo expResult = obj;
        Tipo result = TipoDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        TipoDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        TipoDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Tipo obj1 = new Tipo(1, "Doação Pessoa Jurídica");
        TipoDAO.update(obj1);
        Tipo obj2 = new Tipo(1, "Transferência Interna");
        TipoDAO.update(obj2);
        TipoDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Tipo obj = new Tipo("Transferência Externa");
        TipoDAO.create(obj);
        TipoDAO.delete(obj);
    }
    
}
