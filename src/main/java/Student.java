package main.java;

import java.time.LocalDate;

// class for student user
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
}
