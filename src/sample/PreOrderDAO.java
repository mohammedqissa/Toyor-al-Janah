package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class PreOrderDAO {

    public void insertPreOrder(PreOrder e) {

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            stat.executeUpdate("INSERT INTO `Store`.`preorder` (`preorderprice`) VALUES ('"
                    +e.getPrice() + "');");

        }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
    }


    public ArrayList getAllPreOrders(){
        ArrayList<PreOrder> myLists = new ArrayList<>();
        int preOrderID=0;
        double price ;

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM `preorder` ");
            while (rez.next()) {

                preOrderID = rez.getInt("idpreorder");
                price = rez.getDouble("preorderprice");

                PreOrder preOrder = new PreOrder(preOrderID,price);
                myLists.add(preOrder);
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myLists;
    }


    public PreOrder getLastrow(){

        PreOrder preOrder = null;
        int preorderid;
        Double price;


        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM preorder ORDER BY idpreorder DESC LIMIT 1;");

            while (rez.next()) {

                preorderid = rez.getInt("idpreorder");
                price = rez.getDouble("preorderprice");

                preOrder = new PreOrder(preorderid,price);
            }


        }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }

        return preOrder;

    }


}
