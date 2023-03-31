// @author Brandon Ban Kai Xian TP067094
package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileDataHandling {
    private static final String PATH = "src/main/java/databases/auth.txt";
    private static int count = 0, buffer = 0;
    
    // Generate new Student ID
    public static int getID() {
        File file = new File(PATH);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data[0].contains("ST")) buffer++;
            }
            reader.close();
        } catch(IOException e){
           PopUpWindow.showErrorMessage("Error reading from file", "Error");
        }
        count = buffer;
        buffer = 0;
        return count;
    }
    
    // Format name to remove spaces
    public static String nameWithSpaces(String name){
        return name.replaceAll("\\s", "_");
    }
    
    // Check if username or email already exists
    public static boolean validateData(String username, String email){
        File file = new File(PATH);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (email.equals(data[2]) || username.equals(data[3])) return false;
            }
            reader.close();
        } catch(IOException e){
            PopUpWindow.showErrorMessage("Error reading from file", "Error");
        }
        return true;
    }
    
    // Update login time of user
    public static void updateLoginTime(String ID){
        File file = new File(PATH);
        String content = "";
        FileWriter writer;     
        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd?HH:mm");
        String dateTime = currentLocalDateTime.format(dateTimeFormatter);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){ 
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (ID.equals(data[0])) line = line.replace(data[5], dateTime);
                content += line + System.lineSeparator();    
            }
            writer = new FileWriter(file);
            writer.write(content);
            reader.close();
            writer.close();
        } catch(IOException e){
            PopUpWindow.showErrorMessage("Error reading from file", "Error");
        }
    }
}
