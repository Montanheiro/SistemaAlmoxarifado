package constructor;

/**
 *
 * @author lucas
 */
public class EntradaItemEmpenho {
    
    private int id;
    private ItemEmpenho itemEmpenho;
    private Entrada entrada;

    public EntradaItemEmpenho(int id, ItemEmpenho itemEmpenho, Entrada entrada) {
        this.id = id;
        this.itemEmpenho = itemEmpenho;
        this.entrada = entrada;
    }

    public EntradaItemEmpenho(ItemEmpenho itemEmpenho, Entrada entrada) {
        this.itemEmpenho = itemEmpenho;
        this.entrada = entrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemEmpenho getItemEmpenho() {
        return itemEmpenho;
    }

    public void setItemEmpenho(ItemEmpenho itemEmpenho) {
        this.itemEmpenho = itemEmpenho;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    @Override
    public String toString() {
        return "EntradaItemEmpenho{" + "id=" + id + ", itemEmpenho=" + itemEmpenho + ", entrada=" + entrada + '}';
    }
    
}
