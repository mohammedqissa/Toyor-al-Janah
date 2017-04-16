package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class ProductDAO {



    public ArrayList getAllboughtProducts(){


        ArrayList<Product> myLists = new ArrayList<>();

        int producId;
        double price ;
        String size = null;
        String color = null;
        String discription = null;
        String catagory = null;
        String pic = null;
        String kind = null;

        try {
            java.sql.Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("select * from product, `managerBuy` , `preorder` , `preorderConsistOfProduct`\n" +
                    "WHERE product.idproduct = preorderConsistOfProduct.idofproduct AND preorderConsistOfProduct.idofpreorder = preorder.idpreorder AND preorder.idpreorder = managerBuy.preorderID");
            while (rez.next()) {
                producId = rez.getInt("idproduct");
                price = rez.getDouble("productPrice");
                color = rez.getString("productColor");
                discription = rez.getString("productDiscription");
                catagory = rez.getString("productCatagory");
                size = rez.getString("productSizes");
                pic = rez.getString("productPic");
                kind = rez.getString("kind");

                Product product = new Product(producId, price, color, discription, catagory, size, pic, kind);
                myLists.add(product);
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return myLists;
    }

    public ArrayList getAllProducts() {

        ArrayList<Product> myLists = new ArrayList<>();

        int producId;
        double price ;
        String size = null;
        String color = null;
        String discription = null;
        String catagory = null;
        String pic = null;
        String kind = null;

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM `product` ");
            while (rez.next()) {

                producId = rez.getInt("idproduct");
                price = rez.getDouble("productPrice");
                color = rez.getString("productColor");
                discription = rez.getString("productDiscription");
                catagory = rez.getString("productCatagory");
                size = rez.getString("productSize");
                pic = rez.getString("productPic");
                kind = rez.getString("kind");

                Product product = new Product(producId, price, color, discription, catagory, size, pic, kind);
                myLists.add(product);
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myLists;
    }

    public void insertProduct(Product e) {

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            stat.executeUpdate("INSERT INTO `Store`.`product` ( `productPrice`, `productColor`, `productDiscription`, `productCatagory`, `productSizes`, `productPic`, `kind`) VALUES ('"
                    +e.getProductPrice() +"', '"
                    +e.getProductColor() + "', '"
                    +e.getProductDiscription() + "', '"
                    +e.getProductCatagory() + "', '"
                    +e.getProductSize() + "', '"
                    +e.getProductImage() + "', '"
                    +e.getProductKind() + "');");

        }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
    }


    public Product getLastrow(){

        Product product = null;
        int producId;
        double price ;
        String size = null;
        String color = null;
        String discription = null;
        String catagory = null;
        String pic = null;
        String kind = null;

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM product ORDER BY idproduct DESC LIMIT 1;");

            while (rez.next()) {

                producId = rez.getInt("idproduct");
                price = rez.getDouble("productPrice");
                color = rez.getString("productColor");
                discription = rez.getString("productDiscription");
                catagory = rez.getString("productCatagory");
                size = rez.getString("productSizes");
                pic = rez.getString("productPic");
                kind = rez.getString("kind");

                product = new Product(producId, price, color, discription, catagory, size, pic, kind);
            }


        }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }

        return product;

    }

    public Product getProduct(String id) {

        Product product = null;
        int producId = 0;
        double price =0;
        String size = null;
        String color = null;
        String discription = null;
        String catagory = null;
        String pic = null;
        String kind = null;

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat
                    .executeQuery("SELECT * FROM `product` WHERE  idproduct = '" + id
                            + "'");
            while (rez.next()) {
                producId = rez.getInt("idproduct");
                price = rez.getDouble("productPrice");
                color = rez.getString("productColor");
                discription = rez.getString("productDiscription");
                catagory = rez.getString("productCatagory");
                size = rez.getString("productSizes");
                pic = rez.getString("productPic");
                kind = rez.getString("kind");

            }
            rez.close();
            stat.close();

        } catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }

        product = new Product(producId, price, color, discription, catagory, size, pic, kind);
        return product;


    }

}
