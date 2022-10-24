/**
 * Sample Skeleton for 'hello-view.fxml' Controller Class
 */

package com.example.travelexpertsjava;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class TravelExpertsJavaController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCancel"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML // fx:id="btnEdit"
    private Button btnEdit; // Value injected by FXMLLoader

    @FXML // fx:id="cboSelect"
    private ComboBox<Table> cboSelect; // Value injected by FXMLLoader

    @FXML // fx:id="tvTable"
    private TableView<ObservableList<?>> tvTable; // Value injected by FXMLLoader

    @FXML // fx:id="welcomeText"
    private Label welcomeText; // Value injected by FXMLLoader

    private final ObservableList<Table> editableTables = FXCollections.observableArrayList();
    private ObservableList<ObservableList<?>> tableData = FXCollections.observableArrayList();

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert cboSelect != null : "fx:id=\"cboSelect\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tvTable != null : "fx:id=\"tvTable\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'hello-view.fxml'.";

        cboSelect.setItems(editableTables);
        editableTables.add(new AgentTable());

        editableTables.get(0).setTable(tvTable, tableData);
        tvTable.setItems(tableData);
        System.out.println(tableData);


        cboSelect.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observableValue, Object o, Object t1) {

            }
        });

    }

}
