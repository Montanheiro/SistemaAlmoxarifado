package persistence;

import constructor.DoacaoOuTransferencia;
import constructor.EntradaItem;
import constructor.ItemEmpenho;
import constructor.NaturezaDespesa;
import constructor.Produto;
import constructor.Tipo;
import constructor.Unidade;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DoacaoOuTransferenciaDAOTest {
    
    public DoacaoOuTransferenciaDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Tipo tipo = TipoDAO.create(new Tipo("Doação Pessoa Juridica"));
        
        Unidade un = new Unidade("Unidade", "un");
        un = UnidadeDAO.create(un);
        Produto produto = new Produto("Notebook", un, 0.00, 2.0);
        produto = ProdutoDAO.create(produto);
        EntradaItem item = new EntradaItem(produto, 23.00, new Timestamp((System.currentTimeMillis())), 
                "lote8fs89", 30.00);
        
        ArrayList<EntradaItem> itens = new ArrayList<EntradaItem>() {{
            add(item);
        }};
        
        DoacaoOuTransferencia obj = new DoacaoOuTransferencia(tipo, "Hot Park",
                new Timestamp(System.currentTimeMillis()), "24353g", "Equipamentos de informatica", itens);
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
        
        Unidade un = new Unidade("Unidade", "un");
        un = UnidadeDAO.create(un);
        Produto produto = new Produto("Notebook", un, 0.00, 2.0);
        produto = ProdutoDAO.create(produto);
        EntradaItem item = new EntradaItem(produto, 23.00, new Timestamp((System.currentTimeMillis())), 
                "lote8fs89", 30.00);
        
        ArrayList<EntradaItem> itens = new ArrayList<EntradaItem>() {{
            add(item);
        }};
        
        Tipo tipo = TipoDAO.create(new Tipo("Doação Pessoa Juridica"));
        DoacaoOuTransferencia obj1 = new DoacaoOuTransferencia(tipo, "Rio Quente Resorts",
                new Timestamp(System.currentTimeMillis()), "24353g", "Equipamentos de informatica", itens);
        DoacaoOuTransferenciaDAO.update(obj1);
        DoacaoOuTransferencia obj2 = new DoacaoOuTransferencia(tipo, "Embraer",
                new Timestamp(System.currentTimeMillis()), "24353g", "Equipamentos de informatica", itens);
        DoacaoOuTransferenciaDAO.update(obj2);
        DoacaoOuTransferenciaDAO.retreave(1);        
    }
    
//    @Test
//    public void testDelete() throws Exception {
//        System.out.println("delete");  
//        
//        Unidade un = new Unidade("Unidade", "un");
//        un = UnidadeDAO.create(un);
//        Produto produto = new Produto("Notebook", un, 0.00, 2.0);
//        produto = ProdutoDAO.create(produto);
//        NaturezaDespesa natureza = new NaturezaDespesa("3305039", "02", "Alimentos");
//        natureza = NaturezaDespesaDAO.create(natureza);
//        ItemEmpenho item = new ItemEmpenho(natureza, produto, 1, 5, 0.0, "ufuu295728");
//        ArrayList<ItemEmpenho> itens = new ArrayList<ItemEmpenho>() {{
//            add(item);
//        }};
//        
//        Tipo tipo = TipoDAO.create(new Tipo("Doação Pessoa Juridica"));
//        DoacaoOuTransferencia obj = new DoacaoOuTransferencia(tipo, "Empresa da rua das bolinhas do Chuchu",
//                new Timestamp(System.currentTimeMillis()), "24353g", "Equipamentos de informatica", itens);
//        
//        DoacaoOuTransferenciaDAO.create(obj);
//        DoacaoOuTransferenciaDAO.delete(obj);
//    }
    
}
