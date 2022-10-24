package com.example.travelexpertsjava;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerTable extends Table{
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
}
