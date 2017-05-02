package constructor;

import java.sql.Date;

public class Entrada {

    private int id;
    private int produtoEmpenhoId;

    private double qtd;
    private double precoUnitario;
    private Date data;
    private Date validade;
    private String lote;
    private String nfNumero;

    public Entrada(double qtd, double precoUnitario, Date data, Date validade, String lote, String nfNumero) {
        this.qtd = qtd;
        this.precoUnitario = precoUnitario;
        this.data = data;
        this.validade = validade;
        this.lote = lote;
        this.nfNumero = nfNumero;
    }

    public Entrada(int id, int produtoEmpenhoId, double qtd, double precoUnitario, Date data, Date validade, String lote) {
        this.id = id;
        this.produtoEmpenhoId = produtoEmpenhoId;
        this.qtd = qtd;
        this.precoUnitario = precoUnitario;
        this.data = data;
        this.validade = validade;
        this.lote = lote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoEmpenhoId() {
        return produtoEmpenhoId;
    }

    public void setProdutoEmpenhoId(int produtoEmpenhoId) {
        this.produtoEmpenhoId = produtoEmpenhoId;
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
        return "Entrada{" + "id=" + id + ", produtoEmpenhoId=" + produtoEmpenhoId + ", qtd=" + qtd + ", precoUnitario=" + precoUnitario + ", data=" + data + ", validade=" + validade + ", lote=" + lote + '}';
    }

}
