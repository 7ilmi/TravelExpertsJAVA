package com.example.travelexpertsjava;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AgentTable extends Table{
    public AgentTable() {
        super("Agents");
        this.columnNames.add("ID");
        this.columnNames.add("First Name");
        this.columnNames.add("Middle Initial");
        this.columnNames.add("Last Name");
        this.columnNames.add("Phone");
        this.columnNames.add("Email");
        this.columnNames.add("Position");
        this.columnNames.add("Agency ID");
    }

    @Override
    public void setTableData(ObservableList<ObservableList<?>> data) {
        ObservableList<Agent> agents = AgentDAO.getAll();
        data.clear();
        for(Agent a : agents){
            ObservableList<String> row = FXCollections.observableArrayList();
            row.add(a.getAgentId()+"A");
            row.add(a.getAgtFirstName()+"");
            row.add(a.getAgtMiddleInitial()+"");
            row.add(a.getAgtLastName()+"");
            row.add(a.getAgtBusPhone()+"");
            row.add(a.getAgtEmail()+"");
            row.add(a.getAgtPosition()+"");
            row.add(a.getAgencyId()+"");

            data.add(row);
        }
    }
}
