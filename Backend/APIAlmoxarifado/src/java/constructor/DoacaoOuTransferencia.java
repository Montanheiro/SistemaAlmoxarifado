package constructor;

/**
 *
 * @author lucas
 */
public class DoacaoOuTransferencia {

    private int id;
    private Tipo tipo;
    private String responsavel;

    public DoacaoOuTransferencia(int id, Tipo tipo, String responsavel) {
        this.id = id;
        this.responsavel = responsavel;
        this.tipo = tipo;
    }

    public DoacaoOuTransferencia(Tipo tipo, String responsavel) {
        this.responsavel = responsavel;
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "DoacaoOuTransferencia{" + "id=" + id + ", tipo=" + tipo + ", responsavel=" + responsavel + '}';
    }

}
