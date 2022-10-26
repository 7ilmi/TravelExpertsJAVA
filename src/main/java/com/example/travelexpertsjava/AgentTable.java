package com.example.travelexpertsjava;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AgentTable extends Table<Agent>{
    public AgentTable() {
        super("Agents", new AgentDAO());
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
        ObservableList<Agent> agents = (ObservableList<Agent>) this.dao.getAll();
        data.clear();
        for(Agent a : agents){
            ObservableList<String> row = FXCollections.observableArrayList();
            row.add(a.getAgentId()+"");
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

    @Override
    public void add(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TravelExpertsJavaApplication.class.getResource("agent-addEdit-view.fxml"));
        Parent root = fxmlLoader.load();
        AgentAddEditController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        controller.addAgent();
        stage.show();
    }

    @Override
    public void edit(int id, Stage stage) throws IOException {
        Agent agt = new AgentDAO().getAll().stream().filter(c -> c.getAgentId() == id).findAny().orElse(null);

        FXMLLoader fxmlLoader = new FXMLLoader(TravelExpertsJavaApplication.class.getResource("agent-addEdit-view.fxml"));
        Parent root = fxmlLoader.load();
        AgentAddEditController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        controller.editAgent(agt);
        stage.show();
    }

    @Override
    public void delete(int index) {
        this.dao.delete(index);
    }
}
