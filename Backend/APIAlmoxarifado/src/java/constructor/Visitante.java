package constructor;

public class Visitante {

    private int id;
    private int qtd;

    private int setor;

    public Visitante(int id, int qtd, int setor) {
        this.id = id;
        this.qtd = qtd;
        this.setor = setor;
    }

    public Visitante(int qtd, int setor) {
        this.qtd = qtd;
        this.setor = setor;
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

    public int getSetor() {
        return setor;
    }

    public void setSetor(int setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Visitante{" + "id=" + id + ", qtd=" + qtd + ", setor=" + setor + '}';
    }

}
