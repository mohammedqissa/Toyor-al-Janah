package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mohammedissa on 5/23/16.
 */
public class CustomerDAO {

    public void insertCustomer() {

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            stat.executeUpdate("INSERT INTO `Store`.`customer` (`customercol`) VALUES (' ')");

        }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
    }
    public  Customer getLast(){

        Customer customer = null;
        double price = 0;
        int id = 0;
        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM customer ORDER BY idcustomer DESC LIMIT 1;");

            while (rez.next()) {

                id = rez.getInt("idcustomer");
            }
            customer = new Customer(id);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public ArrayList getAllCustomers(){

        ArrayList<Customer> myLists = new ArrayList<>();

        int customer=0;

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM `customer` ");

            while (rez.next()) {

                customer = rez.getInt("idcustomer");
                Customer customer1 = new Customer(customer);

                myLists.add(customer1);
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myLists;
    }

}
