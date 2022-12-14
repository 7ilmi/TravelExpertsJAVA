/**
 * Sample Skeleton for 'main-view.fxml' Controller Class
 */

package com.example.travelexpertsjava;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TravelExpertsJavaController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnAdd"
    private Button btnAdd; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancel"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML // fx:id="btnDelete"
    private Button btnDelete; // Value injected by FXMLLoader

    @FXML // fx:id="btnEdit"
    private Button btnEdit; // Value injected by FXMLLoader

    @FXML // fx:id="welcomeText"
    private Label welcomeText; // Value injected by FXMLLoader

    @FXML // fx:id="cboSelect"
    private ComboBox<Table> cboSelect; // Value injected by FXMLLoader

    @FXML // fx:id="tvTable"
    private TableView<ObservableList<?>> tvTable; // Value injected by FXMLLoader

    private final ObservableList<Table> editableTables = FXCollections.observableArrayList();
    private ObservableList<ObservableList<?>> tableData = FXCollections.observableArrayList();

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'main-view.fxml'.";
        assert cboSelect != null : "fx:id=\"cboSelect\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvTable != null : "fx:id=\"tvTable\" was not injected: check your FXML file 'main-view.fxml'.";
        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'main-view.fxml'.";


        cboSelect.setItems(editableTables);
        editableTables.add(new AgentTable());
        editableTables.add(new CustomerTable());

        cboSelect.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observableValue, Object o, Object t1) {
                updateTableView();
            }
        });

        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Table<?> selectedTable = cboSelect.getValue();
                if(selectedTable != null) {
                    Node node = (Node) actionEvent.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    try{
                        selectedTable.add(stage);
                    }
                    catch (Exception e){
                        System.out.println(e.toString());
                    }
                }
            }
        });

        btnEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override @FXML
            public void handle(ActionEvent actionEvent) {
                Table<?> selectedTable = cboSelect.getValue();
                ObservableList<String> selectedRow = (ObservableList<String>) tvTable.getSelectionModel().getSelectedItem();
                if(selectedTable != null && selectedRow != null) {
                    Node node = (Node) actionEvent.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    try{
                        selectedTable.edit(Integer.parseInt(selectedRow.get(0)), stage);
                    }
                    catch (Exception e){
                        System.out.println(e.toString());
                    }
                }
            }
        });

        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Table<?> selectedTable = cboSelect.getValue();
                ObservableList<String> selectedRow = (ObservableList<String>) tvTable.getSelectionModel().getSelectedItem();
                if(selectedTable != null && selectedRow != null) {
                    selectedTable.delete(Integer.parseInt(selectedRow.get(0)));
                    updateTableView();
                }
            }
        });

        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ((Stage) btnCancel.getScene().getWindow()).close();
            }
        });

        cboSelect.getSelectionModel().select(editableTables.get(0));
    }

    public void updateTableView(){
        Table<?> selectedTable = cboSelect.getValue();
        if(selectedTable != null){
            selectedTable.setTable(tvTable, tableData);
            tvTable.setItems(tableData);
        }
    }

    public void selectTable(Class<?> tableClass){
        for(Table<?> tb : editableTables){
            if(tb.getClass() == tableClass){
                cboSelect.getSelectionModel().select(tb);
            }
        }
    }
}
