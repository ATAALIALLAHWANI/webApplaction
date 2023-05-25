/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an.ataali.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author LENOVO
 */
public class Dbcon {
     
    private static Connection connction = null;
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(connction == null){
            Class.forName("com.mysql.jdbc.Driver");
           connction= DriverManager.getConnection("jdbc:mysql://localhost/touristg","ataali","ataali007");
            
           
        }
        return connction;
    }
}
