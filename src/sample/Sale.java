package sample;

/**
 * Created by mohammedissa on 5/23/16.
 */
public class Sale {

    int customerID,postorderID,salerID,saleID;
    String Date ;

    public Sale(int customerID, int postorderID, int salerID, String date) {
        this.customerID = customerID;
        this.postorderID = postorderID;
        this.salerID = salerID;
        Date = date;
    }

    public Sale(int customerID, int postorderID, int salerID, int saleID, String date) {
        this.customerID = customerID;
        this.postorderID = postorderID;
        this.salerID = salerID;
        this.saleID = saleID;
        Date = date;
    }

    public String getDate() {
        return Date;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getPostorderID() {
        return postorderID;
    }

    public int getSalerID() {
        return salerID;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setPostorderID(int postorderID) {
        this.postorderID = postorderID;
    }

    public void setSalerID(int salerID) {
        this.salerID = salerID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public void setDate(String date) {
        Date = date;
    }
}
