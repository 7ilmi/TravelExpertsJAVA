/**
 * Sample Skeleton for 'hello-view.fxml' Controller Class
 */

package com.example.travelexpertsjava;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class TravelExpertsJavaController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cboSelect"
    private ComboBox<?> cboSelect; // Value injected by FXMLLoader

    @FXML // fx:id="lblSelect"
    private Label lblSelect; // Value injected by FXMLLoader

    @FXML // fx:id="welcomeText"
    private Label welcomeText; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cboSelect != null : "fx:id=\"cboSelect\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblSelect != null : "fx:id=\"lblSelect\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}
