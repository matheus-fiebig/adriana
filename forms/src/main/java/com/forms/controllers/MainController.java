package com.forms.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MainController {

    private static Stage currentStage;

    public static void setStage(Stage stage) {
        currentStage = stage;
    }

    @FXML
    void changeToLugar(ActionEvent event) {
        changeScene("../views/lugar.fxml");
    }

    @FXML
    void changeToPessoa(ActionEvent event) {
        changeScene("../views/pessoa.fxml");
    }
    
    @FXML
    void changeToVeiculo(ActionEvent event) {
        changeScene("../views/veiculo.fxml");
    }

    private void changeScene(String fxml) {
        Parent scene;
        try {
            scene = FXMLLoader.load(getClass().getResource(fxml));
            currentStage.getScene().setRoot(scene);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
