package constructor;

/**
 *
 * @author lucas
 */
public class EntradaDocaoTransferencia {
    
    private int id;
    private int entradaId;
    private int doacaoTransferenciaId;

    public EntradaDocaoTransferencia(int id, int entradaId, int doacaoTransferenciaId) {
        this.id = id;
        this.entradaId = entradaId;
        this.doacaoTransferenciaId = doacaoTransferenciaId;
    }

    public EntradaDocaoTransferencia(int entradaId, int doacaoTransferenciaId) {
        this.entradaId = entradaId;
        this.doacaoTransferenciaId = doacaoTransferenciaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntradaId() {
        return entradaId;
    }

    public void setEntradaId(int entradaId) {
        this.entradaId = entradaId;
    }

    public int getDoacaoTransferenciaId() {
        return doacaoTransferenciaId;
    }

    public void setDoacaoTransferenciaId(int doacaoTransferenciaId) {
        this.doacaoTransferenciaId = doacaoTransferenciaId;
    }

    @Override
    public String toString() {
        return "EntradaDocaoTransferencia{" + "id=" + id + ", entradaId=" + entradaId + ", doacaoTransferenciaId=" + doacaoTransferenciaId + '}';
    }
    
}
