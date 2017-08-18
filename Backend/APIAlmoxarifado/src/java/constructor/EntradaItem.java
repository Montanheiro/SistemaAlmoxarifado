package constructor;

import java.sql.Timestamp;

public class EntradaItem {

    private int id;
    private Produto produto;
    private int entradaId;
    private double qtd;
    private Timestamp validade;
    private String lote;
    private int considerarValorEmpenho;
    private Double valor_unitario;

    public EntradaItem(int id, Produto produto, int entradaId, double qtd, Timestamp validade, String lote, int considerarValorEmpenho, Double valor_unitario) {
        this.id = id;
        this.produto = produto;
        this.entradaId = entradaId;
        this.qtd = qtd;
        this.validade = validade;
        this.lote = lote;
        this.considerarValorEmpenho = considerarValorEmpenho;
        this.valor_unitario = valor_unitario;
    }

    public EntradaItem(Produto produto, int entradaId, double qtd, Timestamp validade, String lote, int considerarValorEmpenho, Double valor_unitario) {
        this.produto = produto;
        this.entradaId = entradaId;
        this.qtd = qtd;
        this.validade = validade;
        this.lote = lote;
        this.considerarValorEmpenho = considerarValorEmpenho;
        this.valor_unitario = valor_unitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getEntradaId() {
        return entradaId;
    }

    public void setEntradaId(int entradaId) {
        this.entradaId = entradaId;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public Timestamp getValidade() {
        return validade;
    }

    public void setValidade(Timestamp validade) {
        this.validade = validade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getConsiderarValorEmpenho() {
        return considerarValorEmpenho;
    }

    public void setConsiderarValorEmpenho(int considerarValorEmpenho) {
        this.considerarValorEmpenho = considerarValorEmpenho;
    }

    public Double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(Double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    @Override
    public String toString() {
        return "EntradaItem{" + "id=" + id + ", produto=" + produto + ", entradaId=" + entradaId + ", qtd=" + qtd + ", validade=" + validade + ", lote=" + lote + ", considerarValorEmpenho=" + considerarValorEmpenho + ", valor_unitario=" + valor_unitario + '}';
    }

}
