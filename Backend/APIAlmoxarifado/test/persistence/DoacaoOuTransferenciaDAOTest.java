package persistence;

import constructor.DoacaoOuTransferencia;
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
public class DoacaoOuTransferenciaDAOTest {
    
    public DoacaoOuTransferenciaDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Tipo tipo = TipoDAO.create(new Tipo("Doação Pessoa Juridica"));
        DoacaoOuTransferencia obj = new DoacaoOuTransferencia(tipo, "Embrapa");
        DoacaoOuTransferencia expResult = obj;
        DoacaoOuTransferencia result = DoacaoOuTransferenciaDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        DoacaoOuTransferenciaDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        DoacaoOuTransferenciaDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Tipo tipo = TipoDAO.create(new Tipo("Doação Pessoa Juridica"));
        DoacaoOuTransferencia obj1 = new DoacaoOuTransferencia(tipo, "Rio Quente Resorts");
        DoacaoOuTransferenciaDAO.update(obj1);
        DoacaoOuTransferencia obj2 = new DoacaoOuTransferencia(tipo, "Embraer");
        DoacaoOuTransferenciaDAO.update(obj2);
        DoacaoOuTransferenciaDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Tipo tipo = TipoDAO.create(new Tipo("Doação Pessoa Juridica"));
        DoacaoOuTransferencia obj = new DoacaoOuTransferencia(tipo, "Empresa da rua das bolinhas do Chuchu");
        DoacaoOuTransferenciaDAO.create(obj);
        DoacaoOuTransferenciaDAO.delete(obj);
    }
    
}
