/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.Application;
import Models.Payment;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author KZ
 */
public class PaymentHandling {
    private static final String PATH = "src/main/java/databases/payment.txt";
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd?HH:mm");
    
    private static ArrayList<Application> totalApplications = new ApplicationHandling().totalApplications;
    private static ArrayList<Payment> totalPayments = getTotalPayments();
    
    private static ArrayList<Payment> getTotalPayments() {
        ArrayList<Payment> buffer = new ArrayList<>();
        
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            Application application = compareToApplication(data[1]);
            boolean status = Boolean.parseBoolean(data[2]);
            float amount = Float.parseFloat(data[3]);
            LocalDateTime date = LocalDateTime.parse(data[5], formatter);
            if (application != null) {
                Payment payment = new Payment(data[0], application, status, amount, data[4], date);
                buffer.add(payment);
            }
        }
        return buffer;
    }
    
    public static void updatePaymentFile(ArrayList<Payment> payments) {
        String paymentListString = "";
        for (Payment payment : payments) {
            paymentListString += payment.toString();
        }
        FileHandlerUtils.writeString(PATH, paymentListString, false);
    }
    
    private static Application compareToApplication(String applicationID) {
        for (Application application : totalApplications){
            if(applicationID.equals(application.getApplicationID())){
                return application;
            }
        }
        return null;
    }
}
