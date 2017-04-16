package sample;


/**
 * Created by mohammedissa on 5/21/16.
 */
public class Saler {


    private int Sid;
    private String Sname;
    private String Bdate;
    private String Sphone;
    private String Spass;

    public Saler(int Sid, String Sname , String Bdate , String Sphone,String pass){
     this.Bdate = Bdate;
        this.Sid = Sid;
        this.Sname = Sname;
        this.Sphone = Sphone;
        this.Spass = pass;
    }

    public Saler(String Sname , String Bdate , String Sphone,String pass){
        this.Bdate = Bdate;
        this.Sname = Sname;
        this.Sphone = Sphone;
        this.Spass = pass;
    }

    public int getSid() {
        return Sid;
    }

    public String getSname() {
        return Sname;
    }

    public String getBdate() {
        return Bdate;
    }

    public String getSphone() {
        return Sphone;
    }

    public String getSpass() {
        return Spass;
    }

    public void setSid(int sid) {
        Sid = sid;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public void setSphone(String sphone) {
        Sphone = sphone;
    }

    public void setBdate(String bdate) {
        Bdate = bdate;
    }

    public void setSpass(String spass) {
        Spass = spass;
    }
}
