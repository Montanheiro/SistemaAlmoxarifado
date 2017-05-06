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
    private boolean status;
    private Endereco endereco;
    private ArrayList<Contato> contato = new ArrayList<>();//Associacao

    public Fornecedor(String razaoSocial, String nomeFantasia, String cnpj, boolean status, Endereco endereco) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.status = status;
        this.endereco = endereco;
    }

    public Fornecedor(int id, String razaoSocial, String nomeFantasia, String cnpj, boolean status, Endereco endereco) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.status = status;
        this.endereco = endereco;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
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
        return "Fornecedor{" + "id=" + id + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj + ", status=" + status + ", endereco=" + endereco + ", contato=" + contato + '}';
    }

}
