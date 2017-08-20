package persistence;

import constructor.Contato;
import constructor.Empenho;
import constructor.Endereco;
import constructor.Entrada;
import constructor.EntradaItem;
import constructor.Fornecedor;
import constructor.EmpenhoItem;
import constructor.NaturezaDespesa;
import constructor.Produto;
import constructor.Unidade;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EntradaDAOTest {
    
    public EntradaDAOTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        
        Endereco end = new Endereco("cidade", "bairro", "cep", "numero", "complemento", "logradouro", "estado");
        Contato contato = new Contato("nome", "telefone");        
        ArrayList<Endereco> enderecos = new ArrayList<Endereco>() {{
            add(end);
        }};
        ArrayList<Contato> contatos = new ArrayList<Contato>() {{
            add(contato);
        }};
        Fornecedor fornecedor = new Fornecedor("razão", "fantasia", "cnpj", enderecos, contatos);
        fornecedor = FornecedorDAO.create(fornecedor);
        
        Unidade un = new Unidade("Unidade", "un");
        un = UnidadeDAO.create(un);
        Produto produto = new Produto("Arroz", un, 23.00);
        produto = ProdutoDAO.create(produto);
        NaturezaDespesa natureza = new NaturezaDespesa("3305039", "02", "Alimentos");
        natureza = NaturezaDespesaDAO.create(natureza);
        EmpenhoItem item = new EmpenhoItem(natureza, produto, 1, 5, 0.0, "ufuu295728");
        ArrayList<EmpenhoItem> itens = new ArrayList<EmpenhoItem>() {{
            add(item);
        }};
        
        Empenho empenho = new Empenho(fornecedor, new Timestamp(System.currentTimeMillis()), "8375584", 
                "observação bla bla bla bla bla bla", 12.2, itens);   
        empenho = EmpenhoDAO.create(empenho);
        
        
        EntradaItem itemEntrada = new EntradaItem(produto, 23.00, new Timestamp((System.currentTimeMillis())), 
                "lote8fs89", 30.00);
        
        ArrayList<EntradaItem> itensEntrada = new ArrayList<EntradaItem>() {{
            add(itemEntrada);
        }};
        
        Entrada obj = new Entrada(new Timestamp((System.currentTimeMillis())), "245", 1, "obs isufgsif", itensEntrada, empenho.getId());
        
        Entrada expResult = obj;
        Entrada result = EntradaDAO.create(obj);
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
        UnidadeDAO.create(unidade);
        Produto produto = ProdutoDAO.create(new Produto("Caneta Azul", unidade, 7.99));
        ProdutoDAO.create(produto);
        
        EntradaItem item = new EntradaItem(produto, 23.00, new Timestamp((System.currentTimeMillis())), 
                "lote8fs89", 29.00);
        
        ArrayList<EntradaItem> itens = new ArrayList<EntradaItem>() {{
            add(item);
        }};
        
        Entrada obj1 = new Entrada(1, new Timestamp((System.currentTimeMillis())), "245", 1, "fhehgjdjf", itens);
        EntradaDAO.update(obj1);
        Entrada obj2 = new Entrada(1, new Timestamp((System.currentTimeMillis())), "6464", 1, "46yyif", itens);
        EntradaDAO.update(obj2);
        
        EntradaDAO.retreave(1);        
    }
    
//    @Test
//    public void testDelete() throws Exception {
//        System.out.println("delete");
//        Unidade unidade = UnidadeDAO.create(new Unidade("Metros", "mt"));
//        Produto produto = ProdutoDAO.create(new Produto("Placa de trânsito", unidade, 23.00, 2.0));
//        EntradaItem obj = new EntradaItem(produto, 1, 23.00, new Timestamp((System.currentTimeMillis())), 
//                "lote8fs89", 1, 0.0);
//        EntradaItemDAO.create(obj);
//        EntradaItemDAO.delete(obj);
//    }
}
