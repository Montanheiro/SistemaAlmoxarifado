package constructor;
/**
 *
 * @author Barbara
 */

public class Produto {

    private int id;
    private String descricao;
    private Unidade unidade;

    public Produto(String descricao, Unidade unidade) {
        this.descricao = descricao;
        this.unidade = unidade;
    }

    public Produto(int id, String descricao, Unidade unidade) {
        this.id = id;
        this.descricao = descricao;
        this.unidade = unidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", unidade=" + unidade + ", descricao=" + descricao + '}';
    }

}
