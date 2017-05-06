package constructor;

import java.sql.Timestamp;

/**
 *
 * @author lucas
 */
public class LogErro {
    
    private int id;
    private Usuario usuario;
    private Timestamp data;
    private String erro;

    public LogErro(int id, Usuario usuario, Timestamp data, String erro) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
        this.erro = erro;
    }

    public LogErro(Usuario usuario, String erro) {
        this.usuario = usuario;
        this.erro = erro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    @Override
    public String toString() {
        return "LogErro{" + "id=" + id + ", usuario=" + usuario + ", data=" + data + ", erro=" + erro + '}';
    }
    
}
