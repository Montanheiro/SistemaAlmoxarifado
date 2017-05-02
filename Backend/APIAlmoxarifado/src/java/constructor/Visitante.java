package constructor;

public class Visitante {

    private int id;
    private int qtd;

    private int setorId;

    public Visitante(int id, int qtd, int setorId) {
        this.id = id;
        this.qtd = qtd;
        this.setorId = setorId;
    }

    public Visitante(int qtd) {
        this.qtd = qtd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getSetorId() {
        return setorId;
    }

    public void setSetorId(int setorId) {
        this.setorId = setorId;
    }

    @Override
    public String toString() {
        return "Visitante{" + "id=" + id + ", qtd=" + qtd + ", setorId=" + setorId + '}';
    }

}
