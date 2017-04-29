package constructor;

import java.sql.Date;

public class Entrada {

    private int id;
    private double qtd;
    private double precoUnitario;
    private Produto produto;
    private Date data;

    public Entrada(int id, double qtd, double precoUnitario, Produto produto, Date data) {
        this.id = id;
        this.qtd = qtd;
        this.precoUnitario = precoUnitario;
        this.produto = produto;
        this.data = data;
    }

    public Entrada(double qtd, double precoUnitario, Produto produto, Date data) {
        this.qtd = qtd;
        this.precoUnitario = precoUnitario;
        this.produto = produto;
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

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", qtd=" + qtd + ", precoUnitario=" + precoUnitario + ", produto=" + produto + ", data=" + data + '}';
    }
}
