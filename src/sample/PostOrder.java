package sample;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class PostOrder {


    private int id ;
    private  double price = 0;

    public PostOrder() {

    }
    public PostOrder(double price) {
        this.price = price;
    }

    public PostOrder(int id ,double price) {
        this.id  = id;
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
