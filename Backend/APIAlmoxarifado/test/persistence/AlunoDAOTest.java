package persistence;

import constructor.Aluno;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoDAOTest {
    
    public AlunoDAOTest() {
    }
        
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Aluno aluno = new Aluno("José Martins", "2848592585385");
        Aluno expResult = aluno;
        Aluno result = AlunoDAO.create(aluno);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        AlunoDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        AlunoDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Aluno aluno = new Aluno(1, "José Osmar", "535392842824");
        AlunoDAO.update(aluno);
        Aluno aluno2 = new Aluno(1, "Josefa Maria", "32358256838");
        AlunoDAO.update(aluno2);
        AlunoDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Aluno aluno = new Aluno("Jusé Farias", "6436357544564");
        AlunoDAO.create(aluno);
        AlunoDAO.delete(aluno);
    }
    
}
