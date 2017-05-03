package constructor;

public class Saida {

    private int id;
    private Requisicao requisicao;

    private double qtdGeral;
    private double precoUnitario;

    public Saida(Requisicao requisicao, double qtdGeral, double precoUnitario) {
        this.requisicao = requisicao;
        this.qtdGeral = qtdGeral;
        this.precoUnitario = precoUnitario;
    }

    public Saida(int id, Requisicao requisicao, double qtdGeral, double precoUnitario) {
        this.id = id;
        this.requisicao = requisicao;
        this.qtdGeral = qtdGeral;
        this.precoUnitario = precoUnitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public double getQtdGeral() {
        return qtdGeral;
    }

    public void setQtdGeral(double qtdGeral) {
        this.qtdGeral = qtdGeral;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "Saida{" + "id=" + id + ", requisicao=" + requisicao + ", qtdGeral=" + qtdGeral + ", precoUnitario=" + precoUnitario + '}';
    }

}
