package com.forms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.forms.models.Lugar;

public class LugarDAO extends BaseDAO {
    
    public LugarDAO(Connection connection) {
        super(connection);
    }

    public ArrayList<Lugar> getLugares(){
        return super.executarQuery("select * from Lugar", x -> {
            try {
                return new Lugar(
                    x.getString("country"), 
                    x.getString("city"), 
                    x.getString("state"), 
                    x.getString("description"),
                    x.getInt("id"));
            } catch (SQLException e) {
                return null;
            }
        });
    }

    public void insertLugar(Lugar l){
        String sql = "insert into Lugar(city, country, description, state) "+
                     "values ('"+l.getCity()+"','"+l.getCountry()+"','"+l.getDescription()+"','"+l.getState()+"')";
        super.executeScalar(sql);
    }

    public void updateLugar(Lugar l){
        String sql = "update Lugar set City = '"+l.getCity()+
                     "', Country = '"+l.getCountry()+
                     "', Description='"+l.getDescription()+
                     "', State='"+l.getState()+
                     "' where Id = " + l.getId();
        super.executeScalar(sql);
    }

    public void deleteAll(){
        String sql = "delete from Lugar where id > 0";
        executeScalar(sql);
    }
}
