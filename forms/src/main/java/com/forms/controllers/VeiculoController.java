package com.forms.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.forms.models.Veiculo;
import com.forms.utils.CustomAlert;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class VeiculoController implements Initializable{

    @FXML private ColorPicker field_colorPicker;
    @FXML private TextField txt_brand;
    @FXML private TextField txt_fabricationYear;
    @FXML private TextField txt_licensePlate;
    @FXML private TextField txt_model;

    private ArrayList<Veiculo> vehicles = new ArrayList<Veiculo>();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        field_colorPicker.setValue(new javafx.scene.paint.Color(0, 0, 0, 0));
    }

    @FXML
    void save(ActionEvent event) {
        var vehicle = new Veiculo(
            field_colorPicker.getValue(), 
            tryParseInt(),
            txt_brand.getText(), 
            txt_model.getText(),
            txt_licensePlate.getText());

        if(!vehicle.isValid()){
            CustomAlert.showError("Preencha todos os campos");
            return;
        }
        
        CustomAlert.showSuccess("Cadastrado com sucesso");
        vehicles.add(vehicle);
        reset();
    }

    private int tryParseInt() {
        try{
            return Integer.parseInt(txt_fabricationYear.getText());
        } catch(Exception e){
            return 0;
        }
    }

    @FXML
    void show(ActionEvent event) {
        for (Veiculo vehicle : vehicles) {
            CustomAlert.showInformation(vehicle.toString());
        }
    }

    private void reset(){
        field_colorPicker.setValue(new javafx.scene.paint.Color(0, 0, 0, 0));
        txt_model.clear();
        txt_brand.clear();
        txt_licensePlate.clear();
        txt_fabricationYear.clear();
    }    
}
