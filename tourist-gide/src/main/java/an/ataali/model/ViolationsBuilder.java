/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an.ataali.model;

/**
 *
 * @author LENOVO
 */
public class ViolationsBuilder {
    private int id;
    private String date ;
    private int user_id;
    private int city_id;
    private String violation_type;
    private String image;
    private boolean is_hide;

   
    public ViolationsBuilder Id(int id) {
        this.id = id;
         return this;
    }

    public ViolationsBuilder Date(String date) {
        this.date = date;
         return this;
    }

    public ViolationsBuilder User_id(int user_id) {
        this.user_id = user_id;
         return this;
    }

    public ViolationsBuilder City_id(int city_id) {
        this.city_id = city_id;
         return this;
    }

    public ViolationsBuilder sViolation_type(String violation_type) {
        this.violation_type = violation_type;
         return this;
    }

    public ViolationsBuilder Image(String image) {
        this.image = image;
        return this;
    }
     public ViolationsBuilder Is_hide(boolean is_hide) {
        this.is_hide = is_hide;
        return this ;
    }
     
   public Violation build(){
       return new Violation(id, date, user_id, city_id, violation_type, image, is_hide);
   }
}
