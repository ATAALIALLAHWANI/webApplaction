/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an.ataali.model;

/**
 *
 * @author LENOVO
 */
public class AdminBuilder {
    private int id;
    private String name ;
    private String email;
    private String password;

    public AdminBuilder Id(int id) {
        this.id = id;
        return this ;
    }

    public AdminBuilder Name(String name) {
        this.name = name;
        return this ;
    }

    public AdminBuilder Email(String email) {
        this.email = email;
        return this ;
    }

    public AdminBuilder Password(String password) {
        this.password = password;
        return this ;
    }
    
    public Admin build(){
        return new Admin(id, name, email, password);
    }
    
}
