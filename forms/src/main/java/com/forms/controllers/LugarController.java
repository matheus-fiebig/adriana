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
    private Integer hiddenId = 0;

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
            txt_description.getText(),
            hiddenId);

        if(!place.isValid()){
            CustomAlert.showError("Preencha todos os campos");
            return;
        }
        
        CustomAlert.showSuccess("Cadastrado com sucesso");
        if(hiddenId == 0) lugarDAO.insertLugar(place);
        else lugarDAO.updateLugar(place);
        
        reset();
    }

    @FXML
    void show(ActionEvent event) {
        for (Lugar lugar : lugarDAO.getLugares()) {
            CustomAlert.showInformation(lugar.toString());
        }
    }
    
    @FXML
    void updateLast(ActionEvent event){
        var lugar = lugarDAO.getLugares().stream().findFirst().get();

        hiddenId = lugar.getId();
        txt_city.setText(lugar.getCity());
        txt_country.setText(lugar.getCountry());
        txt_description.setText(lugar.getDescription());
        txt_state.setText(lugar.getState());
    }

    @FXML
    void deleteAll(ActionEvent event){
        lugarDAO.deleteAll();
    }

    private void reset(){
        txt_city.clear();
        txt_country.clear();
        txt_description.clear();
        txt_state.clear();
        hiddenId = 0;
    }

    @FXML
    void goMenu(ActionEvent event) {
        MainController mc = new MainController();
        mc.changeToMenu();
    }
}
