package persistence;

import constructor.DoacaoOuTransferencia;
import constructor.Entrada;
import constructor.EntradaDoacaoTransferencia;
import constructor.Produto;
import constructor.Tipo;
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
public class EntradaDoacaoTransferenciaDAOTest {
    
    public EntradaDoacaoTransferenciaDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade));
        Entrada entrada = EntradaDAO.create(new Entrada(produto, 23, new Timestamp((System.currentTimeMillis())), 
                new Timestamp((System.currentTimeMillis())), "8fs89", "002940", 0));
        Tipo tipo = TipoDAO.create(new Tipo("Doação Pessoa Juridica"));
        DoacaoOuTransferencia dout = DoacaoOuTransferenciaDAO.create(new DoacaoOuTransferencia(tipo, "Embrapa"));
        
        EntradaDoacaoTransferencia obj = new EntradaDoacaoTransferencia(entrada, dout);
        EntradaDoacaoTransferencia expResult = obj;
        EntradaDoacaoTransferencia result = EntradaDoacaoTransferenciaDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        EntradaDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        EntradaDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade));
        Entrada entrada = EntradaDAO.create(new Entrada(produto, 23, new Timestamp((System.currentTimeMillis())), 
                new Timestamp((System.currentTimeMillis())), "8fs89", "002940", 0));
        Tipo tipo = TipoDAO.create(new Tipo("Doação Pessoa Juridica"));
        DoacaoOuTransferencia dout = DoacaoOuTransferenciaDAO.create(new DoacaoOuTransferencia(tipo, "Embrapa"));
        
        EntradaDoacaoTransferencia obj1 = new EntradaDoacaoTransferencia(entrada, dout);
        EntradaDoacaoTransferenciaDAO.update(obj1);
        EntradaDoacaoTransferencia obj2 = new EntradaDoacaoTransferencia(entrada, dout);
        EntradaDoacaoTransferenciaDAO.update(obj2);
        EntradaDoacaoTransferenciaDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Placa de trânsito", unidade));
        Entrada entrada = EntradaDAO.create(new Entrada(produto, 23, new Timestamp((System.currentTimeMillis())), 
                new Timestamp((System.currentTimeMillis())), "8fs89", "002940", 0));
        Tipo tipo = TipoDAO.create(new Tipo("Doação Pessoa Juridica"));
        DoacaoOuTransferencia dout = DoacaoOuTransferenciaDAO.create(new DoacaoOuTransferencia(tipo, "Embrapa"));
        
        EntradaDoacaoTransferencia obj = new EntradaDoacaoTransferencia(entrada, dout);
        EntradaDoacaoTransferenciaDAO.create(obj);
        EntradaDoacaoTransferenciaDAO.delete(obj);
    }
    
}
