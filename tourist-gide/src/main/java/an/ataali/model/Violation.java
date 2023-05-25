/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an.ataali.model;

/**
 *
 * @author LENOVO
 */
public class Violation {
    private int id;
    private String date ;
    private int user_id;
    private int city_id;
    private String violation_type;
    private String image;
    private boolean is_hide;

    public Violation(int id, String date, int user_id, int city_id, String violation_type, String image, boolean is_hide) {
        this.id = id;
        this.date = date;
        this.user_id = user_id;
        this.city_id = city_id;
        this.violation_type = violation_type;
        this.image = image;
        this.is_hide = is_hide;
    }
    
    

    public boolean isIs_hide() {
        return is_hide;
    }

    public void setIs_hide(boolean is_hide) {
        this.is_hide = is_hide;
    }
    

    public Violation() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setViolation_type(String violation_type) {
        this.violation_type = violation_type;
    }

    public void setImage(String image) {
        this.image = image;
    }

    

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public String getViolation_type() {
        return violation_type;
    }

    public String getImage() {
        return image;
    }

  public static ViolationsBuilder builder() {
      
		return new ViolationsBuilder();
	}
   
}
