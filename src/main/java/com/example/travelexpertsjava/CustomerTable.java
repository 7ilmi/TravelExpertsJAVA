package com.example.travelexpertsjava;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomerTable extends Table<Customer>{
    public CustomerTable() {
        super("Customers", new CustomerDAO());
        this.columnNames.add("ID");
        this.columnNames.add("First Name");
        this.columnNames.add("Last Name");
        this.columnNames.add("Address");
        this.columnNames.add("City");
        this.columnNames.add("Province");
        this.columnNames.add("Postal Code");
        this.columnNames.add("Country");
        this.columnNames.add("Home Phone");
        this.columnNames.add("Business Phone");
        this.columnNames.add("Email");
        this.columnNames.add("Agent ID");
    }

    @Override
    public void setTableData(ObservableList<ObservableList<?>> data) {
        ObservableList<Customer> agents = (ObservableList<Customer>) this.dao.getAll();
        data.clear();
        for(Customer c : agents){
            ObservableList<String> row = FXCollections.observableArrayList();
            row.add(c.getCustomerId() +"");
            row.add(c.getCustFirstName() +"");
            row.add(c.getCustLastName() +"");
            row.add(c.getCustAddress() +"");
            row.add(c.getCustCity() +"");
            row.add(c.getCustProv() +"");
            row.add(c.getCustPostal() +"");
            row.add(c.getCustCountry() +"");
            row.add(c.getCustHomePhone() +"");
            row.add(c.getCustBusPhone() +"");
            row.add(c.getCustEmail() +"");
            row.add(c.getAgentId()+"");

            data.add(row);
        }
    }

    @Override
    public void add(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TravelExpertsJavaApplication.class.getResource("customer-addEdit-view.fxml"));
        Parent root = fxmlLoader.load();
        CustomerAddEditController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        controller.addCustomer();
        stage.show();
    }

    @Override @FXML
    public void edit(int id, Stage stage) throws IOException {
        Customer cust = new CustomerDAO().getAll().stream().filter(c -> c.getCustomerId() == id).findAny().orElse(null);

        FXMLLoader fxmlLoader = new FXMLLoader(TravelExpertsJavaApplication.class.getResource("customer-addEdit-view.fxml"));
        Parent root = fxmlLoader.load();
        CustomerAddEditController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        controller.editCustomer(cust);
        stage.show();
    }

    @Override
    public void delete(int index) {
        this.dao.delete(index);
    }
}
