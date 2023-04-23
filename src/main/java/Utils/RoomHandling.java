// @author They Kai Zhe TP062802
// @co-author Brandon Ban Kai Xian TP067094
package Utils;

import Models.Room;
import Models.RoomType;
import Utils.Config.filePath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class RoomHandling {

    private static final String PATH = filePath.ROOM_PATH.getValue();
    private static final String ROOM_TYPE_PATH = filePath.ROOMTYPE_PATH.getValue();
    public ArrayList<Room> totalRooms = getRooms();

    public static ArrayList<Room> getRooms() {
        ArrayList<Room> buffer = new ArrayList<>();
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            RoomType roomType = compareToRoomType(data[3]);
            Room room = new Room(data[0], data[1], Boolean.parseBoolean(data[2]), roomType);
            buffer.add(room);
        }
        return buffer;
    }

    public static void updateRoomFile(ArrayList<Room> rooms) {
        StringJoiner roomListString = new StringJoiner("\n");
        for (Room room : rooms) {
            roomListString.add(room.toString());
        }
        FileHandlerUtils.writeString(PATH, roomListString.toString(), false);
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
                    room.getRoomType().getTypeName()
            );
            i++;
        }
        FileHandlerUtils.writeString(PATH, roomListString, false);
    }

    public static void appendRoomFile(Room room) {
        FileHandlerUtils.writeString(PATH, room.toString() + "\n", true);
    }
    
    public static void updateRoomInFile(Room room) {
        ArrayList<String> lines = FileHandlerUtils.readLines(PATH);
        for (String line : lines) {
            if (line.split(" ")[0].equals(room.getRoomID())) {
                lines.set(lines.indexOf(line), room.toString());
            }
        }
        String result = String.join("\n", lines);
        FileHandlerUtils.writeString(PATH, result, false);
    }

    // Get available rooms
    public static ArrayList<Room> getAvailableRooms() {
        ArrayList<Room> buffer = new ArrayList<>();
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            if (data[1].equals("Available")) {
                RoomType roomType = compareToRoomType(data[3]);
                Room room = new Room(data[0], data[1], Boolean.parseBoolean(data[2]), roomType);
                buffer.add(room);
            }
        }
        return buffer;
    }

    public static Room getFirstAvailableRoom(RoomType roomType) {
        for (Room room : getAvailableRooms()) {
            if (roomType.equals(room.getRoomType())) {
                return room;
            }
        }
        return null;
    }

    public static ArrayList<RoomType> getRoomTypes() {
        ArrayList<RoomType> buffer = new ArrayList<>();
        String tempBuffer = new String();

        for (String line : FileHandlerUtils.readLines(ROOM_TYPE_PATH)) {
            if (!line.isEmpty()) {
                String[] data = line.split(": ");
                String formattedData = data[1].trim();
                tempBuffer += formattedData + " ";
            } else {
                String[] finalData = tempBuffer.split(" ");
                RoomType roomType = new RoomType(finalData[0], Integer.parseInt(finalData[1]), finalData[2], Double.parseDouble(finalData[3]), finalData[4], Boolean.parseBoolean(finalData[5]));
                buffer.add(roomType);
                tempBuffer = "";
                Arrays.fill(finalData, "");
            }
        }
        return buffer;
    }

    public static RoomType matchRoom(Room room) {
        for (RoomType roomType : getRoomTypes()) {
            if (room.getRoomType().getTypeName().equals(roomType.getTypeName())) {
                return roomType;
            }
        }
        return null;
    }

    public static RoomType compareToRoomType(String typeName) {
        for (RoomType roomType : getRoomTypes()) {
            if (typeName.equals(roomType.getTypeName())) {
                return roomType;
            }
        }
        return null;
    }
    
    public static String getRoomFloor(Room room) {
        char checkFloor = room.getRoomID().charAt(1);
        switch(checkFloor) {
            case '1' -> {
                return "1st Floor";
            }
            case '2' -> {
                return "2nd Floor";
            }
            case '3' -> {
                return "3rd Floor";
            }
            default -> {
                return "Floor not found";
            }
        }
    }
}
