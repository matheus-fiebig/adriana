package com.forms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.forms.models.Lugar;
import com.forms.models.Pessoa;

public class PessoaDAO extends BaseDAO {
    
    public PessoaDAO(Connection connection) {
        super(connection);
    }

    public ArrayList<Pessoa> getPessoas(){
        return super.executarQuery("select * from Pessoa", x -> {
            try {
                var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                var birthDate = x.getString("birthDate");
                return new Pessoa(
                    x.getString("first_Name"), 
                    x.getString("last_Name"), 
                    LocalDateTime.parse(birthDate, formatter).toLocalDate(),
                    x.getString("cpf"));
            } catch (SQLException e) {
                return null;
            }
        });
    }

    public void insertPessoa(Pessoa p){
        String sql = "insert into Pessoa values(cpf, first_Name, last_Name, birthDate) "+
                     "values ('"+p.getCpf()+"','"+p.getFirstName()+"','"+p.getLastName()+"','"+p.getBirthDate()+"')";
        super.executeScalar(sql);
    }
}
