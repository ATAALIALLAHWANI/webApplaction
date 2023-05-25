/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an.ataali.model;

/**
 *
 * @author LENOVO
 */
public class City {
    private int id;
    private String name ;
    private String image;
    private int country_id =1;
    private int rate;
   private String  status;
    public City() {
    }

    public City(int id, String name, String image, int rate, String status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.rate = rate;
        this.status = status;
    }

 
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getCountry_id() {
        return country_id;
    }

    public int getRate() {
        return rate;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

public static CityBuilder Builder(){
    return new CityBuilder();
}
    
}
