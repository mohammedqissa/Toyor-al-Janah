package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class SupplierDAO {


    public void insertSupplier(Supplier e) {

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            stat.executeUpdate("INSERT INTO `Store`.`supplier` ( `suppliername`, `supplierPhone`, `supplierEmal`, `supplierAddress`) VALUES ('"
                    +e.getName() +"', '"
                    +e.getPhone() + "', '"
                    +e.getEmail() + "', '"
                    +e.getAddress() + "');");

        }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList getAllSuppliers(){
        ArrayList<Supplier> myLists = new ArrayList<>();
        int supplierID=0;
        String name ="";
        String email="";
        String address="";
        String phone="";
        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM `supplier` ");
            while (rez.next()) {

                supplierID = rez.getInt("idsupplier");
                name = rez.getString("suppliername");
                email = rez.getString("supplierEmal");
                phone = rez.getString("supplierPhone");
                address = rez.getString("supplierAddress");

                Supplier supplier = new Supplier(supplierID,name,email,phone,address);
                myLists.add(supplier);
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myLists;
    }




    public int getIdSupplierBykNames(String name) {
        int id = 0;
        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT `idsupplier` FROM `supplier` WHERE suppliername = '" + name + "'"
            );
            while (rez.next()) {
                id = rez.getInt("idsupplier");
            }
            rez.close();
            stat.close();

        } catch (SQLException ex) {
            System.out.println("The Sql has error");
        }

        return id;
    }

    public Supplier getLast() {

        Supplier supplier = null;

        int id = 0;
        String name = "", phone = "", semail = "", supplieraddress = "";
        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM supplier ORDER BY idsupplier DESC LIMIT 1;");

            while (rez.next()) {

                id = rez.getInt("idsupplier");

                name = rez.getString("suppliername");
                phone = rez.getString("supplierphone");
                semail = rez.getString("supplierEmal");
                supplieraddress = rez.getString("supplierAddress");
            }
            supplier = new Supplier(id,name,semail,phone,supplieraddress);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supplier;
    }

}
