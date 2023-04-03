/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author KZ
 */
public class Payment {
    private static DateTimeFormatter formatter;
    
    private static Application application;
    private static boolean paymentStatus;
    private static float amount;
    private static String paymentID, method;
    private static LocalDateTime date;

    public Payment(String paymentID, Application application, boolean paymentStatus, float amount, String method, LocalDateTime date) {
        Payment.paymentID = paymentID;
        Payment.application = application;
        Payment.paymentStatus = paymentStatus;
        Payment.amount = amount;
        Payment.method = method;
        Payment.date = date;
    }

    public static void setPaymentID(String paymentID) {
        Payment.paymentID = paymentID;
    }
    
    public static void setApplication(Application application) {
        Payment.application = application;
    }

    public static void setPaymentStatus(boolean paymentStatus) {
        Payment.paymentStatus = paymentStatus;
    }

    public static void setAmount(float amount) {
        Payment.amount = amount;
    }

    public static void setMethod(String method) {
        Payment.method = method;
    }

    public static void setDate(LocalDateTime date) {
        Payment.date = date;
    }

    public static void setDateString(String date, String format) {
        formatter = DateTimeFormatter.ofPattern(format);
        Payment.date = LocalDateTime.parse(date, formatter);
    }
    
    public static String getPaymentID() {
        return paymentID;
    }
    
    public static Application getApplication() {
        return application;
    }

    public static boolean getPaymentStatus() {
        return paymentStatus;
    }

    public static float getAmount() {
        return amount;
    }

    public static String getMethod() {
        return method;
    }

    public static LocalDateTime getDate() {
        return date;
    }
    
    public static String getDateString(String format) {
        formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    @Override
    public String toString() {
        return String.format("%s %s %b %.2f %s %s\n", paymentID, application.getApplicationID(), paymentStatus, amount, method, Payment.getDateString("yyyy-MM-dd?HH:mm"));
    }
    
}
