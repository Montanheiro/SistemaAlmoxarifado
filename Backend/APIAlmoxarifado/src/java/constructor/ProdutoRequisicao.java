package constructor;

/**
 *
 * @author Barbara
 */
public class ProdutoRequisicao {

    private int id;
    private Requisicao requisicao;
    private Produto produto;
    private double qtd;

    public ProdutoRequisicao(Requisicao requisicao, Produto produto, double qtd) {
        this.requisicao = requisicao;
        this.produto = produto;
        this.qtd = qtd;
    }

    public ProdutoRequisicao(int id, Requisicao requisicao, Produto produto, double qtd) {
        this.id = id;
        this.requisicao = requisicao;
        this.produto = produto;
        this.qtd = qtd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "ProdutoRequisicao{" + "id=" + id + ", requisicao=" + requisicao + ", produto=" + produto + ", qtd=" + qtd + '}';
    }

}
