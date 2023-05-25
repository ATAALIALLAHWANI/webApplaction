/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an.ataali.model;

/**
 *
 * @author LENOVO
 */
public class Tourist {
   private int id ;
   private String name ;
   private String phone;
   private boolean is_block ; 
   private int count ;
    public Tourist() {
    }

    public Tourist(int id, String name, String phone, boolean is_block, int count) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.is_block = is_block;
        this.count = count;
    }
    

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isIs_block() {
        return is_block;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIs_block(boolean is_block) {
        this.is_block = is_block;
    }
public static TouristBuilder builder() {
		return new TouristBuilder();
	}


}
