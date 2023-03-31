package Utils;

import Models.Room;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RoomHandling {
    private static final String PATH = "src/main/java/databases/room.txt";

    // Read from file room.txt
    public ArrayList<Room> getRooms(){
        ArrayList<Room> roomList = new ArrayList<>();
        File file = new File(PATH);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                Room room = new Room(data[0], data[1], Boolean.parseBoolean(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
                roomList.add(room);
            }
            reader.close();
        } catch (IOException e){
            PopUpWindow.showErrorMessage("Error reading from file", "Error 404");
        }
        return roomList;
    }
    
    // Write to file room.txt
    public static void updateRoomFile(ArrayList<Room> rooms){
        File file = new File(PATH); // create a new file with the path provided
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(file, false))){ // create a new PrintWriter object to write to the file
            printWriter.flush(); // clear the file
            for (Room room : rooms) printWriter.append(String.format("%s %s %b %d %d\n", room.getRoomID(), room.getStatus(), room.isServicing(), room.getPax(), room.getPricePerPax()));
            printWriter.close(); // close the PrintWriter
        } catch(IOException e){
            PopUpWindow.showErrorMessage("Error writing to file", "Error 404"); 
        }
    }
    
    // Delete room from file room.txt
    public static void deleteRoomData(ArrayList<Room> rooms, String roomID){
        int i = 1;
        File file = new File(PATH);
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(file, false))){
            printWriter.flush();
            for (Room room : rooms){
                if(room.getRoomID().equals(roomID)) continue;
                printWriter.append(String.format("R%03d %s %b %d %d\n", i, room.getStatus(), room.isServicing(), room.getPax(), room.getPricePerPax()));
                i++;
            }
            printWriter.close();
        } catch(IOException e){
            PopUpWindow.showErrorMessage("Error writing to file", "Error 404");        
        }
    }
    
    // Append room to file room.txt
    public static void appendRoomFile(ArrayList<Room> rooms){
        File file = new File(PATH);
        Room room = rooms.get(rooms.size()-1);
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(file, true))){
            printWriter.append(String.format("%s %s %b %d %d\n", room.getRoomID(), room.getStatus(), room.isServicing(), room.getPax(), room.getPricePerPax()));
            printWriter.close();
        } catch(IOException e){
            PopUpWindow.showErrorMessage("Error writing to file", "Error 404");          
        }    
    }
    
    // Get available rooms
    public static ArrayList<Room> getAvailableRooms(){
        ArrayList<Room> buffer = new ArrayList<>();
        
        File file = new File(PATH);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if(data[1].equals("Available")){
                    Room room = new Room(data[0], data[1], Boolean.parseBoolean(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
                    buffer.add(room); 
                }
            }
            reader.close();
        } catch (IOException e){
            PopUpWindow.showErrorMessage("Error reading from file", "Error 404");
        }
        return buffer;
    }
}
