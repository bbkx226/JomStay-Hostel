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
    private static String PATH = "src/main/java/databases/room.txt";
    
    private static ArrayList<String> getRoomTypes() {
        ArrayList<String> buffer = new ArrayList<>();
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String roomString = "";
            if (line.isEmpty()) {
                buffer.add(roomString);
                roomString = "";
            } else {
                roomString += line + "\n";
                roomString = "";
            }
        }
        System.out.println(buffer);
        return buffer;
    }
}
