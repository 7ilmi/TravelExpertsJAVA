module com.example.travelexpertsjava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.travelexpertsjava to javafx.fxml;
    exports com.example.travelexpertsjava;
}