package sample;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class Product {

    private int idproduct;
    private Double productPrice;
    private String productColor;
    private String productDiscription;
    private String productCatagory;
    private String productSize;
    private String productImage;
    private String productKind;

    public Product(int idproduct,Double productPrice,String productColor,String productDiscription,String productCatagory,
                   String productSize, String productImage , String productKind){
        this.idproduct = idproduct;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.productDiscription = productDiscription;
        this.productCatagory = productCatagory;
        this.productSize = productSize;
        this.productImage = productImage;
        this.productKind = productKind;
    }

    public Product(Double productPrice,String productColor,String productDiscription,String productCatagory,
                   String productSize, String productImage , String productKind){
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.productDiscription = productDiscription;
        this.productCatagory = productCatagory;
        this.productSize = productSize;
        this.productImage = productImage;
        this.productKind = productKind;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public String getProductDiscription() {
        return productDiscription;
    }

    public String getProductSize() {
        return productSize;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductKind() {
        return productKind;
    }

    public String getProductColor() {
        return productColor;
    }

    public String getProductCatagory() {
        return productCatagory;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public void setProductDiscription(String productDiscription) {
        this.productDiscription = productDiscription;
    }

    public void setProductCatagory(String productCatagory) {
        this.productCatagory = productCatagory;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setProductKind(String productKind) {
        this.productKind = productKind;
    }

}
