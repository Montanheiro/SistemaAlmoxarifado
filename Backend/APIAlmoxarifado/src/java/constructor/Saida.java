package constructor;

public class Saida {

    private int id;
    private int requisicaoId;

    private double qtdGeral;
    private double precoUnitario;

    public Saida(double qtdGeral, double precoUnitario) {
        this.qtdGeral = qtdGeral;
        this.precoUnitario = precoUnitario;
    }

    public Saida(int id, int requisicaoId, double qtdGeral, double precoUnitario) {
        this.id = id;
        this.requisicaoId = requisicaoId;
        this.qtdGeral = qtdGeral;
        this.precoUnitario = precoUnitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequisicaoId() {
        return requisicaoId;
    }

    public void setRequisicaoId(int requisicaoId) {
        this.requisicaoId = requisicaoId;
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
        return "Saida{" + "id=" + id + ", requisicaoId=" + requisicaoId + ", qtdGeral=" + qtdGeral + ", precoUnitario=" + precoUnitario + '}';
    }

}
