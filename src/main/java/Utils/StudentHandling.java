/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.Student;
import java.util.ArrayList;

/**
 *
 * @author bbkx2
 */
public class StudentHandling {
    private static final String PATH = "src/main/java/databases/auth.txt";
    public ArrayList<Student> totalStudents = getStudents();
    
    private ArrayList<Student> getStudents() {
        ArrayList<Student> buffer = new ArrayList<>();
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            if (data[0].startsWith("ST")) {
                Student student = new Student(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                buffer.add(student);
            }
        }
        return buffer;
    }
}
