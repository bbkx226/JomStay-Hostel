/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_assignment;

/**
 *
 * @author KZ
 */
public class Admin extends User {
    // constructor
    public Admin(String ID, String name, String email, String username, String password) {
        super(ID, name, email, username, password);
    }

    // (display) system login record for authentication and authorisation process
    public void displayLoginRecord() {
        System.out.println(LoginSystem.loginRecordsToString());
    }

    // Add/update/read/delete hostel room information
    // Manage students’ hostel application
    // Check students’ record
    // Generate report such as monthly income, number of rooms available, etc. 2.Student
}
