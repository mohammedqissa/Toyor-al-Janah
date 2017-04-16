package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class PreOrderContainsDAO {


    public void insertPreOrderContains(PreOrderContains e) {

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            stat.executeUpdate("INSERT INTO `Store`.`preorderConsistOfProduct` (`idofproduct`, `idofpreorder`, `quantity`) VALUES ('"
                    +e.getProductid() + "', '"
                    +e.getPreorderId() + "', '"
                    +e.getQuantity() + "');");

        }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
    }

    public int getQuantity(int id) {

        int q= 0;
        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("select quantity from `preorderConsistOfProduct`,`product` where idproduct = idofproduct and idproduct = '"+id+"'");

            while (rez.next()) {
                q = rez.getInt("quantity");

            }

            }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
        return q;
    }



}
