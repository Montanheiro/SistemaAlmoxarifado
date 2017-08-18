/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructor;

/**
 *
 * @author lucas
 */
public class PatrimonioAtual {
    
    private int id;
    private Produto produto;
    private double qtd;
    private double valorTotal;

    public PatrimonioAtual(Produto produto, double qtd, double valorTotal) {
        this.produto = produto;
        this.qtd = qtd;
        this.valorTotal = valorTotal;
    }

    public PatrimonioAtual(int id, Produto produto, double qtd, double valorTotal) {
        this.id = id;
        this.produto = produto;
        this.qtd = qtd;
        this.valorTotal = valorTotal;
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

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "EstoqueBruto{" + "id=" + id + ", produto=" + produto + ", qtd=" + qtd + ", valorTotal=" + valorTotal + '}';
    }
    
}
