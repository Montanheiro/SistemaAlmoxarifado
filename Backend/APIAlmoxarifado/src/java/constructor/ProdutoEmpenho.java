package constructor;

/**
 *
 * @author Barbara
 */
public class ProdutoEmpenho {

    private int id;
    private int empenhoId;
    private int naturezaDespesaId;
    private int produtoId;

    private int sequencia;
    private double qtd;
    private double valorUnitario;
    private double valorSequencia;
    private String itemProcesso;
    private String itemMaterial;

    public ProdutoEmpenho(int sequencia, double qtd, double valorUnitario, double valorSequencia, String itemProcesso, String itemMaterial) {
        this.sequencia = sequencia;
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
        this.valorSequencia = valorSequencia;
        this.itemProcesso = itemProcesso;
        this.itemMaterial = itemMaterial;
    }

    public ProdutoEmpenho(int id, int empenhoId, int naturezaDespesaId, int produtoId, int sequencia, double qtd, double valorUnitario, double valorSequencia, String itemProcesso, String itemMaterial) {
        this.id = id;
        this.empenhoId = empenhoId;
        this.naturezaDespesaId = naturezaDespesaId;
        this.produtoId = produtoId;
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

    public int getEmpenhoId() {
        return empenhoId;
    }

    public void setEmpenhoId(int empenhoId) {
        this.empenhoId = empenhoId;
    }

    public int getNaturezaDespesaId() {
        return naturezaDespesaId;
    }

    public void setNaturezaDespesaId(int naturezaDespesaId) {
        this.naturezaDespesaId = naturezaDespesaId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
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
        return "ProdutoEmpenho{" + "id=" + id + ", empenhoId=" + empenhoId + ", naturezaDespesaId=" + naturezaDespesaId + ", produtoId=" + produtoId + ", sequencia=" + sequencia + ", qtd=" + qtd + ", valorUnitario=" + valorUnitario + ", valorSequencia=" + valorSequencia + ", itemProcesso=" + itemProcesso + ", itemMaterial=" + itemMaterial + '}';
    }

}
