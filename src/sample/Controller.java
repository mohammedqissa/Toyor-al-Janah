package sample;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.print.DocFlavor;

public class Controller {

    String nn = "";
    Manager m = null;
    Saler s = null;


    public static Product productShop ;
    public static PostOrder postOrder ;
    public static boolean istrue = false;


    public static boolean isSaler = false;

    String imagePath = "";

    public static Manager manager;
    public static Saler saler;

    int currentID ;



    @FXML
    private TextField quantity;
    @FXML
    private Label hisID;
    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> catagoryCombo;
    @FXML
    private ListView<String> prodList;
    @FXML
    private ListView<String> productList;
    @FXML
    private ComboBox<String> sizeCombo;
    @FXML
    private ComboBox<String> kindCombo;
    @FXML
    private ImageView productImage;
    @FXML
    private Label prodDisc;
    @FXML
    private Button addPr;
    @FXML
    private TextField prodID;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField PID;
    @FXML
    private TextField PPrice;
    @FXML
    private TextField PColor;
    @FXML
    private TextField PCatagory;
    @FXML
    private TextField PSize;
    @FXML
    private TextField PDiscription;

    @FXML
    private ComboBox<String> PKind;
    @FXML
    private ComboBox<String> Porder;
    @FXML
    private ComboBox<String> OPreOrder;
    @FXML
    private ComboBox<String> suppliersCombo;

    @FXML
    private ImageView imageView = new ImageView();

    @FXML
    private TableView<Product> productTableView = new TableView<>();

    @FXML
    private Label label;

    public TextField textField = new TextField();

    @FXML
    private Label invalid_label;

    @FXML
    private TextField username_box;

    @FXML
    private PasswordField password_box;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (isValidCredentials().equals("manager"))
        {


            Parent home_page_parent = FXMLLoader.load(getClass().getResource("manager.fxml"));
            Scene home_page_scene = new Scene(home_page_parent,800,500);
            home_page_scene.getStylesheets().addAll(this.getClass().getResource("dark.css").toExternalForm());
            app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();

        }

        else if (isValidCredentials().equals("saler")){


            Parent home_page_parent = FXMLLoader.load(getClass().getResource("saler.fxml"));

            Scene home_page_scene = new Scene(home_page_parent,800,500);
            app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();



        }
        else
        {
            username_box.clear();
            password_box.clear();
            invalid_label.setText("Sorry, invalid credentials");
        }
    }

    private String isValidCredentials()
    {
        String aa = "";
        System.out.println( "SELECT * FROM Users WHERE USERNAME= " + "'" + username_box.getText() + "'"
                + " AND PASSWORD= " + "'" + password_box.getText() + "'" );

        String id = username_box.getText();
        String pass = password_box.getText();

        Connection c = null;
        java.sql.Statement stmt = null;
        try {

            ManagerDAO managerDAO = new ManagerDAO();
            SalerDAO salerDAO = new SalerDAO();
            java.sql.Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat
                    .executeQuery("SELECT * FROM `saler`,`manager` WHERE salerID = idmanager AND salerID = '" + id +"' AND salerPass = '"+pass
                            + "'");


            while (rez.next()) {

                aa = "manager";
                manager = managerDAO.getmanager(Integer.parseInt(id));
            }


            if(aa.equals("")){
                isSaler = true;
                rez = stat
                        .executeQuery("SELECT * FROM `saler` WHERE salerID = '" + id +"' AND salerPass = '"+pass
                                + "'");
                while (rez.next()) {
                    aa = "saler";
                    saler = salerDAO.getsaler(Integer.parseInt(id));

                }
            }


            rez.close();
            stat.close();

        } catch (SQLException ex) {
            System.out.println("sql problem");
            System.out.println(ex.getMessage());
        }
        System.out.println("isValidCredentials operation done successfully");

        return aa;
    }

    @FXML
    private void exit(){
        System.exit(0);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {

        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent home_page_parent = null;
        home_page_parent = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene home_page_scene = new Scene(home_page_parent,800,500);
        home_page_scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();


    }

    @FXML
    private void play(){
        Snd.playSound("/Users/mohammedissa/Dropbox/dr/workspace 2/Toyor-al-Janah/src/sample/error.wav");
    }


    @FXML void saleshow(ActionEvent event) throws IOException {

        prodID.clear();

        productList.getItems().clear();

        productImage.setDisable(false);

        ProductDAO productDAO = new ProductDAO();

        ArrayList<Product> myLists = new ArrayList<>();

        int producId;
        double price ;
        String size = null;
        String color = null;
        String discription = null;
        String catagory = null;
        String pic = null;
        String kind = null;

        try {
            java.sql.Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("select distinct * from product, `managerBuy` , `preorder` , `preorderConsistOfProduct`\n" +
                    "WHERE product.idproduct = preorderConsistOfProduct.idofproduct AND preorderConsistOfProduct.idofpreorder = preorder.idpreorder AND preorder.idpreorder = managerBuy.preorderID" +
                    " and product.productCatagory = '"+catagoryCombo.getValue()+"' and product.productSizes = '"+sizeCombo.getValue()+"' and product.kind = '"+kindCombo.getValue()+"'");
            while (rez.next()) {
                producId = rez.getInt("idproduct");
                price = rez.getDouble("productPrice");
                color = rez.getString("productColor");
                discription = rez.getString("productDiscription");
                catagory = rez.getString("productCatagory");
                size = rez.getString("productSizes");
                pic = rez.getString("productPic");
                kind = rez.getString("kind");

                Product product = new Product(producId, price, color, discription, catagory, size, pic, kind);
                myLists.add(product);
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }



        for (int i = 0 ; i < myLists.size() ; i++){
            System.out.println(myLists.get(i).getIdproduct()+" price : "+myLists.get(i).getProductPrice());
            productList.getItems().add("ID :" +myLists.get(i).getIdproduct()+"      :price : "+myLists.get(i).getProductPrice());
        }




    }

    @FXML
    private void setImage(){


        String id = productList.getSelectionModel().getSelectedItem().split(":")[1];

        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProduct(id);

        productShop = product;

        File file = new File(product.getProductImage()+".jpg");
        Image image = new Image(file.toURI().toString());
        productImage.setImage(image);

        prodDisc.setText(product.getProductDiscription() + " " + product.getProductKind() + " size: " + product.getProductSize() );


    }

    @FXML
    private void addOrder(){


        PreOrder preOrder = new PreOrder(0);
        PreOrderDAO preOrderDAO = new PreOrderDAO();
        preOrderDAO.insertPreOrder(preOrder);

        String name = suppliersCombo.getValue();
        SupplierDAO supplierDAO = new SupplierDAO();

        int id = supplierDAO.getIdSupplierBykNames(name);

        int pId = preOrderDAO.getLastrow().getId();

        preOrder.setId(pId);

        Relative relative = new Relative(id,pId);
        RelativeDAO relativeDAO = new RelativeDAO();
        relativeDAO.insertRelative(relative);



    }

    @FXML
    private void loadSupplier(ActionEvent event) throws IOException {

        SupplierDAO supplierDAO = new SupplierDAO();
        ArrayList<Supplier> suppliers = supplierDAO.getAllSuppliers();

        suppliersCombo.getItems().clear();

        for (int i =0 ; i < suppliers.size() ; i ++){
            suppliersCombo.getItems().add(suppliers.get(i).getName());
        }


        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        app_stage.hide(); //optional
        app_stage.show();


    }

    @FXML
    private void loadList(ActionEvent event){

        PreOrderDAO preOrderDAO = new PreOrderDAO();
        ArrayList<PreOrder> myLists = preOrderDAO.getAllPreOrders();

        ObservableList<String> items = FXCollections.observableArrayList ();

        for (int i = 0 ; i < myLists.size();i++){
            items.add(myLists.get(i).getId()+"");
        }

        listView.setItems(items);


    }
    @FXML
    private void addProduct(){

        String kind = PKind.getValue();
        Product product = new Product(Double.parseDouble(PPrice.getText()),PColor.getText(),PDiscription.getText(),PCatagory.getText(),PSize.getText(),imagePath,kind);
        ProductDAO productDAO = new ProductDAO();
        productDAO.insertProduct(product);

        int id = productDAO.getLastrow().getIdproduct();
        product.setIdproduct(id);

        PreOrderContains preOrderContains = new PreOrderContains(Integer.parseInt(OPreOrder.getValue()),id,3);
        PreOrderContainsDAO preOrderContainsDAO = new PreOrderContainsDAO();
        preOrderContainsDAO.insertPreOrderContains(preOrderContains);

        PPrice.clear();PColor.clear();PDiscription.clear();PCatagory.clear();PSize.clear();imagePath="";

    }

    @FXML
    private void buyPreorder(){

        int id = Integer.parseInt(listView.getSelectionModel().getSelectedItem());


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();

        String date = dateFormat.format(cal.getTime());
        Buy buy = new Buy(manager.getSid(),id,date);
        System.out.println(manager.getSname());

        BuyDAO buyDAO = new BuyDAO();
        buyDAO.insertBuy(buy);

    }

    @FXML
    private void showbyID(){

        catagoryCombo.getSelectionModel().clearSelection();
        kindCombo.getSelectionModel().clearSelection();
        sizeCombo.getSelectionModel().clearSelection();
        productList.getItems().clear();

        productImage.setDisable(false);

        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProduct(Integer.parseInt(prodID.getText())+"");

        prodID.clear();
        File file = new File(product.getProductImage()+".jpg");
        Image image = new Image(file.toURI().toString());
        productImage.setImage(image);

        prodDisc.setText(product.getProductDiscription() + " " + product.getProductKind() + " size: " + product.getProductSize()+" price :" +product.getProductPrice());

        productShop = product;

    }

    @FXML
    private void loadsale(){

        ArrayList<String> myLists = new ArrayList<>();

        try {
            java.sql.Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("select distinct productCatagory from product, `managerBuy` , `preorder` , `preorderConsistOfProduct`\n" +
                    "WHERE product.idproduct = preorderConsistOfProduct.idofproduct AND preorderConsistOfProduct.idofpreorder = preorder.idpreorder AND preorder.idpreorder = managerBuy.preorderID");
            while (rez.next()) {
                String catagory = rez.getString("productCatagory");
                myLists.add(catagory);
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        for (int i = 0 ; i < myLists.size() ; i ++){
            catagoryCombo.getItems().add(myLists.get(i));
        }


        kindCombo.getItems().addAll("female","male");

        sizeCombo.getItems().addAll("s","m","l","xl");

        catagoryCombo.setDisable(false);
        kindCombo.setDisable(false);
        sizeCombo.setDisable(false);
        productTableView.setDisable(false);



    }
    @FXML
    private void show() throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("products.fxml"));
        Scene home_page_scene = new Scene(home_page_parent,500,500);
        Stage app_stage = new Stage();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    @FXML
    private void loadPreOrders(){

        PKind.getItems().addAll("female","male");

        PreOrderDAO preOrderDAO = new PreOrderDAO();
        ArrayList<PreOrder> arrayList = preOrderDAO.getAllPreOrders();


        for (int i =0 ; i < arrayList.size() ; i ++){
            OPreOrder.getItems().add(arrayList.get(i).getId()+"");
        }

        OPreOrder.setDisable(false);
    }

    @FXML
    void chooseImage(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image");

        File file = fileChooser.showOpenDialog(new Stage());

        imagePath = file.getPath();
    }

    @FXML
    private Label total;

    @FXML
    void setview(){

        String id = productList.getSelectionModel().getSelectedItem().split(":")[1];

        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProduct(id);


        File file = new File(product.getProductImage()+".jpg");
        Image image = new Image(file.toURI().toString());
        productImage.setImage(image);

        prodDisc.setText(product.getProductDiscription() + " " + product.getProductKind() + " size: " + product.getProductSize());

    }

    @FXML
    void addtoShopings(){

        if(istrue == false){

            postOrder = new PostOrder(0);
            PostOrderDAO postOrderDAO = new PostOrderDAO();
            postOrderDAO.insertPostOrder(postOrder);

            postOrder.setId(postOrderDAO.getLast().getId());

            PostOrder p2  = postOrderDAO.getLast();

            currentID = p2.getId();
            System.out.println(currentID + "asdadaasdf");
        }

        int quantitya = Integer.parseInt(quantity.getText());

        PreOrderContainsDAO preOrderContainsDAO = new PreOrderContainsDAO();
        int qq = preOrderContainsDAO.getQuantity(productShop.getIdproduct());

        if(Integer.parseInt(quantity.getText())>qq){

            while (quantitya >0 ){


                PostOrderContains postOrderContains = new PostOrderContains(currentID,productShop.getIdproduct());
                PostOrderContainsDAO postOrderContainsDAO = new PostOrderContainsDAO();
                postOrderContainsDAO.insertPostOrderContains(postOrderContains);

                System.out.println(productShop.getIdproduct()+" shop");
                quantitya--;
            }}
        else
            System.out.println("no products enough");

        istrue = true;

    }

    @FXML
    void deletefromShopings(){

        String id = prodList.getSelectionModel().getSelectedItem();
        id = id.split(" ")[0];
        PostOrderContainsDAO postOrderContainsDAO = new PostOrderContainsDAO();
        postOrderContainsDAO.deletePostOrderContains(Integer.parseInt(id));



    }

    @FXML
    private void fill(){

        PostOrderDAO postOrderDAO = new PostOrderDAO();
        PostOrder p2  = postOrderDAO.getLast();

        currentID = p2.getId();

        System.out.println("curren post = " +currentID);

        ArrayList<Product> myLists = new ArrayList<>();

        int producId;
        double price ;
        String size = null;
        String color = null;
        String discription = null;
        String catagory = null;
        String pic = null;
        String kind = null;

        try {
            java.sql.Connection cnn = new DB_Connection().getConnection();
            Statement stat = cnn.createStatement();
            ResultSet rez = stat.executeQuery("select * from product, `postorderConsistofProduct` WHERE product.idproduct =  postorderConsistofProduct.idOfProduct and postorderConsistofProduct.idOfpostorder =  "+currentID+";");
            while (rez.next()) {
                producId = rez.getInt("idproduct");
                price = rez.getDouble("productPrice");
                color = rez.getString("productColor");
                discription = rez.getString("productDiscription");
                catagory = rez.getString("productCatagory");
                size = rez.getString("productSizes");
                pic = rez.getString("productPic");
                kind = rez.getString("kind");

                Product product = new Product(producId, price, color, discription, catagory, size, pic, kind);
                myLists.add(product);
                System.out.println("product is " + product.getIdproduct());
            }
            rez.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }



        double priceA = 0;
        ObservableList<String> items = FXCollections.observableArrayList ();

        for (int i = 0 ; i < myLists.size();i++){
            items.add(myLists.get(i).getIdproduct()+"     " + myLists.get(i).getProductPrice());
            priceA+=myLists.get(i).getProductPrice();
        }

        total.setText(priceA+"");
        System.out.println("total = " + priceA);
        prodList.setItems(items);
    }

    @FXML
    private void sale(ActionEvent event){

        PostOrderDAO postOrderDAO = new PostOrderDAO();
        PostOrder p2  = postOrderDAO.getLast();

        currentID = p2.getId();

        Customer customer = new Customer();
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.insertCustomer();

        int idcustomer = customerDAO.getLast().getId();

        int sid = 0;

        if (isSaler == false){
            sid = manager.getSid();}
        else{
            sid = saler.getSid();}


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();

        String date = dateFormat.format(cal.getTime());

        Sale sale = new Sale(idcustomer,currentID,sid,date);
        SaleDAO saleDAO = new SaleDAO();
        saleDAO.insertSale(sale);


        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();

        istrue = false;




    }

    @FXML
    private void addmanager() throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("addmanager.fxml"));
        Scene home_page_scene = new Scene(home_page_parent,600,400);
        Stage app_stage = new Stage();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @FXML
    private void addsaler() throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("addsaler.fxml"));
        Scene home_page_scene = new Scene(home_page_parent,600,400);
        Stage app_stage = new Stage();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @FXML
    private void addManagerClick() {

        String date = datePicker.getValue().toString();
        Manager manager = new Manager(PPrice.getText(),date,PColor.getText(),PSize.getText());
        ManagerDAO managerDAO = new ManagerDAO();
        managerDAO.insertManager(manager);

        PDiscription.setText("ID "+managerDAO.getLast().getSid());

        System.out.println("asdas");
        PPrice.clear();PColor.clear();PSize.clear();


    }

    @FXML
    private void addSalerClick()  {

        String date = datePicker.getValue().toString();
        Saler saler = new Saler(PPrice.getText(),date,PColor.getText(),PSize.getText());
        SalerDAO salerDAO = new SalerDAO();

        salerDAO.insertSaler(saler);

        PDiscription.setText("ID "+ salerDAO.getLast().getSid());

        System.out.println("asdas");
        PPrice.clear();PColor.clear();PSize.clear();


    }

    @FXML
    private void addSupplierClick()  {

        Supplier supplier = new Supplier(PPrice.getText(),PColor.getText(),PSize.getText(),PCatagory.getText());
        SupplierDAO supplierDAO = new SupplierDAO();
        supplierDAO.insertSupplier(supplier);

        PDiscription.setText("ID "+ supplierDAO.getLast().getId());

        System.out.println("asdas");
        PPrice.clear();PColor.clear();PSize.clear();


    }

    @FXML
    private void addsupplier() throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("addsupplier.fxml"));
        Scene home_page_scene = new Scene(home_page_parent,600,400);
        Stage app_stage = new Stage();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @FXML
    private void getbestsaler(){

        SalerDAO salerDAO = new SalerDAO();
        Saler saler = salerDAO.getbest();

        hisID.setText(saler.getSname() + "  id :"+saler.getSid());


    }
}
