package persistence;

import constructor.Produto;
import constructor.RequisicaoProduto;
import constructor.Requisicao;
import constructor.Servidor;
import constructor.Setor;
import constructor.Unidade;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00));
        RequisicaoProduto item = new RequisicaoProduto(produto, 35);
        ArrayList<RequisicaoProduto> itens = new ArrayList<RequisicaoProduto>() {{
            add(item);
        }};
        
        Requisicao obj = new Requisicao(servidor, 
                new Timestamp((System.currentTimeMillis())), null, itens);
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
        
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00));
        RequisicaoProduto item = new RequisicaoProduto(produto, 35);
        ArrayList<RequisicaoProduto> itens = new ArrayList<RequisicaoProduto>() {{
            add(item);
        }};
        
        Requisicao obj1 = new Requisicao(1, servidor, 
                new Timestamp((System.currentTimeMillis())), "Preciso dos materiais urgente", itens);
        RequisicaoDAO.update(obj1);
        Requisicao obj2 = new Requisicao(1, servidor, 
                new Timestamp((System.currentTimeMillis())), "Para evento", itens);
        RequisicaoDAO.update(obj2);
        RequisicaoDAO.retreave(1);        
    }
    
//    @Test
//    public void testDelete() throws Exception {
//        System.out.println("delete");  
//        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
//        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
//        
//        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
//        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00));
//        RequisicaoProduto item = new RequisicaoProduto(produto, 35);
//        ArrayList<ProdutoRequisicao> itens = new ArrayList<ProdutoRequisicao>() {{
//            add(item);
//        }};
//        
//        Requisicao obj = new Requisicao(1, servidor, 
//                new Timestamp((System.currentTimeMillis())), "Reposição", itens);
//        RequisicaoDAO.create(obj);
//        RequisicaoDAO.delete(obj);
//    }
    
}
