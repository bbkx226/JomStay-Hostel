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
public final class StudentHandling {
    private static final String PATH = "src/main/java/databases/auth.txt";
    private static final String STUDENTDETAILSPATH = "src/main/java/databases/studentdetails.txt";
    
    public static ArrayList<Student> getStudents() {
        ArrayList<Student> buffer = new ArrayList<>();
        boolean flag = false;
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            if (data[0].startsWith("ST")) {
                Student student = new Student(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                for (String sLine : FileHandlerUtils.readLines(STUDENTDETAILSPATH)) {
                    String[] sData = sLine.split(" ");
                    if (flag) {
                        flag = false;
                        break;
                    }
                    if (sData[0].equals(student.getID())) {
                        student.setNationality(sData[1]);
                        student.setRace(sData[2]);
                        student.setReligion(sData[3]);
                        student.setPermanentAddress(sData[4]);
                        student.setMedicalCondition(sData[5]);
                        student.setEmerContactName(sData[6]);
                        student.setEmerContactRelationship(sData[7]);
                        student.setEmerContactNo(sData[8]);
                        buffer.add(student);
                        flag = true;
                    }
                }
            }
        }
        return buffer;
    }
}
