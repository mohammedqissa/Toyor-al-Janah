package sample;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class PostOrderContains {

    int preorderId,productid,preorderContainsId;

    public PostOrderContains(int preorderId, int productid) {
        this.preorderId = preorderId;
        this.productid = productid;
    }

    public PostOrderContains(int preorderId, int productid, int preorderContainsId) {
        this.preorderId = preorderId;
        this.productid = productid;
        this.preorderContainsId = preorderContainsId;
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
