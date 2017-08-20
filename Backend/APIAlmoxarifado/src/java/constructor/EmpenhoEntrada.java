package constructor;

public class EmpenhoEntrada {
    
    private int id;
    private int empenhoId;
    private int entradaid;

    public EmpenhoEntrada(int id, int empenhoId, int entradaid) {
        this.id = id;
        this.empenhoId = empenhoId;
        this.entradaid = entradaid;
    }
    
    public EmpenhoEntrada(int empenhoId, int entradaid) {
        this.empenhoId = empenhoId;
        this.entradaid = entradaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpenhoId() {
        return empenhoId;
    }

    public void setEmpenhoId(int empenhoId) {
        this.empenhoId = empenhoId;
    }

    public int getEntradaid() {
        return entradaid;
    }

    public void setEntradaid(int entradaid) {
        this.entradaid = entradaid;
    }

    @Override
    public String toString() {
        return "EmpenhoEntrada{" + "id=" + id + ", empenhoId=" + empenhoId + ", entradaid=" + entradaid + '}';
    }
    
}
