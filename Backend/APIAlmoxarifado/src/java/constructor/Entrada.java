package constructor;

import java.sql.Timestamp;
import java.util.ArrayList;


public class Entrada {
    
    private int id;
    private Timestamp data;
    private String nfNumero;
    private int origem;
    private String observacao;
    
    private ArrayList<EntradaItem> itens = new ArrayList<>();

    public Entrada(int id, Timestamp data, String nfNumero, int origem, String observacao, ArrayList<EntradaItem> itens) {
        this.id = id;
        this.data = data;
        this.nfNumero = nfNumero;
        this.origem = origem;
        this.observacao = observacao;
        this.itens = itens;
    }

    public Entrada(Timestamp data, String nfNumero, int origem, String observacao, ArrayList<EntradaItem> itens) {
        this.data = data;
        this.nfNumero = nfNumero;
        this.origem = origem;
        this.observacao = observacao;
        this.itens = itens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public ArrayList<EntradaItem> getItens() {
        return itens;
    }

    public void setItens(ArrayList<EntradaItem> itens) {
        this.itens = itens;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", data=" + data + ", nfNumero=" + nfNumero + ", origem=" + origem + ", observacao=" + observacao + ", itens=" + itens + '}';
    }
    
}
