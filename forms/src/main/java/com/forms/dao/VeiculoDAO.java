package com.forms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.forms.models.Veiculo;

import javafx.scene.paint.Color;

public class VeiculoDAO extends BaseDAO {
    
    public VeiculoDAO(Connection connection) {
        super(connection);
    }

    public ArrayList<Veiculo> getVeiculos(){
        return super.executarQuery("select * from Pessoa", x -> {
            try {
                return new Veiculo(Color.valueOf(x.getString("color")), 
                x.getInt("fabricationYear"),
                x.getString("brand"),
                x.getString("model"),
                x.getString("licensePlate"));
            } catch (SQLException e) {
                return null;
            }
        });
    }

    public void insertVeiculo(Veiculo v){
        String sql = "insert into Pessoa values(color, brand, frabicationYear, licensePlate, model) "+
                     "values ('"+v.getColor()+"','"+v.getBrand()+"',"+v.getFabricationYear()+",'"+v.getLicensePlate()+"', '"+v.getModel()+"')";
        super.executeScalar(sql);
    }
}
