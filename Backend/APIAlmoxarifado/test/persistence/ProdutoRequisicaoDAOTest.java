/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.Produto;
import constructor.ProdutoRequisicao;
import constructor.Requisicao;
import constructor.Servidor;
import constructor.Setor;
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
public class ProdutoRequisicaoDAOTest {
    
    public ProdutoRequisicaoDAOTest() {
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
        
        ProdutoRequisicao obj = new ProdutoRequisicao(requisicao, produto, 35);
        ProdutoRequisicao expResult = obj;
        ProdutoRequisicao result = ProdutoRequisicaoDAO.create(obj);
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
        
        ProdutoRequisicao obj1 = new ProdutoRequisicao(requisicao, produto, 22.5);
        ProdutoRequisicaoDAO.update(obj1);
        ProdutoRequisicao obj2 = new ProdutoRequisicao(requisicao, produto, 89539856.53);
        ProdutoRequisicaoDAO.update(obj2);
        ProdutoRequisicaoDAO.retreave(1);        
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
        
        ProdutoRequisicao obj = new ProdutoRequisicao(requisicao, produto, 53.24);
        ProdutoRequisicaoDAO.create(obj);
        ProdutoRequisicaoDAO.delete(obj);
    }
    
}
