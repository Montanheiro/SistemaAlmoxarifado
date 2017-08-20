package constructor;
/**
 *
 * @author Barbara
 */

import java.sql.Timestamp;

public class SaidaProduto {

    private int id;
    private RequisicaoProduto produtoRequisicao;

    private double qtd;
    private Timestamp data;

    public SaidaProduto(int id, RequisicaoProduto produtoRequisicao, double qtd, Timestamp data) {
        this.id = id;
        this.produtoRequisicao = produtoRequisicao;
        this.qtd = qtd;
        this.data = data;
    }

    public SaidaProduto(RequisicaoProduto produtoRequisicao, double qtd, Timestamp data) {
        this.produtoRequisicao = produtoRequisicao;
        this.qtd = qtd;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public RequisicaoProduto getProdutoRequisicao() {
        return produtoRequisicao;
    }

    public void setProdutoRequisicao(RequisicaoProduto produtoRequisicao) {
        this.produtoRequisicao = produtoRequisicao;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SaidaProdutos{" + "id=" + id + ", produtoRequisicao=" + produtoRequisicao + ", qtd=" + qtd + ", data=" + data + '}';
    }
    
}
