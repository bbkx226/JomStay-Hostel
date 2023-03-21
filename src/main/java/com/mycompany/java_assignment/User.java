/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_assignment;

/**
 *
 * @author KZ
 */
public class User {
    private String ID, name, email, username, password;
    
    public User(String ID, String name, String email, String username, String password) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // setters and getters
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User [ID=" + ID + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
                + password + "]";
    }
}
