package constructor;

public class RequisicaoProduto {

    private int id;
    private int requisicaoId;
    private Produto produto;
    private double qtd;

    public RequisicaoProduto(int id, int requisicaoId, Produto produto, double qtd) {
        this.id = id;
        this.requisicaoId = requisicaoId;
        this.produto = produto;
        this.qtd = qtd;
    }

    public RequisicaoProduto(Produto produto, double qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequisicaoId() {
        return requisicaoId;
    }

    public void setRequisicaoId(int requisicaoId) {
        this.requisicaoId = requisicaoId;
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
        return "ProdutoRequisicao{" + "id=" + id + ", requisicaoId=" + requisicaoId + ", produto=" + produto + ", qtd=" + qtd + '}';
    }

}
