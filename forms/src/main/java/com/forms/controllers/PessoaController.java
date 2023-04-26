package com.forms.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.forms.models.Pessoa;
import com.forms.utils.CustomAlert;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class PessoaController implements Initializable {

    @FXML private DatePicker txt_birthDate;
    @FXML private TextField txt_cpf;
    @FXML private TextField txt_firstName;
    @FXML private TextField txt_lastName;

    private ArrayList<Pessoa> people = new ArrayList<Pessoa>();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        txt_birthDate.setValue(LocalDate.now());
    }

    @FXML
    void save(ActionEvent event) {
        var person = new Pessoa(
            txt_firstName.getText(), 
            txt_lastName.getText(), 
            txt_birthDate.getValue(), 
            txt_cpf.getText());

        if(!person.isValid()){
            CustomAlert.showError("Preencha todos os campos");
            return;
        }
        
        CustomAlert.showSuccess("Cadastrado com sucesso");
        people.add(person);
        reset();
    }

    @FXML
    void show(ActionEvent event) {
        for (Pessoa pessoa : people) {
            CustomAlert.showInformation(pessoa.toString());
        }
    }

    private void reset(){
        txt_birthDate.setValue(LocalDate.now());
        txt_cpf.clear();
        txt_firstName.clear();
        txt_lastName.clear();
    }

    @FXML
    void goMenu(ActionEvent event) {
        MainController mc = new MainController();
        mc.changeToMenu();
    }
}
