package constructor;

public class Visitante {

    private int id;
    private int qtd;

    private Setor setor;

    public Visitante() {
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

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Visitante{" + "id=" + id + ", qtd=" + qtd + ", setor=" + setor + '}';
    }

}
