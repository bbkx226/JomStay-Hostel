// @author Brandon Ban Kai Xian TP067094
package Utils;

import Models.Room;
import Models.RoomType;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomTypeHandling {
    private static final String PATH = "src/main/java/databases/roomtypes.txt";
    public static ArrayList<RoomType> totalRooms = getRoomTypes();
    
    public static ArrayList<RoomType> getRoomTypes() {
        ArrayList<RoomType> buffer = new ArrayList<>();
        String tempBuffer = new String();

        for (String line : FileHandlerUtils.readLines(PATH)) {
            System.out.println(line);
            System.out.println("-----------------------------");
            if(!line.isEmpty()){
                String[] data = line.split(": ");
                String formattedData = data[1].replace("\n", "");
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
        for(RoomType roomType : getRoomTypes()){
            if(room.getRoomType().equals(roomType.getTypeName())) return roomType;
        }
        return null;
    }
}
