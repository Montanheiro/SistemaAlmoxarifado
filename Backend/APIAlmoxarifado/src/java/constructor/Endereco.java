
package constructor;

public class Endereco {

    private int id;
    private String cidade;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String logradouro;
    
    private int fornecedorId;

    public Endereco(int id, String cidade, String bairro, String cep, String numero, String complemento, String logradouro, int fornecedorId) {
        this.id = id;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.logradouro = logradouro;
        this.fornecedorId = fornecedorId;
    }

    public Endereco(String cidade, String bairro, String cep, String numero, String complemento, String logradouro) {
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

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }
    
    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", cidade=" + cidade + ", bairro=" + bairro + ", cep=" + cep + ", numero=" + numero + ", complemento=" + complemento + ", logradouro=" + logradouro + '}';
    }
    
}
