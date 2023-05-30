// @author Brandon Ban Kai Xian TP067094
package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Utils.Config.filePath;

public class LogHandling {
    private static final String PATH = filePath.LOG_PATH.getValue();
        
    private static String recordLog(String logEvent, String user) {
        String cases = switch (logEvent) {
            case "Register" -> "An_account_has_successfully_been_registered";
            case "User Login" -> "User_logged_in.";
            case "Admin Login" -> "Admin_logged_in.";
            case "User Logout" -> "User_logged_out.";
            case "Admin Logout" -> "Admin_logged_out.";
            case "Delete Room" -> "Room_has_successfully_been_deleted";
            case "Append Room" -> "A_new_room_has_successfully_been_added";
            case "Modify Room" -> "The_details_of_a_room_has_been_modified";
            case "Accepted" -> "The_application_has_been_accepted";
            case "Rejected" -> "The_application_has_been_rejected";
            case "Modify Student Details" -> "The_details_of_the_student_has_been_modified";
            case "Admin Log Out" -> "The_admin_has_been_signed_out.";
            case "Available Room Report" -> "Report_for_Available_Room_has_been_generated";
            case "Monthly Income Report" -> "Report_for_Monthly_Income_has_been_generated";
            case "Log Activity Report" -> "Report_for_Log_Activity_has_been_generated";
            case "User Payment" -> "A_payment_has_been_made_by_the_user";
                
            default -> "Unknown_event_occurred.";
        };
        
        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd?HH:mm");
        String dateTime = currentLocalDateTime.format(dateTimeFormatter);
        
        String log = dateTime + " " + user + " " + cases + "" + "\n";
        
        return log;
    }

    public static void writeLog(String event, String user) {
        FileHandlerUtils.writeString(PATH, recordLog(event, user), true);
    }
}

