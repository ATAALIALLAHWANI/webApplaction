/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an.ataali.model;



/**
 *
 * @author LENOVO
 */
public class TouristBuilder {
   private int id ;
   private String name ;
   private String phone;
   private boolean is_block = false ; 
   private int count ;

    public TouristBuilder Id(int id) {
        this.id = id;
        return this ;
    }

    public TouristBuilder Name(String name) {
        this.name = name;
        return this ;
    }

    public TouristBuilder Phone(String phone) {
        this.phone = phone;
        return this ;
    }

    public TouristBuilder Is_block(boolean is_block) {
        this.is_block = is_block;
        return this ;
    }

    public TouristBuilder Count(int count) {
        this.count = count;
        return this ;
    }
   public Tourist build(){
       return new Tourist(id, name, phone, is_block, count);
   }
     
}
