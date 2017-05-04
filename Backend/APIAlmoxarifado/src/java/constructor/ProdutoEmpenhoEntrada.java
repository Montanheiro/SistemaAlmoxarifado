/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructor;

/**
 *
 * @author lucas
 */
public class ProdutoEmpenhoEntrada {
    
    private int id;
    private int produtoEmpenhoId;
    private int entradasId;

    public ProdutoEmpenhoEntrada(int id, int produtoEmpenhoId, int entradasId) {
        this.id = id;
        this.produtoEmpenhoId = produtoEmpenhoId;
        this.entradasId = entradasId;
    }

    public ProdutoEmpenhoEntrada(int produtoEmpenhoId, int entradasId) {
        this.produtoEmpenhoId = produtoEmpenhoId;
        this.entradasId = entradasId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoEmpenhoId() {
        return produtoEmpenhoId;
    }

    public void setProdutoEmpenhoId(int produtoEmpenhoId) {
        this.produtoEmpenhoId = produtoEmpenhoId;
    }

    public int getEntradasId() {
        return entradasId;
    }

    public void setEntradasId(int entradasId) {
        this.entradasId = entradasId;
    }

    @Override
    public String toString() {
        return "ProdutoEmpenhoEntrada{" + "id=" + id + ", produtoEmpenhoId=" + produtoEmpenhoId + ", entradasId=" + entradasId + '}';
    }
    
}
