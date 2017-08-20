package constructor;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Requisicao {

    private int id;
    private Servidor servidor;
    private Timestamp data;
    private String observacao;
    
    private ArrayList<RequisicaoProduto> itens = new ArrayList<>();

    public Requisicao(Servidor servidor, Timestamp data, String observacao, ArrayList<RequisicaoProduto> itens) {
        this.servidor = servidor;
        this.data = data;
        this.observacao = observacao;
        this.itens = itens;
    }

    public Requisicao(int id, Servidor servidor, Timestamp data, String observacao, ArrayList<RequisicaoProduto> itens) {
        this.id = id;
        this.servidor = servidor;
        this.data = data;
        this.observacao = observacao;
        this.itens = itens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public ArrayList<RequisicaoProduto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<RequisicaoProduto> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Requisicao{" + "id=" + id + ", servidor=" + servidor + ", data=" + data + ", observacao=" + observacao + ", itens=" + itens + '}';
    }

}
