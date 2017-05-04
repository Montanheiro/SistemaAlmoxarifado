package constructor;

/**
 *
 * @author lucas
 */
public class Unidade {

    private int id;
    private String nome;
    private String abreviacao;

    public Unidade(String nome, String abreviacao) {
        this.nome = nome;
        this.abreviacao = abreviacao;
    }

    public Unidade(int id, String nome, String abreviacao) {
        this.id = id;
        this.nome = nome;
        this.abreviacao = abreviacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    @Override
    public String toString() {
        return "Unidade{" + "id=" + id + ", nome=" + nome + ", abreviacao=" + abreviacao + '}';
    }

}
