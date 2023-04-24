package com.forms.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CustomAlert {
    
    public static void showSuccess(String message){
        Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
    }

    public static void showInformation(String message){
        Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
    }

    public static void showError(String message){
        Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(message);
		alert.show();
    }
}
