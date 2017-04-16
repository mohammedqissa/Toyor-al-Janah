package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class BuyDAO {

    String insert  = "INSERT INTO `Store`.`managerBuy` ( `managerId`, `preorderID`, `managerBuyDate` )";


    public void insertBuy(Buy e) {

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            stat.executeUpdate(insert+" VALUES ('"
                    +e.getManagerId() +"', '"
                    +e.preorderId + "', '"
                    +e.getDate() + "');");

        }
        catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
    }



    public ArrayList getAllBuys(){
        ArrayList<Buy> myLists = new ArrayList<>();
        int buyId,managerId,supplierId,preOrderId;
        String date = "";
        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM `supplier` ");
            while (rez.next()) {

                buyId = rez.getInt("idmaagerBuy");
                managerId = rez.getInt("supplierId");
                preOrderId = rez.getInt("perorderID");
                date = rez.getString("managerBuyDate");

                Buy buy = new Buy(buyId,managerId,preOrderId,date);
                myLists.add(buy);
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myLists;
    }

}
