/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an.ataali.dao;

import InterFaceModel.IViolations;
import an.ataali.model.Violation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author LENOVO
 */
public class ViolationDao implements IViolations {
     private Connection con;
     private String query;
     private PreparedStatement pst;
     private ResultSet rs;

    public ViolationDao(Connection con) {
        this.con = con;
    }
    @Override
    public boolean saveViolation( String date, String v_type, String image, int user_id, int city_id) {
     query = "INSERT INTO violations (date_reported, violation_type, image, user_id, city_id) VALUES (?, ?, ?, ?, ?)";

    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
        preparedStatement.setString(1, date);
        preparedStatement.setString(2, v_type);
        preparedStatement.setString(3, image);
        
        preparedStatement.setInt(4, user_id);
        preparedStatement.setInt(5, city_id);
        
        preparedStatement.executeUpdate();
        
        return true;
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return false;
}
    
    
    ////
    
    
     @Override

    public List<Violation> getAllViolations() throws SQLException {
    List<Violation> list = new ArrayList<>();

    query = "SELECT * FROM violations;";
    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Violation v = Violation.builder()
                        .Date(resultSet.getString("date_reported"))
                        .Id(resultSet.getInt("id"))
                        .Image(resultSet.getString("image"))
                        .City_id(resultSet.getInt("city_id"))
                        .User_id(resultSet.getInt("user_id"))
                        .sViolation_type(resultSet.getString("violation_type"))
                        .Is_hide(resultSet.getBoolean("is_hide"))
                        .build();
                      
               
               
                
                list.add(v);
            }
        }
    }

    return list;
}
     @Override

    public void cencelReport(int id){
         try{
           
            query = "delete from violations where id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
     @Override

   public void  confirmReport(int id ) throws SQLException{
        if(con==null)return ;
		
		 query = "UPDATE violations SET is_hide = TRUE WHERE id = ?";
		
                   pst = con.prepareStatement(query);
                   pst.setInt(1, id);
                   int rowsUpdated = pst.executeUpdate();
                    if (rowsUpdated > 0) {
        System.out.println("ture is convert successfully.");
    } else {
        System.out.println("No rows updated. User ID may not exist.");
    }
    }
    
    @Override

   public String checkCityStatus(int cityId) throws SQLException {
    int activeTrafficLight = getActiveViolation(cityId, "Red light crossing");
    int activeStopSign = getActiveViolation(cityId, "Running a stop sign");
    int activeJaywalking = getActiveViolation(cityId, "Jaywalking");
    int activeLittering = getActiveViolation(cityId, "Littering");

    if (activeTrafficLight >= 2) {
        return "Dangerous";
    } else if (activeStopSign >= 2) {
        return "Dangerous";
    } else if (activeJaywalking >= 2) {
        return "Insane";
    } else if (activeLittering >= 2) {
        return "Dirty";
    } else {
        return "Safe";
    }
}
 @Override

public int getActiveViolation(int id_c, String type) throws SQLException {
    int count = 3;

    // Prepare the SQL query to count the active violations
     query = "SELECT COUNT(*) FROM violations WHERE city_id = ? AND violation_type = ?";
    pst = con.prepareStatement(query);
    pst.setInt(1, id_c);
    pst.setString(2, type);

    // Execute the query and retrieve the count
    rs = pst.executeQuery();
    if (rs.next()) {
        count = rs.getInt(1);
    } else {
        System.out.println("No count retrieved from the database.");
    }
    System.out.println(count);
    return count;
}



 @Override

public int getActiveViolation(int id_c) throws SQLException {
    int count = 3;

    // Prepare the SQL query to count the active violations
     query = "SELECT COUNT(*) FROM violations WHERE city_id = ?";
    pst = con.prepareStatement(query);
    pst.setInt(1, id_c);
    

    // Execute the query and retrieve the count
    rs = pst.executeQuery();
    if (rs.next()) {
        count = rs.getInt(1);
    } else {
        System.out.println("No count retrieved from the database.");
    }
    System.out.println(count);
    return count;
}


 @Override


  public boolean isViolationExpired(int violationId) throws SQLException {
         query = "SELECT date_reported FROM violations WHERE id = ?";
        pst = con.prepareStatement(query);
        pst.setInt(1, violationId);
        rs = pst.executeQuery();

        if (rs.next()) {
            
            Timestamp violationDate = rs.getTimestamp("date_reported");
            LocalDateTime locldate = LocalDateTime.now();
              LocalDateTime expirationDate = violationDate.toLocalDateTime().plus(1, ChronoUnit.MONTHS);
//              LocalDateTime expirationDate = locldate.plusMinutes(1);
            System.out.println("expirationDate = " +expirationDate);
            return locldate.isAfter(expirationDate);
        } 
        else {
            System.out.println("the Violation is not found in class (isViolationExpired) ");
            return false; 
        }
        
    }

   
   
@Override
  public void  isExpired() throws SQLException{
      boolean expired = false ;
      
      List <Violation> violations = new ArrayList<>();
      violations = getAllViolations();
      for(Violation v : violations){
          if(isViolationExpired(v.getId())){
              cencelReport(v.getId());
          }
      }
      
      
//      return expired;
  }


   //
}
