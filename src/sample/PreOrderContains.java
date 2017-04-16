package sample;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class PreOrderContains {

    int preorderId,productid,preorderContainsId,quantity;

    public PreOrderContains(int preorderId, int productid,int quantity) {
        this.preorderId = preorderId;
        this.productid = productid;
        this.quantity = quantity;
    }

    public PreOrderContains(int preorderId, int productid, int preorderContainsId,int quantity) {
        this.preorderId = preorderId;
        this.productid = productid;
        this.preorderContainsId = preorderContainsId;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPreorderId() {
        return preorderId;
    }

    public int getProductid() {
        return productid;
    }

    public int getPreorderContainsId() {
        return preorderContainsId;
    }

    public void setPreorderId(int preorderId) {
        this.preorderId = preorderId;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public void setPreorderContainsId(int preorderContainsId) {
        this.preorderContainsId = preorderContainsId;
    }
}
