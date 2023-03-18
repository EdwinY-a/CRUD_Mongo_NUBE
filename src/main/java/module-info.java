module com.example.examen_examen_mongo {
    requires javafx.controls;
    requires javafx.fxml;
    requires mongo.java.driver;


    opens com.example.examen_examen_mongo to javafx.fxml;
    exports com.example.examen_examen_mongo;
}