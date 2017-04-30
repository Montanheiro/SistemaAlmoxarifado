package constructor;

public class Servidor {

    private int id;
    private int setorId;
    private String nome;
    private String siape;
    private String funcao;

    public Servidor(int id, int setorId, String nome, String siape, String funcao) {
        this.id = id;
        this.setorId = setorId;
        this.nome = nome;
        this.siape = siape;
        this.funcao = funcao;
    }

    public Servidor(String nome, String siape, String funcao) {
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

    public int getSetorId() {
        return setorId;
    }

    public void setSetorId(int setorId) {
        this.setorId = setorId;
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
        return "Servidor{" + "id=" + id + ", nome=" + nome + ", siape=" + siape + ", funcao=" + funcao + '}';
    }

}
