package constructor;

/**
 *
 * @author Barbara
 */
public class NaturezaDespesa {

    private int id;
    private String codigo;
    private String subItem;
    private String descricao;

    public NaturezaDespesa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSubItem() {
        return subItem;
    }

    public void setSubItem(String subItem) {
        this.subItem = subItem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "NaturezaDespesa{" + "id=" + id + ", codigo=" + codigo + ", subItem=" + subItem + ", descricao=" + descricao + '}';
    }

}
