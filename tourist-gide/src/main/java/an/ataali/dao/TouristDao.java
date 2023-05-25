/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an.ataali.dao;

import InterFaceModel.ITourist;
import an.ataali.model.Tourist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class TouristDao implements ITourist{
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public TouristDao(Connection con) {
        this.con = con;
    }

    @Override
    public Tourist findByPhone(String phone){
        if(con==null)return null;
		
		 query = "SELECT * FROM users WHERE phone_number=?;";
		try(PreparedStatement preparedStatement = con.prepareStatement(query)){
			preparedStatement.setString(1, phone);
			 rs = preparedStatement.executeQuery();
                    Tourist t; 
                    if(rs.next()){
                        t=Tourist.builder()
                                .Id(rs.getInt("id"))
                                .Name(rs.getString("name"))
                                .Phone(rs.getString("phone_number"))
                                .Is_block(rs.getBoolean("is_blocked"))
                                .Count(rs.getInt("count"))
                                .build();
                                
                          return t;
                    }
                   
                    
                } catch (SQLException ex) {
            Logger.getLogger(TouristDao.class.getName()).log(Level.SEVERE, null, ex);
        }
             return null;  
    }
    @Override
    public boolean saveInfo(String name , String phone ){
        
         
         Tourist t = findByPhone(phone);
         
         if(t == null){
                 
            query = "INSERT INTO users (name,phone_number , is_blocked ) VALUES (?,?,?)";
           
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, name);
              pst.setString(2, phone);
              pst.setBoolean(3, false);
              pst.executeUpdate();
                    
               return true;
                    
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(TouristDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
             return true;
         
    }
   
    @Override
    public  void IncreaseCount(int id ) throws SQLException{
               if(con==null)return ;
		
		 query = "UPDATE users SET count = count + 1 WHERE id = ?";
		
                   pst = con.prepareStatement(query);
                   pst.setInt(1, id);
                   int rowsUpdated = pst.executeUpdate();
                    if (rowsUpdated > 0) {
        System.out.println("Count increased successfully.");
    } else {
        System.out.println("No rows updated. User ID may not exist.");
    }
                
    }
  
    
    
    //
}
