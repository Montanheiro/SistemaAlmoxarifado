package constructor;

/**
 *
 * @author Barbara
 */
public class ProdutoRequisicao {

    private int id;
    private int requisicaoId;
    private int produtoId;
    private int qtd;

    public ProdutoRequisicao(int qtd) {
        this.qtd = qtd;
    }

    public ProdutoRequisicao(int id, int requisicaoId, int produtoId, int qtd) {
        this.id = id;
        this.requisicaoId = requisicaoId;
        this.produtoId = produtoId;
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

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "ProdutoRequisicao{" + "id=" + id + ", requisicaoId=" + requisicaoId + ", produtoId=" + produtoId + ", qtd=" + qtd + '}';
    }

}
