package com.example.travelexpertsjava;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class Customer {
    private SimpleIntegerProperty customerId, agentId;
    private SimpleStringProperty custFirstName, custLastName, custAddress, custCity, custProv, custPostal, custCountry,
        custHomePhone, custBusPhone, custEmail;

    public Customer(int customerId, String custFirstName, String custLastName, String custAddress,
                    String custCity, String custProv, String custPostal, String custCountry, String custHomePhone,
                    String custBusPhone, String custEmail, int agentId) {
        this.customerId = new SimpleIntegerProperty(customerId);
        this.agentId = new SimpleIntegerProperty(agentId);
        this.custFirstName = new SimpleStringProperty(custFirstName);
        this.custLastName = new SimpleStringProperty(custLastName);
        this.custAddress = new SimpleStringProperty(custAddress);
        this.custCity = new SimpleStringProperty(custCity);
        this.custProv = new SimpleStringProperty(custProv);
        this.custPostal = new SimpleStringProperty(custPostal);
        this.custCountry = new SimpleStringProperty(custCountry);
        this.custHomePhone = new SimpleStringProperty(custHomePhone);
        this.custBusPhone = new SimpleStringProperty(custBusPhone);
        this.custEmail = new SimpleStringProperty(custEmail);
    }

    public Customer(){
        this.customerId = new SimpleIntegerProperty();
        this.agentId = new SimpleIntegerProperty();
        this.custFirstName = new SimpleStringProperty();
        this.custLastName = new SimpleStringProperty();
        this.custAddress = new SimpleStringProperty();
        this.custCity = new SimpleStringProperty();
        this.custProv = new SimpleStringProperty();
        this.custPostal = new SimpleStringProperty();
        this.custCountry = new SimpleStringProperty();
        this.custHomePhone = new SimpleStringProperty();
        this.custBusPhone = new SimpleStringProperty();
        this.custEmail = new SimpleStringProperty();
    }

    public Customer(ObservableList<String> ol){
        this(Integer.parseInt(ol.get(0)), ol.get(1), ol.get(2), ol.get(3), ol.get(4), ol.get(5), ol.get(6),
                ol.get(7), ol.get(8), ol.get(9), ol.get(10), Integer.parseInt(ol.get(11)));
    }

    @Override
    public String toString() {
        return (getCustomerId() + " - " + getCustFirstName() + " " + getCustLastName());
    }

    public int getCustomerId() {
        return customerId.get();
    }

    public SimpleIntegerProperty customerIdProperty() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }

    public int getAgentId() {
        return agentId.get();
    }

    public SimpleIntegerProperty agentIdProperty() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId.set(agentId);
    }

    public String getCustFirstName() {
        return custFirstName.get();
    }

    public SimpleStringProperty custFirstNameProperty() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName.set(custFirstName);
    }

    public String getCustLastName() {
        return custLastName.get();
    }

    public SimpleStringProperty custLastNameProperty() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName.set(custLastName);
    }

    public String getCustAddress() {
        return custAddress.get();
    }

    public SimpleStringProperty custAddressProperty() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress.set(custAddress);
    }

    public String getCustCity() {
        return custCity.get();
    }

    public SimpleStringProperty custCityProperty() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity.set(custCity);
    }

    public String getCustProv() {
        return custProv.get();
    }

    public SimpleStringProperty custProvProperty() {
        return custProv;
    }

    public void setCustProv(String custProv) {
        this.custProv.set(custProv);
    }

    public String getCustPostal() {
        return custPostal.get();
    }

    public SimpleStringProperty custPostalProperty() {
        return custPostal;
    }

    public void setCustPostal(String custPostal) {
        this.custPostal.set(custPostal);
    }

    public String getCustCountry() {
        return custCountry.get();
    }

    public SimpleStringProperty custCountryProperty() {
        return custCountry;
    }

    public void setCustCountry(String custCountry) {
        this.custCountry.set(custCountry);
    }

    public String getCustHomePhone() {
        return custHomePhone.get();
    }

    public SimpleStringProperty custHomePhoneProperty() {
        return custHomePhone;
    }

    public void setCustHomePhone(String custHomePhone) {
        this.custHomePhone.set(custHomePhone);
    }

    public String getCustBusPhone() {
        return custBusPhone.get();
    }

    public SimpleStringProperty custBusPhoneProperty() {
        return custBusPhone;
    }

    public void setCustBusPhone(String custBusPhone) {
        this.custBusPhone.set(custBusPhone);
    }

    public String getCustEmail() {
        return custEmail.get();
    }

    public SimpleStringProperty custEmailProperty() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail.set(custEmail);
    }
}
