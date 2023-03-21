/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_assignment;

import java.time.LocalDate;

/**
 *
 * @author KZ
 */
public class Student extends User {
    private String gender, phoneNo, NRIC;
    private LocalDate dob;

    public Student(String ID, String name, String email, String username, String password, String gender, String phoneNo, String NRIC, LocalDate dob) {
        super(ID, name, email, username, password);
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.NRIC = NRIC;
        this.dob = dob;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public void setNRIC(String nRIC) {
        NRIC = nRIC;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getNRIC() {
        return NRIC;
    }

    public LocalDate getDob() {
        return dob;
    }
}
