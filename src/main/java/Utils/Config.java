/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author KZ
 */
public final class Config {
    
    public static final String CURRRENCY = "RM";
    public static final String NOT_APPLICABLE = "N/A";
    
    public enum dateFormats {
        FILE_APPLICATION_CREATE_DATE ("yyyy-MM-dd?HH:mm"),
        FILE_APPLICATION_START_DATE ("yyyy-MM-dd?HH:mm"),
        FILE_APPLICATION_END_DATE ("yyyy-MM-dd?HH:mm"),
        FILE_PAYMENT_DATE ("yyyy-MM-dd"),
        DISPLAY_APPLICATION_CREATE_DATE ("yyyy-MM-dd HH:mm a"),
        DISPLAY_APPLICATION_START_DATE ("yyyy-MM-dd HH:mm a"),
        DISPLAY_APPLICATION_END_DATE ("yyyy-MM-dd HH:mm a"),
        DISPLAY_PAYMENT_DATE ("yyyy-MM-dd");
        
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
    
}
