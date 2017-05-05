package constructor;
/**
 *
 * @author Barbara
 */

import java.sql.Date;

public class Entrada {

    private int id;

    private Produto produto;
    private double qtd;
    private Date data;
    private Date validade;
    private String lote;
    private String nfNumero;
    private int considerarValorSequencia;

    public Entrada(Produto produto, double qtd, Date data, Date validade, String lote, String nfNumero, int considerarValorSequencia) {
        this.produto = produto;
        this.qtd = qtd;
        this.data = data;
        this.validade = validade;
        this.lote = lote;
        this.nfNumero = nfNumero;
        this.considerarValorSequencia = considerarValorSequencia;
    }

    public Entrada(int id, Produto produto, double qtd, Date data, Date validade, String lote, String nfNumero, int considerarValorSequencia) {
        this.id = id;
        this.produto = produto;
        this.qtd = qtd;
        this.data = data;
        this.validade = validade;
        this.lote = lote;
        this.nfNumero = nfNumero;
        this.considerarValorSequencia = considerarValorSequencia;
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

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
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

    public int getConsiderarValorSequencia() {
        return considerarValorSequencia;
    }

    public void setConsiderarValorSequencia(int considerarValorSequencia) {
        this.considerarValorSequencia = considerarValorSequencia;
    }

    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", produto=" + produto + ", qtd=" + qtd + ", data=" + data + ", validade=" + validade + ", lote=" + lote + ", nfNumero=" + nfNumero + ", considerarValorSequencia=" + considerarValorSequencia + '}';
    }

}
