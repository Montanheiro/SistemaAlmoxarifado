package constructor;

/**
 *
 * @author lucas
 */
public class EntradaDoacaoTransferencia {
    
    private int id;
    private Entrada entrada;
    private DoacaoOuTransferencia doacaoTransferencia;

    public EntradaDoacaoTransferencia(Entrada entrada, DoacaoOuTransferencia doacaoTransferencia) {
        this.entrada = entrada;
        this.doacaoTransferencia = doacaoTransferencia;
    }

    public EntradaDoacaoTransferencia(int id, Entrada entrada, DoacaoOuTransferencia doacaoTransferencia) {
        this.id = id;
        this.entrada = entrada;
        this.doacaoTransferencia = doacaoTransferencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public DoacaoOuTransferencia getDoacaoTransferencia() {
        return doacaoTransferencia;
    }

    public void setDoacaoTransferencia(DoacaoOuTransferencia doacaoTransferencia) {
        this.doacaoTransferencia = doacaoTransferencia;
    }

    @Override
    public String toString() {
        return "EntradaDoacaoTransferencia{" + "id=" + id + ", entrada=" + entrada + ", doacaoTransferencia=" + doacaoTransferencia + '}';
    }

}
