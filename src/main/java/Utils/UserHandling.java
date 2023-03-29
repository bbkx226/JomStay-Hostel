/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bbkx2
 */
public class StudentHandling {
    private static final String PATH = "src/main/java/databases/auth.txt";
    public ArrayList<Student> totalStudents = getStudents();
      
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
}
