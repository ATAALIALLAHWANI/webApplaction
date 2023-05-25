/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an.ataali.dao;

import InterFaceModel.ICity;
import an.ataali.model.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CityDao implements ICity {
    
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public CityDao(Connection con) {
        this.con = con;
    }
    
    
    
    @Override
     public List<City> getAllcities(){
         List <City> citylist = new ArrayList<>();
         if(con == null) return null;
         
         try{
              query = "SELECT * FROM cities";
               pst = this.con.prepareStatement(query);
              rs =pst.executeQuery();
              while(rs.next()){
               City c =  City.Builder()
                       .Id(rs.getInt("id"))
                       .Name(rs.getString("name"))
                       .Image(rs.getString("image"))
                       .Rate(rs.getInt("rate"))
                       .Status(rs.getString("status"))
                       .build();
           
              
                citylist.add(c);
             
              
           }
              
         }catch(Exception ex){
             ex.printStackTrace();
         }
         
         return citylist;
     }
     @Override
    public String getNameCity(int id) throws SQLException {
    String name = "..";

     query = "SELECT name FROM cities WHERE id= ?";
    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
        preparedStatement.setInt(1, id);
         rs = preparedStatement.executeQuery();
        if (rs.next()) {
            name = rs.getString("name");
        }
    } 
    return name;
}
    @Override
    public int getId_city(String name) throws SQLException{
         int id = 1;

     query = "SELECT id FROM cities WHERE name= ?";
    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
        preparedStatement.setString(1, name);
         rs = preparedStatement.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id");
        }
    } 
    return id;
    }
    @Override
    public void updateCityStatus(int cityId, String newStatus) throws SQLException {
        
        query = "UPDATE cities SET status = ? WHERE id = ?";
           pst = con.prepareStatement(query);
           pst.setString(1,newStatus);
           pst.setInt(2, cityId);
           int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("City status updated successfully.");
            } else {
                System.out.println("Failed to update city status. City not found.");
            }
    }
    
    
    @Override
    public void updateCityRate(int cityId) throws SQLException {
    // Get the active violation count for the city
    ViolationDao doaV = new  ViolationDao(con);
    int activeViolations = doaV.getActiveViolation(cityId);
    
    // Determine the new rate based on the number of violations
    int newRate = 10; // Default rate
    if (activeViolations >= 3) {
         newRate = 5; // Set a new rate if there are 3 or more violations
    }
     if(activeViolations >9){
        newRate = 1 ;
    }
    
    // Update the rate in the database
     query = "UPDATE cities SET rate = ? WHERE id = ?";
    pst = con.prepareStatement(query);
    pst.setInt(1, newRate);
    pst.setInt(2, cityId);
    pst.executeUpdate();
}
    
    
    
    //
}
