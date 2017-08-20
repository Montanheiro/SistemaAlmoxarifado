package persistence;

import constructor.Produto;
import constructor.RequisicaoProduto;
import constructor.Requisicao;
import constructor.SaidaProduto;
import constructor.Servidor;
import constructor.Setor;
import constructor.Unidade;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class SaidaProdutoDAOTest {
    
    public SaidaProdutoDAOTest() {
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
        
        Requisicao requisicao = new Requisicao(servidor, 
                new Timestamp((System.currentTimeMillis())), null, itens);
        requisicao = RequisicaoDAO.create(requisicao);
        
        SaidaProduto obj = new SaidaProduto(requisicao.getItens().get(0), 
                5358.24, new Timestamp((System.currentTimeMillis())));
        SaidaProduto expResult = obj;
        SaidaProduto result = SaidaProdutoDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        RequisicaoProdutoDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        RequisicaoProdutoDAO.retreaveAll();
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
        
        Requisicao requisicao = new Requisicao(servidor, 
                new Timestamp((System.currentTimeMillis())), null, itens);
        requisicao = RequisicaoDAO.create(requisicao);
        
        SaidaProduto obj1 = new SaidaProduto(requisicao.getItens().get(0), 
                24241, new Timestamp((System.currentTimeMillis())));
        SaidaProdutoDAO.update(obj1);
        SaidaProduto obj2 = new SaidaProduto(requisicao.getItens().get(0), 
                5, new Timestamp((System.currentTimeMillis())));
        SaidaProdutoDAO.update(obj2);
        SaidaProdutoDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
        
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 23.00));
        RequisicaoProduto item = new RequisicaoProduto(produto, 35);
        ArrayList<RequisicaoProduto> itens = new ArrayList<RequisicaoProduto>() {{
            add(item);
        }};
        
        Requisicao requisicao = new Requisicao(servidor, 
                new Timestamp((System.currentTimeMillis())), null, itens);
        requisicao = RequisicaoDAO.create(requisicao);
        
        SaidaProduto obj = new SaidaProduto(requisicao.getItens().get(0), 
                42853, new Timestamp((System.currentTimeMillis())));
        SaidaProdutoDAO.create(obj);
        SaidaProdutoDAO.delete(obj);
    }
    
}
