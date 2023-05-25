/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterFaceModel;

import an.ataali.model.Tourist;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public interface ITourist {
    Tourist findByPhone(String phone);
    boolean saveInfo(String name , String phone );
     void IncreaseCount(int id ) throws SQLException;
}
