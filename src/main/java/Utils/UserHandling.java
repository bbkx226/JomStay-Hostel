// @author Brandon Ban Kai Xian TP067094
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

public class UserHandling {
    private static final String PATH = "src/main/java/databases/auth.txt";
    private static final String STUDENT_DETAILS_PATH = "src/main/java/databases/studentdetails.txt";

    // Returns an ArrayList of Student objects from the database
    public static ArrayList<Student> getStudents() {
        ArrayList<Student> buffer = new ArrayList<>();
        boolean flag = false;
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            if (data[0].startsWith("ST")) {
                Student student = new Student(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                for (String sLine : FileHandlerUtils.readLines(STUDENT_DETAILS_PATH)) {
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

    // Returns an ArrayList of Admin objects from the database
    public static ArrayList<Admin> getAdmins(){
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
            PopUpWindow.showErrorMessage("Error reading from file", "Error");
        }
        return buffer;
    }

    //Takes in an ArrayList of students and writes the new student data to the students file
    public static void updateStudentFile(ArrayList<Student> students){
        //creates a new file object
        File file = new File(PATH);
        //gets the admin arraylist
        ArrayList<Admin> admins = getAdmins();
        //try with resources, opens a printwriter on the file
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(file, false))){
            //flushes the file
            printWriter.flush();
            //for each admin in the admin arraylist, writes the admin details to the file
            for (Admin admin : admins) printWriter.append(String.format("%s %s %s %s %s \n", admin.getID(), admin.getName(),admin.getEmail(), admin.getUsername(), admin.getPassword()));
            //for each student in the student arraylist, writes the student details to the file
            for (Student student : students) printWriter.append(String.format("%s %s %s %s %s %s %s %s %s\n", student.getID(), student.getName(), student.getEmail(), student.getUsername(), student.getGender(), student.getLoginDate(), student.getPassword(), student.getPhoneNo(), student.getNRIC()));
            //closes the printwriter
            printWriter.close();
        } catch(IOException e){
            //if the printwriter throws an IOException, shows an error message
            PopUpWindow.showErrorMessage("Error writing to file", "Error");
        }
    }
    
    public static void updateStudentDetail(Student student) {
        StringBuilder lineToWrite = new StringBuilder();
        lineToWrite.append(student.getNationality()).append(" ");
        lineToWrite.append(student.getRace()).append(" ");
        lineToWrite.append(student.getReligion()).append(" ");
        lineToWrite.append(student.getPermanentAddress()).append(" ");
        lineToWrite.append(student.getMedicalCondition()).append(" ");
        lineToWrite.append(student.getEmerContactName()).append(" ");
        lineToWrite.append(student.getEmerContactRelationship()).append(" ");
        lineToWrite.append(student.getEmerContactNo()).append("\n");
        
        String ID = student.getID();
        int index = Integer.parseInt(ID.substring(ID.length() - 3)) - 1;
        
        ArrayList<String> lines = FileHandlerUtils.readLines(STUDENT_DETAILS_PATH);
        lines.set(index, lineToWrite.toString());
        
        String result = String.join("\n", lines);
        
        FileHandlerUtils.writeString(STUDENT_DETAILS_PATH, result, false);
    }
}
