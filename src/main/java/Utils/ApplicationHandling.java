// @author Brandon Ban Kai Xian TP067094
package Utils;

import Models.Application;
import Models.Room;
import Models.Student;
import java.time.LocalDate;
import java.util.ArrayList;

public class ApplicationHandling {
    private static final String PATH = "src/main/java/databases/application.txt";
    
    private static final ArrayList<Room> totalRooms = RoomHandling.getRooms();
    private static final ArrayList<Student> totalStudents = UserHandling.getStudents();   
    public ArrayList<Application> totalApplications = getTotalApplications();
    public ArrayList<Application> pendingApplications = getPendingApplications();
    
    public static ArrayList<Application> getTotalApplications() {
        ArrayList<Application> buffer = new ArrayList<>();
        
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            Student student = compareToStudent(data[1]);
            Room room = compareToRoom(data[2]);
            if (student != null && room != null) {
                Application application = new Application(data[0], student, room, data[3], data[4], data[5], data[6]);
                buffer.add(application);
            }
        }
        return buffer;
    }
    
    public static void updateApplicationFile(ArrayList<Application> applications) {
        String applicationListString = "";
        for (Application application : applications) {
            applicationListString += application.toString();
        }
        FileHandlerUtils.writeString(PATH, applicationListString, false);
    }
    
    // Format date to remove spaces
    public static String checkAndModifyDate(String date) {
        String result = "";
        String[] data = date.split("\\?");
        String[] time = data[1].split(":");
        if(Integer.parseInt(time[0]) >= 12) return result + data[0] + " " + time[0] + ":" + time[1] + "PM";
        else return result + data[0] + " " + time[0] + ":" + time[1] + "AM";
    }
    
    // Return pending applications
    public static ArrayList<Application> getPendingApplications(){
        ArrayList<Application> total = getTotalApplications();
        ArrayList<Application> buffer = new ArrayList<>();
        try{
            for(Application application : total){
                if(application.getStatus().equals("Pending")) buffer.add(application);
            }
        } catch(Exception e){
            PopUpWindow.showErrorMessage("There are no pending applications", "Error 404");
        }
        return buffer;
    }
    
    // Return Particular Student Object 
    private static Student compareToStudent(String studentID){
        for (Student student : totalStudents)
            if(studentID.equals(student.getID())) return student;
        return null;
    }
    
    // Return Particular Room Object
    private static Room compareToRoom(String roomID){
        for (Room room : totalRooms)
            if(roomID.equals(room.getRoomID())) return room;
        return null;
    }
    
    public static void addNewApplication(Application application) {
        FileHandlerUtils.writeString(PATH, application.toString(), true);
    }
    
    public static Application getStudentApplication(Student student) {
        Application buffer = new Application("N/A", student, null, "N/A", "N/A", "N/A", "N/A");
        ArrayList<Application> applications = new ArrayList<>();
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            LocalDate endDate = LocalDate.parse(data[6], Config.dateFormats.FILE_APPLICATION_START_END_DATE.getFormatter());
            if (LocalDate.now().isAfter(endDate)) {
                continue;
            }
            if (student.getID().equals(data[1])) {
                Room room = compareToRoom(data[2]);
                applications.add(new Application(data[0], student, room, data[3], data[4], data[5], data[6]));
            }
        }
        if (! applications.isEmpty()) {
            for (Application application : applications) {
                buffer = application;
            }
        }
        return buffer;
    }
}
