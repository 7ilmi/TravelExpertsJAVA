package com.example.travelexpertsjava;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class Agent {
    //attributes
    private SimpleIntegerProperty agentId, agencyId;
    private SimpleStringProperty agtFirstName, agtMiddleInitial, agtLastName, agtBusPhone, agtEmail, agtPosition;

    //constructor
    public Agent(
            int agentId, String agtFirstName, String agtMiddleInitial,
            String agtLastName, String agtBusPhone, String agtEmail,
            String agtPosition, int agencyId) {
        this.agentId = new SimpleIntegerProperty(agentId);
        this.agencyId = new SimpleIntegerProperty(agencyId);
        this.agtFirstName = new SimpleStringProperty(agtFirstName);
        this.agtMiddleInitial = new SimpleStringProperty(agtMiddleInitial);
        this.agtLastName = new SimpleStringProperty(agtLastName);
        this.agtBusPhone = new SimpleStringProperty(agtBusPhone);
        this.agtEmail = new SimpleStringProperty(agtEmail);
        this.agtPosition = new SimpleStringProperty(agtPosition);
    }

    public Agent(){
        this.agentId = new SimpleIntegerProperty();
        this.agencyId = new SimpleIntegerProperty();
        this.agtFirstName = new SimpleStringProperty();
        this.agtMiddleInitial = new SimpleStringProperty();
        this.agtLastName = new SimpleStringProperty();
        this.agtBusPhone = new SimpleStringProperty();
        this.agtEmail = new SimpleStringProperty();
        this.agtPosition = new SimpleStringProperty();
    }

    public Agent(ObservableList<String> ol){
        this(Integer.parseInt(ol.get(0)), ol.get(1), ol.get(2), ol.get(3), ol.get(4), ol.get(5), ol.get(6), Integer.parseInt(ol.get(7)));
    }


    //to string override
    @Override
    public String toString() {
        return (getAgentId() + " - " + getAgtFirstName() + " " + getAgtLastName());
    }

    //getters and setters
    public int getAgentId() {
        return agentId.get();
    }
    public SimpleIntegerProperty agentIdProperty() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId.set(agentId);
    }
    public int getAgencyId() {
        return agencyId.get();
    }

    public SimpleIntegerProperty agencyIdProperty() {
        return agencyId;
    }
    public void setAgencyId(int agencyId) {
        this.agencyId.set(agencyId);
    }

    public String getAgtFirstName() {
        return agtFirstName.get();
    }
    public SimpleStringProperty agtFirstNameProperty() {
        return agtFirstName;
    }

    public void setAgtFirstName(String agtFirstName) {
        this.agtFirstName.set(agtFirstName);
    }
    public String getAgtMiddleInitial() {
        return agtMiddleInitial.get();
    }

    public SimpleStringProperty agtMiddleInitialProperty() {
        return agtMiddleInitial;
    }
    public void setAgtMiddleInitial(String agtMiddleInitial) {
        this.agtMiddleInitial.set(agtMiddleInitial);
    }

    public String getAgtLastName() {
        return agtLastName.get();
    }

    public SimpleStringProperty agtLastNameProperty() {
        return agtLastName;
    }

    public void setAgtLastName(String agtLastName) {
        this.agtLastName.set(agtLastName);
    }

    public String getAgtBusPhone() {
        return agtBusPhone.get();
    }

    public SimpleStringProperty agtBusPhoneProperty() {
        return agtBusPhone;
    }

    public void setAgtBusPhone(String agtBusPhone) {
        this.agtBusPhone.set(agtBusPhone);
    }

    public String getAgtEmail() {
        return agtEmail.get();
    }

    public SimpleStringProperty agtEmailProperty() {
        return agtEmail;
    }

    public void setAgtEmail(String agtEmail) {
        this.agtEmail.set(agtEmail);
    }

    public String getAgtPosition() {
        return agtPosition.get();
    }

    public SimpleStringProperty agtPositionProperty() {
        return agtPosition;
    }

    public void setAgtPosition(String agtPosition) {
        this.agtPosition.set(agtPosition);
    }
}
