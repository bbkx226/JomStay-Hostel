// @author Brandon Ban Kai Xian TP067094
package Utils;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileDataHandling {
    private static final String PATH = "src/main/java/databases/auth.txt";
    private static int count = 0, buffer = 0;
    
    public static int getID() {
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            if (data[0].contains("ST")) {
                buffer++;
            }
        }
        count = buffer;
        buffer = 0;
        return count;
    }
    
    // Format name to remove spaces
    public static String nameWithSpaces(String name){
        return name.replaceAll("\\s", "_");
    }
    
    public static boolean validateData(String username, String email) {
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            if (email.equals(data[2]) || username.equals(data[3])) {
                return false;
            }
        }
        return true;
    }
    
    // Update login time of user
    public static void updateLoginTime(String ID){
        String content = "";
        FileWriter writer;
        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd?HH:mm");
        String dateTime = currentLocalDateTime.format(dateTimeFormatter);
        
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String data[] = line.split(" ");
            if (ID.equals(data[0])) {
                line = line.replace(data[5], dateTime);
            }
            content += line + System.lineSeparator();
        }
        FileHandlerUtils.writeString(PATH, content, false);
    }
    
}
