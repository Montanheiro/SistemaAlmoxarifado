package constructor;

/**
 *
 * @author Barbara
 */
public class RequisicaoProduto {

    private int id;
    private int requisicaoId;
    private int produtoId;

    public RequisicaoProduto() {
    }

    public RequisicaoProduto(int requisicaoId, int produtoId) {
        this.requisicaoId = requisicaoId;
        this.produtoId = produtoId;
    }

    public RequisicaoProduto(int id, int requisicaoId, int produtoId) {
        this.id = id;
        this.requisicaoId = requisicaoId;
        this.produtoId = produtoId;
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

    @Override
    public String toString() {
        return "RequisicaoProduto{" + "id=" + id + ", requisicaoId=" + requisicaoId + ", produtoId=" + produtoId + '}';
    }

}
