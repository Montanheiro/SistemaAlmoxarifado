package constructor;

/**
 *
 * @author Barbara
 */
public class ProdutoFornecedor {

    private int id;
    private int fornecedorId;
    private int produtoId;

    public ProdutoFornecedor() {
    }

    public ProdutoFornecedor(int fornecedorId, int produtoId) {
        this.fornecedorId = fornecedorId;
        this.produtoId = produtoId;
    }

    public ProdutoFornecedor(int id, int fornecedorId, int produtoId) {
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
        return "ProdutoFornecedor{" + "id=" + id + ", fornecedorId=" + fornecedorId + ", produtoId=" + produtoId + '}';
    }

}
