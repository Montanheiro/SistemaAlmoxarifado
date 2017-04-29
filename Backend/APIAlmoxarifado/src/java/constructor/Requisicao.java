package constructor;

public class Requisicao {

    private int id;
    private double qtd;

    private Setor setor;

    public Requisicao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
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
        return "Requisicao{" + "id=" + id + ", qtd=" + qtd + ", setor=" + setor + '}';
    }
    
}
