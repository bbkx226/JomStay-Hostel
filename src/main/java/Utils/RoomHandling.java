// @author Brandon Ban Kai Xian TP067094
// @co-author They Kai Zhe TP062802
package Utils;

import Models.Application;
import Models.Room;
import Models.RoomType;
import Utils.Config.filePath;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringJoiner;

public class RoomHandling {

    private static final String PATH = filePath.ROOM_PATH.getValue();
    private static final String ROOM_TYPE_PATH = filePath.ROOMTYPE_PATH.getValue();
    public ArrayList<Room> totalRooms = getRooms();
    
    // get all the rooms from the room file
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
    
    // update the room file with the specified room arraylist
    public static void updateRoomFile(ArrayList<Room> rooms) {
        StringJoiner roomListString = new StringJoiner("\n");
        for (Room room : rooms) {
            roomListString.add(room.toString());
        }
        roomListString.add("");
        FileHandlerUtils.writeString(PATH, roomListString.toString(), false);
    }
    
    public static void deleteRoomData(ArrayList<Room> rooms, String roomID) {
        int i = 0, floor = 1;
        String roomListString = "", ID;

        for (Room room : rooms) {
            if (room.getRoomID().equals(roomID)) continue;
            i++;
            if(i % 11 == 0) {
                i = 1;
                floor += 1;
            }
            ID = "R" + String.format("%d", floor) + String.format("%02d", i);
            roomListString += String.format("%s %s %b %s\n",
                    ID, room.getStatus(),
                    room.isServicing(),
                    room.getRoomType().getTypeName()
            );
        }
        FileHandlerUtils.writeString(PATH, roomListString, false);
    }

    public static void appendRoomFile(Room room) {
        FileHandlerUtils.writeString(PATH, room.toString() + "\n", true);
    }
    
    // update a specific room in the room file with the specified room
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

    // get the first available room of the specified room type
    public static Room getFirstAvailableRoom(RoomType roomType) {
        for (Room room : getAvailableRooms()) {
            if (roomType.equals(room.getRoomType())) {
                return room;
            }
        }
        return null;
    }

    // get all room types from the room types file
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
    
    public static void refreshRoomFile() {
        LocalDate now = LocalDate.now();
        ArrayList<Application> applications = ApplicationHandling.getTotalApplications();
        ArrayList<Room> rooms = getRooms();
        Collections.reverse(applications);
        LocalDate endDate = LocalDate.of(1970, 1, 1);
        int buffer = 0;
        for (Room room : rooms) {
            for (Application application : applications) {
                if (application.getRoom().getRoomID().equals(room.getRoomID())
                && application.getLocalEndDate().isAfter(endDate)) {
                    endDate = application.getLocalEndDate();
                    buffer = applications.indexOf(application);
                }
            }
            if (now.isAfter(endDate)) {
                applications.get(buffer).getRoom().setStatus("Available");
                updateRoomInFile(applications.get(buffer).getRoom());
            }
        }
    }
}
