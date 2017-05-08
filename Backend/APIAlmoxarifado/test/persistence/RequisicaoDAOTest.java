package persistence;

import constructor.Requisicao;
import constructor.Servidor;
import constructor.Setor;
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
public class RequisicaoDAOTest {
    
    public RequisicaoDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
        Requisicao obj = new Requisicao(servidor, 
                new Timestamp((System.currentTimeMillis())), null);
        Requisicao expResult = obj;
        Requisicao result = RequisicaoDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        RequisicaoDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        RequisicaoDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
        Requisicao obj1 = new Requisicao(servidor, 
                new Timestamp((System.currentTimeMillis())), "Preciso dos materiais urgente");
        RequisicaoDAO.update(obj1);
        Requisicao obj2 = new Requisicao(servidor, 
                new Timestamp((System.currentTimeMillis())), "Para evento");
        RequisicaoDAO.update(obj2);
        RequisicaoDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
        Requisicao obj = new Requisicao(servidor, 
                new Timestamp((System.currentTimeMillis())), "Reposição");
        RequisicaoDAO.create(obj);
        RequisicaoDAO.delete(obj);
    }
    
}
