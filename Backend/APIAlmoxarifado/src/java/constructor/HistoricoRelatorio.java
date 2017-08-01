/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructor;

import java.sql.Timestamp;

/**
 *
 * @author lucas
 */
public class HistoricoRelatorio {
    
    private int id;
    private Produto produto;
    private Timestamp mes;
    private double qtd;
    private double valorTotal;

    public HistoricoRelatorio(Produto produto, Timestamp mes, double qtd, double valortotal) {
        this.produto = produto;
        this.mes = mes;
        this.qtd = qtd;
        this.valorTotal = valortotal;
    }

    public HistoricoRelatorio(int id, Produto produto, Timestamp mes, double qtd, double valortotal) {
        this.id = id;
        this.produto = produto;
        this.mes = mes;
        this.qtd = qtd;
        this.valorTotal = valortotal;
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

    public Timestamp getMes() {
        return mes;
    }

    public void setMes(Timestamp mes) {
        this.mes = mes;
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
        return "HistoricoRelatorio{" + "id=" + id + ", produto=" + produto + ", mes=" + mes + ", qtd=" + qtd + ", valortotal=" + valorTotal + '}';
    }
    
}
