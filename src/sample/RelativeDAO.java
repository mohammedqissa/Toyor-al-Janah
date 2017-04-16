package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class RelativeDAO {



    public void insertRelative(Relative e) {

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            stat.executeUpdate("INSERT INTO `Store`.`relative` (`supplierId`, `preorderId` ) VALUES ('"
                    +e.getSupplierId() + "', '"
                    +e.getPreorderId() + "');");

        }

        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
    }


    public ArrayList getAllRelative(){
        ArrayList<Relative> myLists = new ArrayList<>();
        int supplierId,preOrderId;
        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM `supplier` ");
            while (rez.next()) {

                preOrderId = rez.getInt("perorderId");
                supplierId = rez.getInt("supplierId");

                Relative relative = new Relative(supplierId,preOrderId);
                myLists.add(relative);
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myLists;
    }

}
