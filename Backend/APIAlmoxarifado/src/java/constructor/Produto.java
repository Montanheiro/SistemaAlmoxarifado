package constructor;

import java.sql.Date;

public class Produto {

    private int id;
    private String descricao;
    private String marca;
    private double peso;
    private double dimensao;

    public Produto(String descricao, String marca, double peso, double dimensao) {
        this.descricao = descricao;
        this.marca = marca;
        this.peso = peso;
        this.dimensao = dimensao;
    }

    public Produto(int id, String descricao, String marca, double peso, double dimensao) {
        this.id = id;
        this.descricao = descricao;
        this.marca = marca;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", marca=" + marca + ", peso=" + peso + ", dimensao=" + dimensao + '}';
    }

}
