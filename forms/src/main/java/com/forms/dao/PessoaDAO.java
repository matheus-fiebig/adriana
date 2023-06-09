package com.forms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
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
                    LocalDate.parse(birthDate, formatter),
                    x.getString("cpf"),
                    x.getInt("id"));
            } catch (SQLException e) {
                return null;
            }
        });
    }

    public void insertPessoa(Pessoa p){
        String sql = "insert into Pessoa(cpf, first_Name, last_Name, birthDate) "+
                     "values ('"+p.getCpf()+"','"+p.getFirstName()+"','"+p.getLastName()+"','"+p.getBirthDate()+"')";
        super.executeScalar(sql);
    }

    public void deleteAll(){
        String sql = "delete from Pessoa where id > 0";
        executeScalar(sql);
    }
    
    public void updatePessoa(Pessoa p){
        String sql = "update Pessoa set cpf = '"+p.getCpf()+
                     "', first_Name = '"+p.getFirstName()+
                     "', last_Name='"+p.getLastName()+
                     "', birthDate='"+p.getBirthDate()+
                     "' where Id = " + p.getId();
        super.executeScalar(sql);
    }
}
