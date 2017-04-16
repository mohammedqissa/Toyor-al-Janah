package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class PostOrderContainsDAO {


    public void insertPostOrderContains(PostOrderContains e) {

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            stat.executeUpdate("INSERT INTO `Store`.`postorderConsistofProduct` (`idOfProduct`, `idOfpostorder`) VALUES ('"
                    +e.getProductid() + "', '"
                    +e.getPreorderId() + "');");

        }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
    }

    public void deletePostOrderContains(int id) {

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            stat.executeUpdate("DELETE FROM `Store`.`postorderConsistofProduct` WHERE `idOfProduct`='"+id+"'");

        }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
    }



}
