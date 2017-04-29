package constructor;

import java.sql.Date;

public class Empenho {

    private int id;
    private Date emissao;
    private String numero;
    private String especie;
    private Fornecedor fornecedor;
    private Endereco endereco;
    private String observacao;
    private double valor;
    private NaturezaDespesa naturezaDespesa;
    private int sequencia;
    private double qtd;
    private double valorUnitario;
    private double valorSequencia;
    private String embalagem;
    private String descricao;
    private String itemProcesso;
    private String marca;
    private String itemMaterial;

    public Empenho() {
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public NaturezaDespesa getNaturezaDespesa() {
        return naturezaDespesa;
    }

    public void setNaturezaDespesa(NaturezaDespesa naturezaDespesa) {
        this.naturezaDespesa = naturezaDespesa;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorSequencia() {
        return valorSequencia;
    }

    public void setValorSequencia(double valorSequencia) {
        this.valorSequencia = valorSequencia;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getItemProcesso() {
        return itemProcesso;
    }

    public void setItemProcesso(String itemProcesso) {
        this.itemProcesso = itemProcesso;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getItemMaterial() {
        return itemMaterial;
    }

    public void setItemMaterial(String itemMaterial) {
        this.itemMaterial = itemMaterial;
    }

    @Override
    public String toString() {
        return "Empenho{" + "id=" + id + ", emissao=" + emissao + ", numero=" + numero + ", especie=" + especie + ", fornecedor=" + fornecedor + ", endereco=" + endereco + ", observacao=" + observacao + ", valor=" + valor + ", naturezaDespesa=" + naturezaDespesa + ", sequencia=" + sequencia + ", qtd=" + qtd + ", valorUnitario=" + valorUnitario + ", valorSequencia=" + valorSequencia + ", embalagem=" + embalagem + ", descricao=" + descricao + ", itemProcesso=" + itemProcesso + ", marca=" + marca + ", itemMaterial=" + itemMaterial + '}';
    }

}
