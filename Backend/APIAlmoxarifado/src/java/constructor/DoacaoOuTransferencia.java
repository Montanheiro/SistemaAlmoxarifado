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
public class DoacaoOuTransferencia {

    private int id;
    private String responsavel;
    private Tipo tipo;

    public DoacaoOuTransferencia(int id, String responsavel, Tipo tipo) {
        this.id = id;
        this.responsavel = responsavel;
        this.tipo = tipo;
    }

    public DoacaoOuTransferencia(String responsavel, Tipo tipo) {
        this.responsavel = responsavel;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "DoacaoOuTransferencia{" + "id=" + id + ", responsavel=" + responsavel + ", tipo=" + tipo + '}';
    }    
    
}
