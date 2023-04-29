// @author Brandon Ban Kai Xian TP067094
// @co-author They Kai Zhe TP062802
package Utils;

import Models.Admin;
import Models.Student;
import Utils.Config.filePath;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserHandling {
    private static final String PATH = filePath.AUTHENTICATION_PATH.getValue();
    private static final String STUDENT_DETAILS_PATH = filePath.STUDENTDETAIL_PATH.getValue();

    // Returns an ArrayList of Student objects from the database
    public static ArrayList<Student> getStudents() {
        ArrayList<Student> buffer = new ArrayList<>();
        
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            
            if (data[0].startsWith("ST")) {
                Student student = new Student(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                setStudentDetails(student);
                buffer.add(student);
            }
        }
        return buffer;
    }
    
    // Sets the extra student details of the specified student from the student details file and returns the student object
    private static Student setStudentDetails(Student student) {
        String ID = student.getID();
        int numDigits = ID.substring(2).length();
        int index = Integer.parseInt(ID.substring(ID.length() - numDigits)) - 1;
        
        String[] data = FileHandlerUtils.readLines(STUDENT_DETAILS_PATH).get(index).split(" ");
        student.setNationality(data[1]);
        student.setRace(data[2]);
        student.setReligion(data[3]);
        student.setPermanentAddress(data[4]);
        student.setMedicalCondition(data[5]);
        student.setEmerContactName(data[6]);
        student.setEmerContactRelationship(data[7]);
        student.setEmerContactNo(data[8]);
        return student;
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
    
    public static void addNewEmptyStudentDetail(String studentID) {
        String stringToWrite = studentID + " ";
        for (int i = 0; i < 8; i++) {
            stringToWrite += Config.NOT_APPLICABLE + " ";
        }
        stringToWrite += "\n";
        FileHandlerUtils.writeString(STUDENT_DETAILS_PATH, stringToWrite, true);
    }
    
    public static void updateStudentDetail(Student student) {
        String ID = student.getID();
        StringBuilder lineToWrite = new StringBuilder();
        lineToWrite.append(ID).append(" ");
        lineToWrite.append(student.getNationality().replace(" ", "_")).append(" ");
        lineToWrite.append(student.getRace().replace(" ", "_")).append(" ");
        lineToWrite.append(student.getReligion().replace(" ", "_")).append(" ");
        lineToWrite.append(student.getPermanentAddress().replace(" ", "_")).append(" ");
        lineToWrite.append(student.getMedicalCondition().replace(" ", "_")).append(" ");
        lineToWrite.append(student.getEmerContactName().replace(" ", "_")).append(" ");
        lineToWrite.append(student.getEmerContactRelationship().replace(" ", "_")).append(" ");
        lineToWrite.append(student.getEmerContactNo());

        int index = Integer.parseInt(ID.substring(ID.length() - 3)) - 1;
        
        ArrayList<String> lines = FileHandlerUtils.readLines(STUDENT_DETAILS_PATH);
        lines.set(index, lineToWrite.toString());
        
        String result = String.join("\n", lines) + "\n";
        
        FileHandlerUtils.writeString(STUDENT_DETAILS_PATH, result, false);
    }
}
