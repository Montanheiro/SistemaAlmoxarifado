package constructor;

public class Estoque {

    private int id;
    private int produtoId;
    private double minimo;
    private double qtd;

    public Estoque(double minimo, double qtd) {
        this.minimo = minimo;
        this.qtd = qtd;
    }

    public Estoque(int id, int produtoId, double minimo, double qtd) {
        this.id = id;
        this.produtoId = produtoId;
        this.minimo = minimo;
        this.qtd = qtd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "Estoque{" + "id=" + id + ", produtoId=" + produtoId + ", minimo=" + minimo + ", qtd=" + qtd + '}';
    }

}
