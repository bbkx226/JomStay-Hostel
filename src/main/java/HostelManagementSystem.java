package main.java;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// main class
public class HostelManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Admin> admins = new ArrayList<>();

    private static void initUsers() {
        /**
        Reads user information from a text file and initializes the corresponding Admin and Student objects.
        The method expects the text file to be formatted in the following order: ID, name, email, username, password, gender, phone number, NRIC, date of birth (yyyyMMdd format).
        If the ID starts with "AD", an Admin object is created and added to the admins ArrayList.
        Otherwise, a Student object is created and added to the students ArrayList.
        @throws ParseException if there is an error parsing the date of birth from the text file
        */
        ArrayList<String> lines = FileUtils.readLines("Users.txt");
        for (String line : lines) {
            String[] lineArr = line.split(" ");
            String ID = lineArr[0];
            String name = lineArr[1];
            String email = lineArr[2];
            String username = lineArr[3];
            String password = lineArr[4];
            if (ID.startsWith("AD")) {
                Admin admin = new Admin(ID, name, email, username, password);
                admins.add(admin);
            } else {
                String gender = lineArr[5];
                String phoneNo = lineArr[6];
                String NRIC = lineArr[7];
                String dobString = lineArr[8];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                LocalDate dob = null;
                try {
                    dob = LocalDate.parse(dobString, formatter);
                } catch (DateTimeParseException e) {
                    e.printStackTrace();
                }
                Student student = new Student(ID, name, email, username, password, gender, phoneNo, NRIC, dob);
                students.add(student);
            }
        }
    }

    public static void main(String[] args) {
        initUsers();
    }
}