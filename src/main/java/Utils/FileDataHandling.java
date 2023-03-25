package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author bbkx2
 */
public class FileDataHandling {
    private static final String PATH = "src/main/java/databases/auth.txt";
    private static int count = 0;
    
    public static int getID() {
        File file = new File(PATH);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(" ");
                if (data[0].contains("ST")) {
                    count++;
                }
                line = reader.readLine();
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
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(" ");
                if (data[0].contains("ST")) {
                    System.out.println(username + " " + email + " " + data[3] + " " + data[4]);
                    if(email.equals(data[2])){
                        return false;
                    }
                    if(username.equals(data[3])){
                        return false;
                    }
                }
                line = reader.readLine();
        }
        reader.close();
        } catch(IOException e){
           e.printStackTrace();
        }
        return true;
    }
}
