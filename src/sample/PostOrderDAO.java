package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class PostOrderDAO {

    public void insertPostOrder(PostOrder e) {

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            stat.executeUpdate("INSERT INTO `Store`.`postorder` ( `postOrderPrice`) VALUES ('"
                    +e.getPrice() + "');");

        }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
    }

    public  PostOrder getLast(){

        PostOrder postOrder = null;
        double price = 0;
        int id = 0;
        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM postorder ORDER BY idpostOrder DESC LIMIT 1;");

            while (rez.next()) {

                id = rez.getInt("idpostOrder");
                price = rez.getDouble("postOrderPrice");
            }
            postOrder = new PostOrder(id,price);


        }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
        return  postOrder;


    }

    public ArrayList getAllPostOrders(){
        ArrayList<PreOrder> myLists = new ArrayList<>();
        int postOrderID=0;
        double price ;

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM `postOrder` ");
            while (rez.next()) {

                postOrderID = rez.getInt("idpostOrder");
                price = rez.getDouble("postOrderPrice");

                PreOrder postOrder = new PreOrder(postOrderID,price);
                myLists.add(postOrder);
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myLists;
    }



}
