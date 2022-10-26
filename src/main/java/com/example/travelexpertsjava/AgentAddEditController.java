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

public class AgentAddEditController {

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

    @FXML // fx:id="tfAgencyId"
    private TextField tfAgencyId; // Value injected by FXMLLoader

    @FXML // fx:id="tfBusinessPhone"
    private TextField tfBusinessPhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfEmail"
    private TextField tfEmail; // Value injected by FXMLLoader

    @FXML // fx:id="tfFirstName"
    private TextField tfFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="tfId"
    private TextField tfId; // Value injected by FXMLLoader

    @FXML // fx:id="tfLastName"
    private TextField tfLastName; // Value injected by FXMLLoader

    @FXML // fx:id="tfMiddleInitial"
    private TextField tfMiddleInitial; // Value injected by FXMLLoader

    @FXML // fx:id="tfPosition"
    private TextField tfPosition; // Value injected by FXMLLoader

    private Agent agent = null;
    private boolean add = false;

    private final AgentDAO dao = new AgentDAO();

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'agent-addEdit-view.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'agent-addEdit-view.fxml'.";
        assert lblTitle != null : "fx:id=\"lblTitle\" was not injected: check your FXML file 'agent-addEdit-view.fxml'.";
        assert tfAgencyId != null : "fx:id=\"tfAgencyId\" was not injected: check your FXML file 'agent-addEdit-view.fxml'.";
        assert tfBusinessPhone != null : "fx:id=\"tfBusinessPhone\" was not injected: check your FXML file 'agent-addEdit-view.fxml'.";
        assert tfEmail != null : "fx:id=\"tfEmail\" was not injected: check your FXML file 'agent-addEdit-view.fxml'.";
        assert tfFirstName != null : "fx:id=\"tfFirstName\" was not injected: check your FXML file 'agent-addEdit-view.fxml'.";
        assert tfId != null : "fx:id=\"tfId\" was not injected: check your FXML file 'agent-addEdit-view.fxml'.";
        assert tfLastName != null : "fx:id=\"tfLastName\" was not injected: check your FXML file 'agent-addEdit-view.fxml'.";
        assert tfMiddleInitial != null : "fx:id=\"tfMiddleInitial\" was not injected: check your FXML file 'agent-addEdit-view.fxml'.";
        assert tfPosition != null : "fx:id=\"tfPosition\" was not injected: check your FXML file 'agent-addEdit-view.fxml'.";

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
        this.agent = new Agent();
        agent.setAgtFirstName(tfFirstName.getText());
        agent.setAgtMiddleInitial(tfMiddleInitial.getText());
        agent.setAgtLastName(tfLastName.getText());
        agent.setAgtBusPhone(tfBusinessPhone.getText());
        agent.setAgtEmail(tfEmail.getText());
        agent.setAgtPosition(tfPosition.getText());
        agent.setAgencyId(Integer.parseInt(tfAgencyId.getText()));

        if(this.add){
            this.dao.add(this.agent);
        }
        else{
            agent.setAgentId(Integer.parseInt(tfId.getText()));
            this.dao.update(this.agent);
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
            controller.selectTable(AgentTable.class);
            stage.show();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void editAgent(Agent agt) {
        this.agent = agt;
        this.add = false;
        lblTitle.setText("Edit Agent");
        tfId.setDisable(true);

        tfId.setText(cleanupText(agt.getAgentId()));
        tfAgencyId.setText(cleanupText(agt.getAgencyId()));
        tfBusinessPhone.setText(cleanupText(agt.getAgtBusPhone()));
        tfEmail.setText(cleanupText(agt.getAgtEmail()));
        tfFirstName.setText(cleanupText(agt.getAgtFirstName()));
        tfLastName.setText(cleanupText(agt.getAgtLastName()));
        tfMiddleInitial.setText(cleanupText(agt.getAgtMiddleInitial()));
        tfPosition.setText(cleanupText(agt.getAgtPosition()));
    }

    public void addAgent(){
        this.add = true;
        this.agent = new Agent();
        this.lblTitle.setText("Add Agent");
        tfId.setDisable(true);
    }

    private static String cleanupText(Object in){
        return (in+"").trim();
    }
}

