package constructor;
/**
 *
 * @author Barbara
 */

public class Produto {

    private int id;
    private String descricao;
    private String marca;
    private double peso;
    private double dimensao;
    
    private Unidade unidade;

    public Produto(String descricao, String marca, double peso, double dimensao, Unidade unidade) {
        this.descricao = descricao;
        this.marca = marca;
        this.peso = peso;
        this.dimensao = dimensao;
        this.unidade = unidade;
    }

    public Produto(int id, String descricao, String marca, double peso, double dimensao, Unidade unidade) {
        this.id = id;
        this.descricao = descricao;
        this.marca = marca;
        this.peso = peso;
        this.dimensao = dimensao;
        this.unidade = unidade;
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

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", marca=" + marca + ", peso=" + peso + ", dimensao=" + dimensao + ", unidade=" + unidade + '}';
    }

}
