package constructor;
/**
 *
 * @author Barbara
 */

import java.sql.Timestamp;

public class Requisicao {

    private int id;
    private Servidor servidor;

    private Timestamp data;
    private String observacao;

    public Requisicao(Servidor servidor, Timestamp data, String observacao) {
        this.servidor = servidor;
        this.data = data;
        this.observacao = observacao;
    }

    public Requisicao(int id, Servidor servidor, Timestamp data, String observacao) {
        this.id = id;
        this.servidor = servidor;
        this.data = data;
        this.observacao = observacao;
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

    @Override
    public String toString() {
        return "Requisicao{" + "id=" + id + ", servidor=" + servidor + ", data=" + data + ", observacao=" + observacao + '}';
    }

}
