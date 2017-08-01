package constructor;

/**
 *
 * @author lucas
 */
public class ItemEmpenhoEntrada {
    
    private int id;
    private int itemEmpenhoId;
    private int entradasId;

    public ItemEmpenhoEntrada(int id, int itemEmpenhoId, int entradasId) {
        this.id = id;
        this.itemEmpenhoId = itemEmpenhoId;
        this.entradasId = entradasId;
    }

    public ItemEmpenhoEntrada(int itemEmpenhoId, int entradasId) {
        this.itemEmpenhoId = itemEmpenhoId;
        this.entradasId = entradasId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemEmpenhoId() {
        return itemEmpenhoId;
    }

    public void setItemEmpenhoId(int itemEmpenhoId) {
        this.itemEmpenhoId = itemEmpenhoId;
    }

    public int getEntradasId() {
        return entradasId;
    }

    public void setEntradasId(int entradasId) {
        this.entradasId = entradasId;
    }

    @Override
    public String toString() {
        return "ItemEmpenhoEntrada{" + "id=" + id + ", itemEmpenhoId=" + itemEmpenhoId + ", entradasId=" + entradasId + '}';
    }
    
}
