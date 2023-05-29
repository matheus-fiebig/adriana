package com.forms.controllers;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import com.forms.dao.LugarDAO;
import com.forms.factory.JdbcConnectionFactory;
import com.forms.models.Lugar;
import com.forms.utils.CustomAlert;

public class LugarController {

    @FXML private TextField txt_city;
    @FXML private TextField txt_country;
    @FXML private TextField txt_description;
    @FXML private TextField txt_state;

    private LugarDAO lugarDAO;

    public LugarController() {
        super();
        var conn = new JdbcConnectionFactory().recuperarConexao();
        lugarDAO = new LugarDAO(conn);
    }

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
        lugarDAO.insertLugar(place);
        reset();
    }

    @FXML
    void show(ActionEvent event) {
        for (Lugar lugar : lugarDAO.getLugares()) {
            CustomAlert.showInformation(lugar.toString());
        }
    }

    private void reset(){
        txt_city.clear();
        txt_country.clear();
        txt_description.clear();
        txt_state.clear();
    }

    @FXML
    void goMenu(ActionEvent event) {
        MainController mc = new MainController();
        mc.changeToMenu();
    }
}
