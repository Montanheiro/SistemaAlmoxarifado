package constructor;

import java.sql.Timestamp;
import java.util.ArrayList;

public class DoacaoOuTransferencia {

    private int id;
    private Tipo tipo;
    private String responsavel;
    
    //dados da entrada automática
    private Timestamp data;
    private String nfNumero;
    private String observacao;
    
    //dados dos itens
    private ArrayList<EntradaItem> itens = new ArrayList<>();

    public DoacaoOuTransferencia(int id, Tipo tipo, String responsavel, Timestamp data, String nfNumero, String observacao, ArrayList<EntradaItem> itens) {
        this.id = id;
        this.tipo = tipo;
        this.responsavel = responsavel;
        this.data = data;
        this.nfNumero = nfNumero;
        this.observacao = observacao;
        this.itens = itens;
    }

    public DoacaoOuTransferencia(Tipo tipo, String responsavel, Timestamp data, String nfNumero, String observacao, ArrayList<EntradaItem> itens) {
        this.tipo = tipo;
        this.responsavel = responsavel;
        this.data = data;
        this.nfNumero = nfNumero;
        this.observacao = observacao;
        this.itens = itens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getNfNumero() {
        return nfNumero;
    }

    public void setNfNumero(String nfNumero) {
        this.nfNumero = nfNumero;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public ArrayList<EntradaItem> getItens() {
        return itens;
    }

    public void setItens(ArrayList<EntradaItem> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "DoacaoOuTransferencia{" + "id=" + id + ", tipo=" + tipo + ", responsavel=" + responsavel + ", data=" + data + ", nfNumero=" + nfNumero + ", observacao=" + observacao + ", itens=" + itens + '}';
    }

}
