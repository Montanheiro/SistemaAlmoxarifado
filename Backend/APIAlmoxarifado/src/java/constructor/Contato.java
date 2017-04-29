package constructor;

public class Contato {

    private int id;
    private String nome;
    private String telefone;
    
    private int fornecedorId;

    public Contato(int id, String nome, String telefone, int fornecedorId) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.fornecedorId = fornecedorId;
    }

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }
    
    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", nome=" + nome + ", telefone=" + telefone + '}';
    }

}
