/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterFaceModel;

import an.ataali.model.City;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface ICity {
      List<City> getAllcities();
       String getNameCity(int id) throws SQLException;
        int getId_city(String name) throws SQLException;
        public void updateCityStatus(int cityId, String newStatus) throws SQLException;
         public void updateCityRate(int cityId) throws SQLException;
         
}
