package constructor;

import java.sql.Date;

public class Entrada {

    private int id;

    private double qtd;
    private Date data;
    private Date validade;
    private String lote;
    private String nfNumero;
    private int considerarValorSequencia;

    public Entrada(int id, double qtd, Date data, Date validade, String lote, String nfNumero, int considerarValorSequencia) {
        this.id = id;
        this.qtd = qtd;
        this.data = data;
        this.validade = validade;
        this.lote = lote;
        this.nfNumero = nfNumero;
        this.considerarValorSequencia = considerarValorSequencia;
    }

    public Entrada(double qtd, Date data, Date validade, String lote, String nfNumero, int considerarValorSequencia) {
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

    public int isConsiderarValorSequencia() {
        return considerarValorSequencia;
    }

    public void setConsiderarValorSequencia(int considerarValorSequencia) {
        this.considerarValorSequencia = considerarValorSequencia;
    }

    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", qtd=" + qtd + ", data=" + data + ", validade=" + validade + ", lote=" + lote + ", nfNumero=" + nfNumero + ", considerarValorSequencia=" + considerarValorSequencia + '}';
    }

}
