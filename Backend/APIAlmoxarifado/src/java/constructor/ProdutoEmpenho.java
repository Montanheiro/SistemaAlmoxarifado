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
    private double valorSequencia;
    private String itemProcesso;

    public ProdutoEmpenho(int id, Empenho empenho, NaturezaDespesa naturezaDespesa, Produto produto, int sequencia, double qtd, double valorSequencia, String itemProcesso) {
        this.id = id;
        this.empenho = empenho;
        this.naturezaDespesa = naturezaDespesa;
        this.produto = produto;
        this.sequencia = sequencia;
        this.qtd = qtd;
        this.valorSequencia = valorSequencia;
        this.itemProcesso = itemProcesso;
    }

    public ProdutoEmpenho(Empenho empenho, NaturezaDespesa naturezaDespesa, Produto produto, int sequencia, double qtd, double valorSequencia, String itemProcesso) {
        this.empenho = empenho;
        this.naturezaDespesa = naturezaDespesa;
        this.produto = produto;
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
        return "ProdutoEmpenho{" + "id=" + id + ", empenho=" + empenho + ", naturezaDespesa=" + naturezaDespesa + ", produto=" + produto + ", sequencia=" + sequencia + ", qtd=" + qtd + ", valorSequencia=" + valorSequencia + ", itemProcesso=" + itemProcesso + '}';
    }

}
