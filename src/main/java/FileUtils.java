package main.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


// A utility class for reading and writing files
public final class FileUtils {

    public static ArrayList<String> readLines(String filePath) {
        /**
        Reads the lines from the specified file and returns them as an ArrayList of strings.
        @param filePath the path of the file to be read
        @return an ArrayList of strings containing the lines from the file
        @throws IOException if there is an error while reading the file
        */
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
        /**
        Writes the specified ArrayList of strings to the specified file.
        @param lines an ArrayList of strings containing the lines to be written to the file
        @param filePath the path of the file to write to
        @throws IOException if there is an error while writing to the file
        */
        String linesString = String.join("\n", lines);
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath))) {
            br.write(linesString);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeString(String str, String filePath) {
        /**
        Writes the specified string to the specified file.
        @param str the string to be written to the file
        @param filePath the path of the file to write to
        @throws IOException if there is an error while writing to the file
        */
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath))) {
            br.write(str);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendLines(ArrayList<String> lines, String filePath) {
        /**
        Appends the specified ArrayList of strings to the end of the specified file.
        @param lines an ArrayList of strings containing the lines to be appended to the file
        @param filePath the path of the file to append to
        @throws IOException if there is an error while appending to the file
        */
        String linesString = String.join("\n", lines);
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath, true))) {
            br.write(linesString);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendString(String str, String filePath) {
        /**
        Appends the specified string to the end of the specified file.
        @param str the string to be appended to the file
        @param filePath the path of the file to append to
        @throws IOException if there is an error while appending to the file
        */
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath, true))) {
            br.write(str);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}