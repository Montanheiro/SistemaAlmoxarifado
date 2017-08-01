package constructor;
/**
 *
 * @author Barbara
 */

public class Setor {

    private int id;
    private String nome;
    private String sigla;

    public Setor(int id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Setor(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Setor{" + "id=" + id + ", nome=" + nome + ", sigla=" + sigla + '}';
    }
    
 }
