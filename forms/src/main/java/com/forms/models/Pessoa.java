package com.forms.models;

import java.time.LocalDate;

public class Pessoa {
    private String firstName;   
    
    private String lastName;   
    
    private LocalDate birthDate;   

    private String cpf;

    public Pessoa() {
        super();
    }

    public Pessoa(String firstName, String lastName, LocalDate birthDate, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.cpf = cpf;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isValid(){
        return cpf != null &&
                firstName != null &&
                lastName != null &&
                birthDate != null;
    }

    @Override
    public String toString() {
        return this.firstName + " \n" + 
            this.lastName + "\n" + 
            this.cpf + "\n" +
            this.birthDate;
    }
}
