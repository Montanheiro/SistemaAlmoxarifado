package constructor;

import java.sql.Date;

public class Requisicao {

    private int id;
    private int servidorId;

    private Date data;
    private String observacao;

    public Requisicao(Date data, String observacao) {
        this.data = data;
        this.observacao = observacao;
    }

    public Requisicao(int id, int servidorId, Date data, String observacao) {
        this.id = id;
        this.servidorId = servidorId;
        this.data = data;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServidorId() {
        return servidorId;
    }

    public void setServidorId(int servidorId) {
        this.servidorId = servidorId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
        return "Requisicao{" + "id=" + id + ", servidorId=" + servidorId + ", data=" + data + ", observacao=" + observacao + '}';
    }

}
