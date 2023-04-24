package com.forms.controllers;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.forms.models.Lugar;
import com.forms.utils.CustomAlert;

public class LugarController {

    @FXML private TextField txt_city;
    @FXML private TextField txt_country;
    @FXML private TextField txt_description;
    @FXML private TextField txt_state;

    private ArrayList<Lugar> places = new ArrayList<Lugar>();

    @FXML
    void save(ActionEvent event) {
        var place = new Lugar(
            txt_country.getText(), 
            txt_city.getText(), 
            txt_state.getText(), 
            txt_description.getText());

        if(!place.isValid()){
            CustomAlert.showError("Preencha todos os campos");
            return;
        }
        
        CustomAlert.showSuccess("Cadastrado com sucesso");
        places.add(place);
        reset();
    }

    @FXML
    void show(ActionEvent event) {
        for (Lugar lugar : places) {
            CustomAlert.showInformation(lugar.toString());
        }
    }

    private void reset(){
        txt_city.clear();
        txt_country.clear();
        txt_description.clear();
        txt_state.clear();
    }
}
