
package constructor;
/**
 *
 * @author Barbara
 */

public class Endereco {

    private int id;
    private Fornecedor fornecedor;
    private String cidade;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String logradouro;

    public Endereco(Fornecedor fornecedor, String cidade, String bairro, String cep, String numero, String complemento, String logradouro) {
        this.fornecedor = fornecedor;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.logradouro = logradouro;
    }

    public Endereco(int id, Fornecedor fornecedor, String cidade, String bairro, String cep, String numero, String complemento, String logradouro) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.logradouro = logradouro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", fornecedor=" + fornecedor + ", cidade=" + cidade + ", bairro=" + bairro + ", cep=" + cep + ", numero=" + numero + ", complemento=" + complemento + ", logradouro=" + logradouro + '}';
    }
    
}
