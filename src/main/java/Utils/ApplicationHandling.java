// @author Brandon Ban Kai Xian TP067094
package Utils;

import Models.Application;
import Models.Room;
import Models.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ApplicationHandling {
    private static final String PATH = "src/main/java/databases/application.txt";
    
    private final ArrayList<Room> totalRooms = new RoomHandling().getRooms();
    private final ArrayList<Student> totalStudents = new UserHandling().getStudents();    
    public ArrayList<Application> totalApplications = getTotalApplications();
    public ArrayList<Application> pendingApplications = getPendingApplications();
    
    private ArrayList<Application> getTotalApplications(){
        ArrayList<Application> buffer = new ArrayList<>();
        
        File file = new File(PATH);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                Student student = compareToStudent(data[1]);
                Room room = compareToRoom(data[2]);
                if(student != null && room != null){
                    Application application = new Application(data[0], student, room, data[3], data[4], data[5], data[6]);
                    buffer.add(application);
                }
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return buffer;
    }
    
    public static void updateApplicationFile(ArrayList<Application> applications){
        File file = new File(PATH);
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(file, false))){
            printWriter.flush();
            for (Application application : applications){
                printWriter.append(String.format("%s %s %s %s %s %s %s\n", application.getApplicationID(), application.getStudent().getID(), application.getRoom().getRoomID(), application.getStatus(), application.getCreateDate(), application.getStartDate(), application.getEndDate()));
            }
            printWriter.close();
        } catch(IOException e){
            e.printStackTrace();        
        }
    }
    
    public static String checkAndModifyDate(String date){
        String result = "";
        String[] data = date.split("\\?");
        String[] time = data[1].split(":");
        if(Integer.parseInt(time[0]) >= 12){
            return result + data[0] + " " + time[0] + ":" + time[1] + "PM";
        } else {
            return result + data[0] + " " + time[0] + ":" + time[1] + "AM";            
        }
    }
    
    private ArrayList<Application> getPendingApplications(){
        ArrayList<Application> total = getTotalApplications();
        ArrayList<Application> buffer = new ArrayList<>();
        try{
            for(Application application : total){
                if(application.getStatus().equals("Pending")){
                    buffer.add(application);
                }
            }
        } catch(Exception e){
            e.printStackTrace();  
        }
        return buffer;
    }
    
    private Student compareToStudent(String studentID){
        for (Student student : totalStudents){
            if(studentID.equals(student.getID())){
                return student;
            }
        }
        return null;
    }
    
    private Room compareToRoom(String roomID){
        for (Room room : totalRooms){
            if(roomID.equals(room.getRoomID())){
                return room;
            }
        }
        return null;
    }
}
