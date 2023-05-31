package com.forms.models;

public class Lugar {
    private String country;
    
    private String city;
    
    private String state;
    
    private String description;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lugar() {
    }

    public Lugar(String country, String city, String state, String description, Integer id) {
        this.country = country;
        this.city = city;
        this.state = state;
        this.description = description;
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValid(){
        return description != null && 
                state != null && 
                city != null && 
                country != null;
    }

    @Override
    public String toString() {
        return this.country + " \n" + 
            this.city + "\n" + 
            this.state + "\n" +
            this.description;
    }
}
