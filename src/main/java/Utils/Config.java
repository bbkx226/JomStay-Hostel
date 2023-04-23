/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author KZ
 * @co-author bbkx
 */
public final class Config {
    
    public static final String CURRRENCY = "RM";
    public static final String NOT_APPLICABLE = "N/A";
    
    public enum dateFormats {
        FILE_APPLICATION_CREATE_DATE ("yyyy-MM-dd?HH:mm"),
        FILE_APPLICATION_START_END_DATE ("yyyy-MM-dd"),
        FILE_PAYMENT_DATE ("yyyy-MM-dd"),
        DISPLAY_APPLICATION_CREATE_DATE ("yyyy-MM-dd HH:mm a"),
        DISPLAY_APPLICATION_START_END_DATE ("yyyy-MM-dd"),
        DISPLAY_PAYMENT_DATE ("yyyy-MM-dd"),
        ST_APPLICATION_DATE_INPUT ("dd-MM-yyyy"),
        PAYMENT_RENT_PERIOD ("dd/MM/yyyy");
        
        private final String format;
        
        dateFormats(String format) {
            this.format = format;
        }
        
        public String getFormat() {
            return format;
        }
        
        public DateTimeFormatter getFormatter() {
            return DateTimeFormatter.ofPattern(this.getFormat());
        }
    }
    
    public enum filePath {
        APPLICATION_PATH("Application", "src/main/java/databases/application.txt"),
        AUTHENTICATION_PATH("Authentication", "src/main/java/databases/auth.txt"),
        PAYMENT_PATH("Payment", "src/main/java/databases/payment.txt"),
        ROOM_PATH("Room", "src/main/java/databases/room.txt"),
        ROOMTYPE_PATH("Room Type", "src/main/java/databases/roomtypes.txt"),
        STUDENTDETAIL_PATH("Student Details", "src/main/java/databases/studentdetails.txt");
        
        private final String key, value;
        
        filePath(String key, String value){
            this.key = key;
            this.value = value;
        }
        
        public String getKey(){
            return key;
        }
        
        public String getValue(){
            return value;
        }
        
    }
}
