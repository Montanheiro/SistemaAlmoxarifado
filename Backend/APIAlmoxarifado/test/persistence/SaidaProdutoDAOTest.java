/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.Produto;
import constructor.ProdutoRequisicao;
import constructor.Requisicao;
import constructor.SaidaProduto;
import constructor.Servidor;
import constructor.Setor;
import constructor.Unidade;
import java.sql.Timestamp;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class SaidaProdutoDAOTest {
    
    public SaidaProdutoDAOTest() {
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
        Requisicao requisicao = RequisicaoDAO.create(new Requisicao(servidor, 
                new Timestamp((System.currentTimeMillis())), null));
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade));
        ProdutoRequisicao prequisicao = ProdutoRequisicaoDAO.create(new ProdutoRequisicao(requisicao, produto, 35));
        
        SaidaProduto obj = new SaidaProduto(prequisicao, 5358.24, new Timestamp((System.currentTimeMillis())));
        SaidaProduto expResult = obj;
        SaidaProduto result = SaidaProdutoDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        ProdutoRequisicaoDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        ProdutoRequisicaoDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
        Requisicao requisicao = RequisicaoDAO.create(new Requisicao(servidor, 
                new Timestamp((System.currentTimeMillis())), null));
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade));
        ProdutoRequisicao prequisicao = ProdutoRequisicaoDAO.create(new ProdutoRequisicao(requisicao, produto, 35));
        
        SaidaProduto obj1 = new SaidaProduto(prequisicao, 24241, new Timestamp((System.currentTimeMillis())));
        SaidaProdutoDAO.update(obj1);
        SaidaProduto obj2 = new SaidaProduto(prequisicao, 5, new Timestamp((System.currentTimeMillis())));
        SaidaProdutoDAO.update(obj2);
        SaidaProdutoDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
        Requisicao requisicao = RequisicaoDAO.create(new Requisicao(servidor, 
                new Timestamp((System.currentTimeMillis())), null));
        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade));
        ProdutoRequisicao prequisicao = ProdutoRequisicaoDAO.create(new ProdutoRequisicao(requisicao, produto, 35));
        
        SaidaProduto obj = new SaidaProduto(prequisicao, 42853, new Timestamp((System.currentTimeMillis())));
        SaidaProdutoDAO.create(obj);
        SaidaProdutoDAO.delete(obj);
    }
    
}
