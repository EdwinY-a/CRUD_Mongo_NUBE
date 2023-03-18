package com.example.examen_examen_mongo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception{
        root= FXMLLoader.load(Main.class.getResource("automovil.fxml"));
        Scene scene=new Scene(root, 650, 500);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}