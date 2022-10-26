package com.example.travelexpertsjava;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerAddEditController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCancel"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML // fx:id="btnOk"
    private Button btnOk; // Value injected by FXMLLoader

    @FXML // fx:id="lblTitle"
    private Label lblTitle; // Value injected by FXMLLoader

    @FXML // fx:id="tfAddress"
    private TextField tfAddress; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentId"
    private TextField tfAgentId; // Value injected by FXMLLoader

    @FXML // fx:id="tfBusinessPhone"
    private TextField tfBusinessPhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfCity"
    private TextField tfCity; // Value injected by FXMLLoader

    @FXML // fx:id="tfCountry"
    private TextField tfCountry; // Value injected by FXMLLoader

    @FXML // fx:id="tfEmail"
    private TextField tfEmail; // Value injected by FXMLLoader

    @FXML // fx:id="tfFirstName"
    private TextField tfFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="tfHomePhone"
    private TextField tfHomePhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfId"
    private TextField tfId; // Value injected by FXMLLoader

    @FXML // fx:id="tfLastName"
    private TextField tfLastName; // Value injected by FXMLLoader

    @FXML // fx:id="tfPostal"
    private TextField tfPostal; // Value injected by FXMLLoader

    @FXML // fx:id="tfProvince"
    private TextField tfProvince; // Value injected by FXMLLoader

    private Customer customer = null;
    private boolean add = false;

    private final CustomerDAO dao = new CustomerDAO();

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert lblTitle != null : "fx:id=\"lblTitle\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert tfAddress != null : "fx:id=\"tfAddress\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert tfAgentId != null : "fx:id=\"tfAgentId\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert tfBusinessPhone != null : "fx:id=\"tfBusinessPhone\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert tfCity != null : "fx:id=\"tfCity\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert tfCountry != null : "fx:id=\"tfCountry\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert tfEmail != null : "fx:id=\"tfEmail\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert tfFirstName != null : "fx:id=\"tfFirstName\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert tfHomePhone != null : "fx:id=\"tfHomePhone\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert tfId != null : "fx:id=\"tfId\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert tfLastName != null : "fx:id=\"tfLastName\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert tfPostal != null : "fx:id=\"tfPostal\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";
        assert tfProvince != null : "fx:id=\"tfProvince\" was not injected: check your FXML file 'customer-addEdit-view.fxml'.";

        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                saveToDatabase();
                backToMain(actionEvent);
            }
        });

        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                backToMain(actionEvent);
            }
        });

    }

    private void saveToDatabase(){
        this.customer = new Customer();
        customer.setCustFirstName(tfFirstName.getText());
        customer.setCustLastName(tfLastName.getText());
        customer.setCustAddress(tfAddress.getText());
        customer.setCustCity(tfCity.getText());
        customer.setCustProv(tfProvince.getText());
        customer.setCustPostal(tfPostal.getText());
        customer.setCustCountry(tfCountry.getText());
        customer.setCustHomePhone(tfHomePhone.getText());
        customer.setCustBusPhone(tfBusinessPhone.getText());
        customer.setCustEmail(tfEmail.getText());
        customer.setAgentId(Integer.parseInt(tfAgentId.getText()));

        if(this.add){
            this.dao.add(this.customer);
        }
        else{
            customer.setCustomerId(Integer.parseInt(tfId.getText()));
            this.dao.update(this.customer);
        }
    }

    private void backToMain(ActionEvent actionEvent){
        try{
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(TravelExpertsJavaApplication.class.getResource("main-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            TravelExpertsJavaController controller = fxmlLoader.getController();
            controller.selectTable(CustomerTable.class);
            stage.show();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void editCustomer(Customer cust) {
        this.customer = cust;
        this.add = false;
        lblTitle.setText("Edit Customer");
        tfId.setDisable(true);

        tfId.setText(cleanupText(cust.getCustomerId()));
        tfAddress.setText(cleanupText(cust.getCustAddress()));
        tfAgentId.setText(cleanupText(cust.getAgentId()));
        tfBusinessPhone.setText(cleanupText(cust.getCustBusPhone()));
        tfCity.setText(cleanupText(cust.getCustCity()));
        tfCountry.setText(cleanupText(cust.getCustCountry()));
        tfEmail.setText(cleanupText(cust.getCustEmail()));
        tfFirstName.setText(cleanupText(cust.getCustFirstName()));
        tfHomePhone.setText(cleanupText(cust.getCustHomePhone()));
        tfLastName.setText(cleanupText(cust.getCustLastName()));
        tfPostal.setText(cleanupText(cust.getCustPostal()));
        tfProvince.setText(cleanupText(cust.getCustProv()));
    }

    public void addCustomer(){
        this.add = true;
        this.customer = new Customer();
        this.lblTitle.setText("Add Customer");
        tfId.setDisable(true);
    }

    private static String cleanupText(Object in){
        return (in+"").trim();
    }
}
