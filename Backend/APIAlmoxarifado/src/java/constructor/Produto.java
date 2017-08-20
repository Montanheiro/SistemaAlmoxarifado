package constructor;

public class Produto {

    private int id;
    private String descricao;
    private Unidade unidade;
    private Double estoque;
    private Double valorTotal;
    private Double estoque_minimo;

    public Produto(int id, String descricao, Unidade unidade, Double estoque, Double valorTotal, Double estoque_minimo) {
        this.id = id;
        this.descricao = descricao;
        this.unidade = unidade;
        this.estoque = estoque;
        this.valorTotal = valorTotal;
        this.estoque_minimo = estoque_minimo;
    }

    public Produto(int id, String descricao, Unidade unidade, Double estoque_minimo) {
        this.id = id;
        this.descricao = descricao;
        this.unidade = unidade;
        this.estoque_minimo = estoque_minimo;
    }

    public Produto(String descricao, Unidade unidade, Double estoque_minimo) {
        this.descricao = descricao;
        this.unidade = unidade;
        this.estoque_minimo = estoque_minimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getEstoque_minimo() {
        return estoque_minimo;
    }

    public void setEstoque_minimo(Double estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", unidade=" + unidade + ", estoque=" + estoque + ", valorTotal=" + valorTotal + ", estoque_minimo=" + estoque_minimo + '}';
    }

}
