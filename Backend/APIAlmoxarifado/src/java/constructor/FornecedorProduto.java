package constructor;

/**
 *
 * @author Barbara
 */
public class FornecedorProduto {

    private int id;
    private int fornecedorId;
    private int produtoId;

    public FornecedorProduto() {
    }

    public FornecedorProduto(int fornecedorId, int produtoId) {
        this.fornecedorId = fornecedorId;
        this.produtoId = produtoId;
    }

    public FornecedorProduto(int id, int fornecedorId, int produtoId) {
        this.id = id;
        this.fornecedorId = fornecedorId;
        this.produtoId = produtoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public String toString() {
        return "FornecedorProduto{" + "id=" + id + ", fornecedorId=" + fornecedorId + ", produtoId=" + produtoId + '}';
    }

}
