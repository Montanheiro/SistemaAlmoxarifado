package constructor;
/**
 *
 * @author Barbara
 */

public class Servidor {

    private int id;
    private Setor setor;
    private String nome;
    private String siape;
    private String funcao;

    public Servidor(Setor setor, String nome, String siape, String funcao) {
        this.setor = setor;
        this.nome = nome;
        this.siape = siape;
        this.funcao = funcao;
    }

    public Servidor(int id, Setor setor, String nome, String siape, String funcao) {
        this.id = id;
        this.setor = setor;
        this.nome = nome;
        this.siape = siape;
        this.funcao = funcao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Servidor{" + "id=" + id + ", setor=" + setor + ", nome=" + nome + ", siape=" + siape + ", funcao=" + funcao + '}';
    }

}
