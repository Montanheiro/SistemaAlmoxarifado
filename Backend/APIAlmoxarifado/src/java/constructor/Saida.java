package constructor;

public class Saida {

    private int id;
    private double qtdGeral;
    private double precoUnitario;

    private Requisicao requisicao;

    public Saida(int id, double qtdGeral, double precoUnitario, Requisicao requisicao) {
        this.id = id;
        this.qtdGeral = qtdGeral;
        this.precoUnitario = precoUnitario;
        this.requisicao = requisicao;
    }

    public Saida(double qtdGeral, double precoUnitario, Requisicao requisicao) {
        this.qtdGeral = qtdGeral;
        this.precoUnitario = precoUnitario;
        this.requisicao = requisicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    @Override
    public String toString() {
        return "Saida{" + "id=" + id + ", qtdGeral=" + qtdGeral + ", precoUnitario=" + precoUnitario + ", requisicao=" + requisicao + '}';
    }

}
