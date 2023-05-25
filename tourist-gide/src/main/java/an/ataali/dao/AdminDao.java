/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an.ataali.dao;


import an.ataali.model.Admin;
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
public class AdminDao {
  private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public AdminDao(Connection con) {
       this.con = con ;
    }
    
    
  public Admin AdminLogin(String email ,String password ) throws SQLException{
      if(con == null)return null;
       query = "SELECT * FROM admin WHERE email=? AND password=?;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){
              preparedStatement.setString(1,email );
              preparedStatement.setString(2, password);
              rs = preparedStatement.executeQuery();
              Admin admin ;
               if(rs.next()){
            admin = Admin.builder()
                    .Id(rs.getInt("id"))
                    .Name(rs.getString("name"))
                    .Email(rs.getString("email"))
                    .build();
                     return admin;       
                            
           
        }
        }
         return null;
        }
  
  }
  


