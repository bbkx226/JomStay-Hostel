/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.Admin;
import Models.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author bbkx2
 */
public class UserHandling {
    private static final String PATH = "src/main/java/databases/auth.txt";
    public ArrayList<Student> totalStudents = getStudents();
    public ArrayList<Admin> totalAdmins = getAdmins();  
    
    private ArrayList<Student> getStudents(){
        ArrayList<Student> buffer = new ArrayList<>();
        
        File file = new File(PATH);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if(data[0].contains("ST")){
                    Student student = new Student(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                    buffer.add(student);  
                }
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return buffer;
    }
    
    private static ArrayList<Admin> getAdmins(){
        ArrayList<Admin> buffer = new ArrayList<>();
        
        File file = new File(PATH);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if(data[0].contains("AD")){
                    Admin admin = new Admin(data[0], data[1], data[2], data[3], data[4]);
                    buffer.add(admin);  
                }
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return buffer;
    }
    
    public static void updateStudentFile(ArrayList<Student> students){
        File file = new File(PATH);
        ArrayList<Admin> admins = getAdmins();
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(file, false))){
            printWriter.flush();
            for (Admin admin : admins) {
                printWriter.append(String.format("%s %s %s %s %s \n", admin.getID(), admin.getName(),admin.getEmail(), admin.getUsername(), admin.getPassword()));
            }
            for (Student student : students){
                printWriter.append(String.format("%s %s %s %s %s %s %s %s %s\n", student.getID(), student.getName(), student.getEmail(), student.getUsername(), student.getGender(), student.getLoginDate(), student.getPassword(), student.getPhoneNo(), student.getNRIC()));
            }
            printWriter.close();
        } catch(IOException e){
            e.printStackTrace();        
        }
    }
}
