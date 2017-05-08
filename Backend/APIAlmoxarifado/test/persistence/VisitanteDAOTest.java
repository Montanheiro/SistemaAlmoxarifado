package persistence;

import constructor.Setor;
import constructor.Visitante;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VisitanteDAOTest {
    
    public VisitanteDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Visitante obj = new Visitante(42, setor);
        Visitante expResult = obj;
        Visitante result = VisitanteDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        VisitanteDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        VisitanteDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Visitante obj1 = new Visitante(53, setor);
        VisitanteDAO.update(obj1);
        Visitante obj2 = new Visitante(353542, setor);
        VisitanteDAO.update(obj2);
        VisitanteDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Visitante obj = new Visitante(200, setor);
        VisitanteDAO.create(obj);
        VisitanteDAO.delete(obj);
    }
    
}
