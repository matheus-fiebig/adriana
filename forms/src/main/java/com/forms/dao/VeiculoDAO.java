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

    public static int[] getRGB(final String rgb)
    {
        final int[] ret = new int[3];
        for (int i = 0; i < 3; i++)
        {
            ret[i] = Integer.parseInt(rgb.substring(i * 2, i * 2 + 2), 16);
        }
        return ret;
    }

    public ArrayList<Veiculo> getVeiculos(){
        return super.executarQuery("select * from Veiculo", x -> {
            try {
                var t = x.getString("color");
                var color = getRGB(t.substring(1, t.length())) ;

                return new Veiculo( Color.rgb(color[0], color[1], color[2], 1) , 
                x.getInt("fabricationYear"),
                x.getString("brand"),
                x.getString("model"),
                x.getString("licensePlate"),
                x.getInt("id"));
            } catch (SQLException e) {
                return null;
            }
        });
    }

    public void insertVeiculo(Veiculo v){
        var colorHex = String.format( "#%02X%02X%02X",
            (int)( v.getColor().getRed() * 255 ),
            (int)( v.getColor().getGreen() * 255 ),
            (int)( v.getColor().getBlue() * 255 ) );
        String sql = "insert into Veiculo(color, brand, fabricationYear, licensePlate, model) "+
                     "values ('"+colorHex+"','"+v.getBrand()+"',"+v.getFabricationYear()+",'"+v.getLicensePlate()+"', '"+v.getModel()+"')";
        super.executeScalar(sql);
    }

    public void deleteAll(){
        String sql = "delete from Veiculo where id > 0";
        executeScalar(sql);
    }

    public void updateVeiculo(Veiculo v) {
        var colorHex = String.format( "#%02X%02X%02X",
                        (int)( v.getColor().getRed() * 255 ),
                        (int)( v.getColor().getGreen() * 255 ),
                        (int)( v.getColor().getBlue() * 255 ) );
        String sql = "update Veiculo set Brand = '"+v.getBrand()+
                "', FabricationYear = '"+v.getFabricationYear()+
                "', LicensePlate='"+v.getLicensePlate()+
                "', Model='"+v.getModel()+
                "', Color='"+colorHex+
                "' where Id = " + v.getId();
        super.executeScalar(sql);
    }
}
