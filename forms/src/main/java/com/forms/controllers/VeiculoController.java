package com.forms.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.forms.dao.VeiculoDAO;
import com.forms.factory.JdbcConnectionFactory;
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
    private int hiddenId = 0;

    private VeiculoDAO veiculoDAO;

    public VeiculoController() {
        super();
        var conn = new JdbcConnectionFactory().recuperarConexao();
        veiculoDAO = new VeiculoDAO(conn);
    }

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
            txt_licensePlate.getText(),
            hiddenId);

        if(!vehicle.isValid()){
            CustomAlert.showError("Preencha todos os campos");
            return;
        }
        
        CustomAlert.showSuccess("Cadastrado com sucesso");
        if(hiddenId == 0) veiculoDAO.insertVeiculo(vehicle);
        else veiculoDAO.updateVeiculo(vehicle);
        
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
    void updateLast(ActionEvent event){
        var v = veiculoDAO.getVeiculos().stream().findFirst().get();

        txt_brand.setText(v.getBrand());
        txt_fabricationYear.setText(v.getFabricationYear() + "");
        txt_licensePlate.setText(v.getLicensePlate());
        txt_model.setText(v.getModel());
        field_colorPicker.setValue(v.getColor());
        hiddenId = v.getId();
    }

    @FXML
    void deleteAll(ActionEvent event){
        veiculoDAO.deleteAll();
    }

    @FXML
    void show(ActionEvent event) {
        for (Veiculo vehicle : veiculoDAO.getVeiculos()) {
            CustomAlert.showInformation(vehicle.toString());
        }
    }

    private void reset(){
        field_colorPicker.setValue(new javafx.scene.paint.Color(0, 0, 0, 0));
        txt_model.clear();
        txt_brand.clear();
        txt_licensePlate.clear();
        txt_fabricationYear.clear();
        hiddenId = 0;
    }    

    @FXML
    void goMenu(ActionEvent event) {
        MainController mc = new MainController();
        mc.changeToMenu();
    }
}
