package constructor;

public class ItemEmpenho {

    private int id;
    private int empenhoId;
    private NaturezaDespesa naturezaDespesa;
    private Produto produto;
    private int sequencia;
    private double qtd;
    private double valorUnitario;
    private String itemProcesso;
    
    public ItemEmpenho(int id, int empenho, NaturezaDespesa naturezaDespesa, Produto produto, int sequencia, double qtd, double valorUnitario, String itemProcesso) {
        this.id = id;
        this.empenhoId = empenho;
        this.naturezaDespesa = naturezaDespesa;
        this.produto = produto;
        this.sequencia = sequencia;
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
        this.itemProcesso = itemProcesso;
    }

//    public ItemEmpenho(int empenho, NaturezaDespesa naturezaDespesa, Produto produto, int sequencia, double qtd, double valorUnitario, String itemProcesso) {
//        this.empenhoId = empenho;
//        this.naturezaDespesa = naturezaDespesa;
//        this.produto = produto;
//        this.sequencia = sequencia;
//        this.qtd = qtd;
//        this.valorUnitario = valorUnitario;
//        this.itemProcesso = itemProcesso;
//    }
    
    public ItemEmpenho(NaturezaDespesa naturezaDespesa, Produto produto, int sequencia, double qtd, double valorUnitario, String itemProcesso) {
        this.naturezaDespesa = naturezaDespesa;
        this.produto = produto;
        this.sequencia = sequencia;
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
        this.itemProcesso = itemProcesso;
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

    public String getItemProcesso() {
        return itemProcesso;
    }

    public void setItemProcesso(String itemProcesso) {
        this.itemProcesso = itemProcesso;
    }

    @Override
    public String toString() {
        return "ItemEmpenho{" + "id=" + id + ", empenho=" + empenhoId + ", naturezaDespesa=" 
                + naturezaDespesa + ", produto=" + produto + ", sequencia=" + sequencia 
                + ", qtd=" + qtd + ", valorUnitario=" + valorUnitario 
                + ", itemProcesso=" + itemProcesso + '}';
    }

}
