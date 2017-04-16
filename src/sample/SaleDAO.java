package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mohammedissa on 5/23/16.
 */
public class SaleDAO {


    public void insertSale(Sale e) {

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            stat.executeUpdate("INSERT INTO `Store`.`salerSale` (`idOfCustomer`, `idOfPostorder`, `idOfSaler`, `salerSaledate`) VALUES ('"
                    + e.getCustomerID() + "', '"
                    + e.getPostorderID() + "', '"
                    + e.getSalerID() + "', '"
                    + e.getDate() + "');");

        } catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList getAllsales(){
        ArrayList<Sale> myLists = new ArrayList<>();

        int customerID=0,postorderID=0,salerID=0,saleID=0;
        String date = "";

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM Store.salerSale ");

            while (rez.next()) {

                customerID = rez.getInt("idOfCustomer");
                saleID = rez.getInt("idsalerSale");
                postorderID = rez.getInt("idOfPostorder");
                salerID = rez.getInt("idOfSaler");
                date = rez.getString("salerSaledate");

                Sale sale = new Sale(customerID,postorderID,salerID,saleID,date);
                myLists.add(sale);
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myLists;
    }

    public ArrayList getAllsalesby(int id){
        ArrayList<Sale> myLists = new ArrayList<>();

        int customerID=0,postorderID=0,salerID=0,saleID=0;
        String date = "";

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM Store.salerSale where idOfSaler = '"+id+"'");

            while (rez.next()) {

                customerID = rez.getInt("idOfCustomer");
                saleID = rez.getInt("idsalerSale");
                postorderID = rez.getInt("idOfPostorder");
                salerID = rez.getInt("idOfSaler");
                date = rez.getString("salerSaledate");

                Sale sale = new Sale(customerID,postorderID,salerID,saleID,date);
                myLists.add(sale);
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myLists;
    }



}
