package com.forms.models;

import javafx.scene.paint.Color;

public class Veiculo {
    private Color color;
    
    private int fabricationYear;
    
    private String brand;
    
    private String model;
    
    private String licensePlate;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Veiculo() {
    }

    public Veiculo(Color color, int fabricationYear, String brand, String model, String licensePlate, Integer id) {
        this.color = color;
        this.fabricationYear = fabricationYear;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(int fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isValid(){
        return color != null 
                && model != null 
                && brand != null 
                && licensePlate != null 
                && fabricationYear > 1900;
    }

    @Override
    public String toString() {
        return getModel() + "\n" + 
               getBrand() + "\n" +
               getLicensePlate() + "\n" +
               getFabricationYear() + "\n" +
               getColor().toString();
    }
}
