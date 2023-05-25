/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an.ataali.model;

/**
 *
 * @author LENOVO
 */
public class CityBuilder {
     private int id;
    private String name ;
    private String image;
    private int country_id =1;
    private int rate;
   private String  status;

    public CityBuilder Country_id(int country_id) {
        this.country_id = country_id;
         return this ;
    }

    public CityBuilder Id(int id) {
        this.id = id;
        return this ;
    }

    public CityBuilder Name(String name) {
        this.name = name;
        return this ;
    }

    public CityBuilder Image(String image) {
        this.image = image;
        return this ;
    }

   

    public CityBuilder Rate(int rate) {
        this.rate = rate;
        return this ;
    }

    public CityBuilder Status(String status) {
        this.status = status;
        return this ;
    }
   public City build(){
       return new City(id, name, image, rate, status);
   }
}
