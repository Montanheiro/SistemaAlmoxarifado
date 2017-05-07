package constructor;

import java.sql.Timestamp;


public class Empenho {

    private int id;
    private Fornecedor fornecedor;
    private Timestamp emissao;
    private String numero;
    private String observacao;
    private double valorTotal;

    public Empenho(Fornecedor fornecedor, Timestamp emissao, String numero, String observacao, double valorTotal) {
        this.fornecedor = fornecedor;
        this.emissao = emissao;
        this.numero = numero;
        this.observacao = observacao;
        this.valorTotal = valorTotal;
    }

    public Empenho(int id, Fornecedor fornecedor, Timestamp emissao, String numero, String observacao, double valorTotal) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.emissao = emissao;
        this.numero = numero;
        this.observacao = observacao;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Timestamp getEmissao() {
        return emissao;
    }

    public void setEmissao(Timestamp emissao) {
        this.emissao = emissao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Empenho{" + "id=" + id + ", fornecedor=" + fornecedor + ", emissao=" + emissao + ", numero=" + numero + ", observacao=" + observacao + ", valorTotal=" + valorTotal + '}';
    }

}
