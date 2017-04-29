package constructor;

/**
 *
 * @author Barbara
 */
public class Saida {

    private int id;
    private double qtdGeral;
    private double precoUnitario;

    private Requisicao requisicao;

    public Saida() {
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

}
