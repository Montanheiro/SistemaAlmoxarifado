package constructor;

import java.sql.Date;

public class Produto {

    private int id;
    private String descricao;
    private Date validade;
    private double valorUnitario;
    private String marca;
    private String lote;
    private double peso;
    private double dimensao;

    public Produto(int id, String descricao, Date validade, double valorUnitario, String marca, String lote, double peso, double dimensao) {
        this.id = id;
        this.descricao = descricao;
        this.validade = validade;
        this.valorUnitario = valorUnitario;
        this.marca = marca;
        this.lote = lote;
        this.peso = peso;
        this.dimensao = dimensao;
    }

    public Produto(String descricao, Date validade, double valorUnitario, String marca, String lote, double peso, double dimensao) {
        this.descricao = descricao;
        this.validade = validade;
        this.valorUnitario = valorUnitario;
        this.marca = marca;
        this.lote = lote;
        this.peso = peso;
        this.dimensao = dimensao;
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

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", validade=" + validade + ", valorUnitario=" + valorUnitario + ", marca=" + marca + ", lote=" + lote + ", peso=" + peso + ", dimensao=" + dimensao + '}';
    }

}
