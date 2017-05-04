package constructor;
/**
 *
 * @author Barbara
 */

import java.sql.Date;

public class SaidaProdutos {

    private int id;
    private ProdutoRequisicao produtoRequisicao;

    private double qtd;
    private Date data;

    public SaidaProdutos(int id, ProdutoRequisicao produtoRequisicao, double qtd, Date data) {
        this.id = id;
        this.produtoRequisicao = produtoRequisicao;
        this.qtd = qtd;
        this.data = data;
    }

    public SaidaProdutos(ProdutoRequisicao produtoRequisicao, double qtd, Date data) {
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

    public ProdutoRequisicao getProdutoRequisicao() {
        return produtoRequisicao;
    }

    public void setProdutoRequisicao(ProdutoRequisicao produtoRequisicao) {
        this.produtoRequisicao = produtoRequisicao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SaidaProdutos{" + "id=" + id + ", produtoRequisicao=" + produtoRequisicao + ", qtd=" + qtd + ", data=" + data + '}';
    }
    
}
