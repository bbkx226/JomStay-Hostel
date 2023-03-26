package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author bbkx2
 */
public class FileDataHandling {
    private static final String PATH = "src/main/java/databases/auth.txt";
    private static int count = 0;
    
    public static int getID() {
        File file = new File(PATH);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data[0].contains("ST")) {
                    count++;
                }
            }
            reader.close();
        } catch(IOException e){
           e.printStackTrace();
        }
        return count;
    }
    
    public static String nameWithSpaces(String name){
        return name.replaceAll("\\s", "_");
    }
    
    public static boolean validateData(String username, String email){
        File file = new File(PATH);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                System.out.println(email + " " + username + " " + data[2] + " " + data[3]);
                if (email.equals(data[2]) || username.equals(data[3])) {
                    return false;
                }
            }
            reader.close();
        } catch(IOException e){
           e.printStackTrace();
        }
        return true;
    }
    
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
                if (ID.equals(data[0])) {
                    line = line.replace(data[5], dateTime);
                }
                content += line + System.lineSeparator();    
            }
            writer = new FileWriter(file);
            writer.write(content);
            reader.close();
            writer.close();
        } catch(IOException e){
           e.printStackTrace();
        }
    }
}
