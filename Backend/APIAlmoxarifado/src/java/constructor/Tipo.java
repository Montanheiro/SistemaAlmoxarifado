package constructor;

/**
 *
 * @author lucas
 */
public class Tipo {
    
    private int id;
    private String tipo;

    public Tipo(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Tipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tipos{" + "id=" + id + ", tipo=" + tipo + '}';
    }
    
}
