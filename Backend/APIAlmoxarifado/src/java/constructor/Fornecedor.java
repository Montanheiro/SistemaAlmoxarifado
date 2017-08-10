package constructor;

/**
 *
 * @author Barbara
 */
import java.util.ArrayList;

public class Fornecedor {

    private int id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private ArrayList<Endereco> endereco = new ArrayList<>();//Associacao
    private ArrayList<Contato> contato = new ArrayList<>();//Associacao

    public Fornecedor(String razaoSocial, String nomeFantasia, String cnpj, ArrayList<Endereco> endereco, ArrayList<Contato> contato) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Fornecedor(int id, String razaoSocial, String nomeFantasia, String cnpj, ArrayList<Endereco> endereco, ArrayList<Contato> contato) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Fornecedor(String razaoSocial, String nomeFantasia, String cnpj) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(ArrayList<Endereco> endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Contato> getContato() {
        return contato;
    }

    public void setContato(ArrayList<Contato> contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj + ", endereco=" + endereco + ", contato=" + contato + '}';
    }

}
