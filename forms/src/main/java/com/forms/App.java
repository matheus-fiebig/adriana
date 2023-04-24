package com.forms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.forms.controllers.MainController;

import java.io.IOException;
import java.net.URL;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Parent root = null;

        var resource = getClass()
            .getResource("./views/main.fxml");

        try {
            root = FXMLLoader.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root, 640, 400);
        stage.setScene(scene);

        var stylesPath = App.class.getResource("./views/style.css").toString();
        stage.getScene().getStylesheets().add(stylesPath);

        MainController.setStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}