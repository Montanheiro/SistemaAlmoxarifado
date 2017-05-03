package constructor;

/**
 *
 * @author Barbara
 */
public class ProdutoEmpenho {

    private int id;
    private Empenho empenho;
    private NaturezaDespesa naturezaDespesa;
    private Produto produto;

    private int sequencia;
    private double qtd;
    private double valorUnitario;
    private double valorSequencia;
    private String itemProcesso;
    private String itemMaterial;

    public ProdutoEmpenho(Empenho empenho, NaturezaDespesa naturezaDespesa, Produto produto, int sequencia, double qtd, double valorUnitario, double valorSequencia, String itemProcesso, String itemMaterial) {
        this.empenho = empenho;
        this.naturezaDespesa = naturezaDespesa;
        this.produto = produto;
        this.sequencia = sequencia;
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
        this.valorSequencia = valorSequencia;
        this.itemProcesso = itemProcesso;
        this.itemMaterial = itemMaterial;
    }

    public ProdutoEmpenho(int id, Empenho empenho, NaturezaDespesa naturezaDespesa, Produto produto, int sequencia, double qtd, double valorUnitario, double valorSequencia, String itemProcesso, String itemMaterial) {
        this.id = id;
        this.empenho = empenho;
        this.naturezaDespesa = naturezaDespesa;
        this.produto = produto;
        this.sequencia = sequencia;
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
        this.valorSequencia = valorSequencia;
        this.itemProcesso = itemProcesso;
        this.itemMaterial = itemMaterial;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
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

    public String getItemMaterial() {
        return itemMaterial;
    }

    public void setItemMaterial(String itemMaterial) {
        this.itemMaterial = itemMaterial;
    }

    @Override
    public String toString() {
        return "ProdutoEmpenho{" + "id=" + id + ", empenho=" + empenho + ", naturezaDespesa=" + naturezaDespesa + ", produto=" + produto + ", sequencia=" + sequencia + ", qtd=" + qtd + ", valorUnitario=" + valorUnitario + ", valorSequencia=" + valorSequencia + ", itemProcesso=" + itemProcesso + ", itemMaterial=" + itemMaterial + '}';
    }

}
