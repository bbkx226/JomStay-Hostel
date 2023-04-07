/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.ArrayList;

/**
 *
 * @author KZ
 */
public final class RoomTypeHandling {
    private static final String PATH = "src/main/java/databases/roomtypes.txt";
    
    public static ArrayList<String> getRoomTypes() {
        ArrayList<String> buffer = new ArrayList<>();
        String roomString = "";
        for (String line : FileHandlerUtils.readLines(PATH)) {
            if (line.isEmpty()) {
                buffer.add(roomString);
                roomString = "";
            } else {
                roomString += line + "\n";
            }
        }
        return buffer;
    }
}
