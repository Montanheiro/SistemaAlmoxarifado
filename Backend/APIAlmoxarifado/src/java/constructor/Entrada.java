package constructor;

import java.sql.Date;

public class Entrada {

    private int id;
    private ProdutoEmpenho produtoEmpenho;

    private double qtd;
    private double precoUnitario;
    private Date data;
    private Date validade;
    private String lote;
    private String nfNumero;

    public Entrada(ProdutoEmpenho produtoEmpenho, double qtd, double precoUnitario, Date data, Date validade, String lote, String nfNumero) {
        this.produtoEmpenho = produtoEmpenho;
        this.qtd = qtd;
        this.precoUnitario = precoUnitario;
        this.data = data;
        this.validade = validade;
        this.lote = lote;
        this.nfNumero = nfNumero;
    }

    public Entrada(int id, ProdutoEmpenho produtoEmpenho, double qtd, double precoUnitario, Date data, Date validade, String lote, String nfNumero) {
        this.id = id;
        this.produtoEmpenho = produtoEmpenho;
        this.qtd = qtd;
        this.precoUnitario = precoUnitario;
        this.data = data;
        this.validade = validade;
        this.lote = lote;
        this.nfNumero = nfNumero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProdutoEmpenho getProdutoEmpenho() {
        return produtoEmpenho;
    }

    public void setProdutoEmpenho(ProdutoEmpenho produtoEmpenho) {
        this.produtoEmpenho = produtoEmpenho;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getNfNumero() {
        return nfNumero;
    }

    public void setNfNumero(String nfNumero) {
        this.nfNumero = nfNumero;
    }

    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", produtoEmpenho=" + produtoEmpenho + ", qtd=" + qtd + ", precoUnitario=" + precoUnitario + ", data=" + data + ", validade=" + validade + ", lote=" + lote + ", nfNumero=" + nfNumero + '}';
    }

}
