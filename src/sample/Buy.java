package sample;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class Buy {

    int buyID,managerId,preorderId;
    String date;

    public Buy(int buyID, int managerId,  int preorderId, String date) {
        this.buyID = buyID;
        this.managerId = managerId;
        this.preorderId = preorderId;
        this.date = date;
    }

    public Buy( int managerId,  int preorderId, String date) {
        this.managerId = managerId;
        this.preorderId = preorderId;
        this.date = date;
    }

    public int getBuyID() {
        return buyID;
    }

    public int getManagerId() {
        return managerId;
    }


    public int getPreorderId() {
        return preorderId;
    }

    public String getDate() {
        return date;
    }

    public void setBuyID(int buyID) {
        this.buyID = buyID;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }


    public void setPreorderId(int preorderId) {
        this.preorderId = preorderId;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
