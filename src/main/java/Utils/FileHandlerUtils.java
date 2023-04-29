package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author KZ
 */
// utility class that handles file reading and writing
public final class FileHandlerUtils {

    // reading lines from file
    public static ArrayList<String> readLines(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line = reader.readLine();
                while (line != null) {
                    lines.add(line);
                    line = reader.readLine();
                }
        } catch (IOException e) {
            PopUpWindow.showErrorMessage(filePath + " could not be found.", "File not found");
        }
        return lines;
    }

    // writing string into file, can be in append or write modeds
    public static void writeString(String filePath, String str, boolean append) {
        try (FileWriter writer = new FileWriter(filePath, append)){
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            PopUpWindow.showErrorMessage(filePath + " could not be found.", "File not found");
        }
    }
}
