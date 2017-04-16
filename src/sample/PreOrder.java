package sample;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class PreOrder {

    private int id;
    private  double price;

    public PreOrder(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public PreOrder( double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
