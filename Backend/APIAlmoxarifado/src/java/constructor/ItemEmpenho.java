package constructor;

public class ItemEmpenho {

    private int id;
    private Empenho empenho;
    private NaturezaDespesa naturezaDespesa;

    private int sequencia;
    private double qtd;
    private double valorSequencia;
    private String itemProcesso;

    public ItemEmpenho(int id, Empenho empenho, NaturezaDespesa naturezaDespesa,
            int sequencia, double qtd, double valorSequencia, String itemProcesso) {
        this.id = id;
        this.empenho = empenho;
        this.naturezaDespesa = naturezaDespesa;
        this.sequencia = sequencia;
        this.qtd = qtd;
        this.valorSequencia = valorSequencia;
        this.itemProcesso = itemProcesso;
    }

    public ItemEmpenho(Empenho empenho, NaturezaDespesa naturezaDespesa,
            int sequencia, double qtd, double valorSequencia, String itemProcesso) {
        this.empenho = empenho;
        this.naturezaDespesa = naturezaDespesa;
        this.sequencia = sequencia;
        this.qtd = qtd;
        this.valorSequencia = valorSequencia;
        this.itemProcesso = itemProcesso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empenho getEmpenho() {
        return empenho;
    }

    public void setEmpenho(Empenho empenho) {
        this.empenho = empenho;
    }

    public NaturezaDespesa getNaturezaDespesa() {
        return naturezaDespesa;
    }

    public void setNaturezaDespesa(NaturezaDespesa naturezaDespesa) {
        this.naturezaDespesa = naturezaDespesa;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public double getValorSequencia() {
        return valorSequencia;
    }

    public void setValorSequencia(double valorSequencia) {
        this.valorSequencia = valorSequencia;
    }

    public String getItemProcesso() {
        return itemProcesso;
    }

    public void setItemProcesso(String itemProcesso) {
        this.itemProcesso = itemProcesso;
    }

    @Override
    public String toString() {
        return "ItemEmpenho{" + "id=" + id + ", empenho=" + empenho + ", naturezaDespesa=" 
                + naturezaDespesa + ", sequencia=" + sequencia + ", qtd=" + qtd 
                + ", valorSequencia=" + valorSequencia + ", itemProcesso=" + itemProcesso + '}';
    }

}
