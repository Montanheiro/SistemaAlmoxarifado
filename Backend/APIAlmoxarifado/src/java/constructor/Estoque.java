package constructor;

public class Estoque {

    private int id;
    private Produto produto;
    private double minimo;
    private double qtd;

    public Estoque(Produto produto, double minimo, double qtd) {
        this.produto = produto;
        this.minimo = minimo;
        this.qtd = qtd;
    }

    public Estoque(int id, Produto produto, double minimo, double qtd) {
        this.id = id;
        this.produto = produto;
        this.minimo = minimo;
        this.qtd = qtd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
        return "Estoque{" + "id=" + id + ", produto=" + produto + ", minimo=" + minimo + ", qtd=" + qtd + '}';
    }

}
