package constructor;

import java.sql.Date;

public class Empenho {

    private int id;
    private Date emissao;
    private String numero;
    private String especie;
    private String observacao;
    private double valorTotal;

    private Fornecedor fornecedor;

    public Empenho(Date emissao, String numero, String especie, String observacao, double valorTotal, Fornecedor fornecedor) {
        this.emissao = emissao;
        this.numero = numero;
        this.especie = especie;
        this.observacao = observacao;
        this.valorTotal = valorTotal;
        this.fornecedor = fornecedor;
    }

    public Empenho(int id, Date emissao, String numero, String especie, String observacao, double valorTotal, Fornecedor fornecedor) {
        this.id = id;
        this.emissao = emissao;
        this.numero = numero;
        this.especie = especie;
        this.observacao = observacao;
        this.valorTotal = valorTotal;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Empenho{" + "id=" + id + ", emissao=" + emissao + ", numero=" + numero + ", especie=" + especie + ", observacao=" + observacao + ", valorTotal=" + valorTotal + ", fornecedor=" + fornecedor + '}';
    }

}
