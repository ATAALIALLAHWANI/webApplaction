/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterFaceModel;

import an.ataali.model.Violation;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface IViolations {
     boolean saveViolation( String date, String v_type, String image, int user_id, int city_id);
     List<Violation> getAllViolations() throws SQLException;
     void cencelReport(int id) ;
     void  confirmReport(int id ) throws SQLException ;
     String checkCityStatus(int cityId) throws SQLException;
     int getActiveViolation(int id_c, String type)  throws SQLException ;
     int getActiveViolation(int id_c)  throws SQLException ;
     boolean isViolationExpired(int violationId)  throws SQLException ;
     void  isExpired() throws SQLException;
 

}