package Utils;

import Models.Room;
import java.util.ArrayList;

public class RoomHandling {
    private static final String PATH = "src/main/java/databases/room.txt";
    public ArrayList<Room> totalRooms = getRooms();
    
    private ArrayList<Room> getRooms() {
        ArrayList<Room> buffer = new ArrayList<>();
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            Room room = new Room(data[0], data[1], Boolean.parseBoolean(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
            buffer.add(room);
        }
        return buffer;
    }
    
    public static void updateRoomFile(ArrayList<Room> rooms) {
        String roomListString = "";
        for (Room room : rooms) {
            roomListString += room.toString();
        }
        FileHandlerUtils.writeString(PATH, roomListString, false);
    }
    
    public static void deleteRoomData(ArrayList<Room> rooms, String roomID) {
        int i = 1;
        String roomListString = "";
        for (Room room : rooms) {
            if (room.getRoomID().equals(roomID)) {
                continue;
            }
            roomListString += String.format("R%03d %s %b %d %d\n", 
                                            i, room.getStatus(), 
                                            room.isServicing(), room.getPax(), 
                                            room.getPricePerPax());
        }
        FileHandlerUtils.writeString(PATH, roomListString, false);
    }
    
    public static void appendRoomFile(Room room) {
        FileHandlerUtils.writeString(PATH, room.toString(), true);
    }
}
