// @author Brandon Ban Kai Xian TP067094
package Utils;

import Models.Room;
import java.util.ArrayList;

public class RoomHandling {
    private static final String PATH = "src/main/java/databases/room.txt";
    public ArrayList<Room> totalRooms = getRooms();
    
    public static ArrayList<Room> getRooms() {
        ArrayList<Room> buffer = new ArrayList<>();
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            Room room = new Room(data[0], data[1], Boolean.parseBoolean(data[2]), data[3]);
            buffer.add(room);
        }
        return buffer;
    }
    
    public static void updateRoomFile(ArrayList<Room> rooms) {
        String roomListString = "";
        for (Room room : rooms) roomListString += room.toString();
        FileHandlerUtils.writeString(PATH, roomListString, false);
    }
    
    public static void deleteRoomData(ArrayList<Room> rooms, String roomID) {
        int i = 1;
        String roomListString = "";
        for (Room room : rooms) {
            if (room.getRoomID().equals(roomID)) {
                continue;
            }
            roomListString += String.format("R%03d %s %b %s\n", 
                                            i, room.getStatus(), 
                                            room.isServicing(),
                                            room.getRoomType()
                                            );
            i++;
        }
        FileHandlerUtils.writeString(PATH, roomListString, false);
    }
    
    public static void appendRoomFile(Room room) {
        FileHandlerUtils.writeString(PATH, room.toString(), true);
    }
    
    // Get available rooms
    public static ArrayList<Room> getAvailableRooms() {
        ArrayList<Room> buffer = new ArrayList<>();
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            if (data[1].equals("Available")) {
                Room room = new Room(data[0], data[1], Boolean.parseBoolean(data[2]), data[3]);
                buffer.add(room);
            }
        }
        return buffer;
    }
}
