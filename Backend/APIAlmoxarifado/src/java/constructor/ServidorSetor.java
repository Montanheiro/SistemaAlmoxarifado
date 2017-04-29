package constructor;

/**
 *
 * @author Barbara
 */
public class ServidorSetor {

    private int id;
    private int ServidorId;
    private int SetorId;

    public ServidorSetor() {
    }

    public ServidorSetor(int ServidorId, int SetorId) {
        this.ServidorId = ServidorId;
        this.SetorId = SetorId;
    }

    public ServidorSetor(int id, int ServidorId, int SetorId) {
        this.id = id;
        this.ServidorId = ServidorId;
        this.SetorId = SetorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServidorId() {
        return ServidorId;
    }

    public void setServidorId(int ServidorId) {
        this.ServidorId = ServidorId;
    }

    public int getSetorId() {
        return SetorId;
    }

    public void setSetorId(int SetorId) {
        this.SetorId = SetorId;
    }

    @Override
    public String toString() {
        return "ServidorSetor{" + "id=" + id + ", ServidorId=" + ServidorId + ", SetorId=" + SetorId + '}';
    }

}
