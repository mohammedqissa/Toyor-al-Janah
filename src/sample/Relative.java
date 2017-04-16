package sample;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class Relative {

    int supplierId,preorderId;

    public Relative(int supplierId, int preorderId) {
        this.supplierId = supplierId;
        this.preorderId = preorderId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public int getPreorderId() {
        return preorderId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public void setPreorderId(int preorderId) {
        this.preorderId = preorderId;
    }
}
