package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mohammedissa on 5/21/16.
 */
public class SalerDAO {

    public void insertSaler(Saler e) {

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            stat.executeUpdate("INSERT INTO `Store`.`saler` (`salerPass`, `salerName`, `SalerPhone`, `SBDate`) VALUES ('"
                    + e.getSpass() + "', '"
                    + e.getSname() + "', '"
                    + e.getSphone() + "', '"
                    + e.getBdate() + "');");

        } catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
    }

    public Saler getsaler(int id) {


        String name = null;
        String phone = null;
        int sid = 0;
        String date = null;
        String pass = null;

        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat
                    .executeQuery("SELECT * FROM `saler` WHERE  salerId = '" + id
                            + "'");
            while (rez.next()) {
                sid = rez.getInt("salerID");
                name = rez.getString("salerName");
                phone = rez.getString("salerPhone");
                date = rez.getString("SBDate");
                pass = rez.getString("salerPass");

            }
            rez.close();
            stat.close();

        } catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }

        Saler m = new Saler(sid, name, date, phone, pass);
        return m;


    }

    public Saler getLast() {

        Saler saler = null;

        int id = 0;
        String name = "", phone = "", sbdate = "", salerpass = "";
        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT * FROM saler ORDER BY salerID DESC LIMIT 1;");

            while (rez.next()) {

                id = rez.getInt("salerID");

                name = rez.getString("salerName");
                phone = rez.getString("SalerPhone");
                sbdate = rez.getString("SBDate");
                salerpass = rez.getString("salerPass");
            }
            saler = new Saler(id, name, sbdate, phone, salerpass);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return saler;
    }

    public Saler getbest() {


        int id = 0;
        try {
            Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("SELECT       `idOfSaler` FROM     salerSale GROUP BY `idOfSaler` ORDER BY COUNT(*) DESC LIMIT    1;");

            while (rez.next()) {

                id = rez.getInt("idOfSaler");


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        Saler saler = getsaler(id);

        return saler;
    }

    /*    SELECT       `idOfSaler`
    FROM     salerSale
    GROUP BY `idOfSaler`
    ORDER BY COUNT(*) DESC
    LIMIT    1;*/

}
