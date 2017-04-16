package sample;

/**
 * Created by mohammedissa on 5/22/16.
 */
public class Supplier {

    private int id ;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Supplier(int id , String name , String email , String phone , String address){
        this.email = email;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Supplier( String name , String email , String phone , String address){
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
