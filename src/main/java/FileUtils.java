import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class FileUtils {

    public static ArrayList<String> readLines(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void writeLines(ArrayList<String> lines, String filePath) {
        String linesString = String.join("\n", lines);
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath))) {
            br.write(linesString);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeString(String str, String filePath) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath))) {
            br.write(str);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendLines(ArrayList<String> lines, String filePath) {
        String linesString = String.join("\n", lines);
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath, true))) {
            br.write(linesString);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendString(String str, String filePath) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath, true))) {
            br.write(str);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}