/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.Application;
import Models.Payment;
import Models.Student;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author KZ
 */
public class PaymentHandling {
    private static final String PATH = "src/main/java/databases/payment.txt";
    
    public static ArrayList<Payment> getAllPayments() {
        ArrayList<Payment> buffer = new ArrayList<>();
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            Application application = compareToApplication(data[1]);
            double amount = Double.parseDouble(data[3]);
            Payment payment = new Payment(data[0], application, data[2], amount, data[4], data[5]);
            buffer.add(payment);
        }
        return buffer;
    }
    
    public static ArrayList<Payment> getPendingPayments() {
        ArrayList<Payment> buffer = new ArrayList<>();
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            if (data[2].equals("Pending")) {
                Application application = compareToApplication(data[1]);
                double amount = Double.parseDouble(data[3]);
                Payment payment = new Payment(data[0], application, data[2], amount, data[4], data[5]);
                buffer.add(payment);
            }
        }
        return buffer;
    }
    
    public static ArrayList<Payment> getOverduePayments() {
        ArrayList<Payment> buffer = new ArrayList<>();
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            if (data[2].equals("Overdue")) {
                Application application = compareToApplication(data[1]);
                double amount = Double.parseDouble(data[3]);
                Payment payment = new Payment(data[0], application, data[2], amount, data[4], data[5]);
                buffer.add(payment);
            }
        }
        return buffer;
    }
    
    public static ArrayList<Payment> getCurrentStudentPayments(Student student) {
        ArrayList<Payment> buffer = new ArrayList<>();
        Application currentUserApplication = ApplicationHandling.getCurrentStudentApplication(student);
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            if (currentUserApplication.getApplicationID().equals(data[1])) {
                Application application = compareToApplication(data[1]);
                double amount = Double.parseDouble(data[3]);
                Payment payment = new Payment(data[0], application, data[2], amount, data[4], data[5]);
                buffer.add(payment);
            }
        }
        return buffer;
    }
    
    public static void addNewPayment(Payment payment) {
        Application application = payment.getApplication();
        LocalDate startDate = application.getLocalStartDate().toLocalDate();
        LocalDate endDate = application.getLocalEndDate().toLocalDate();
        long lengthOfStay = ChronoUnit.MONTHS.between(startDate, endDate);
        String stringToWrite = null;
        for (int i = 0; i < lengthOfStay; i++) {
            stringToWrite += payment.toString() + "\n";
        }
        FileHandlerUtils.writeString(PATH, stringToWrite, true);
    }
    
    public static void updatePayment(Payment payment) {
        String ID = payment.getPaymentID();
        String lineToWrite = payment.toString();

        int index = Integer.parseInt(ID.substring(ID.length() - 4)) - 1;
        ArrayList<String> lines = FileHandlerUtils.readLines(PATH);
        lines.set(index, lineToWrite);
        
        String result = String.join("\n", lines);
        FileHandlerUtils.writeString(PATH, result, false);
    }
    
    public static Application compareToApplication(String applicationID) {
        for (Application application : ApplicationHandling.getTotalApplications()){
            if(applicationID.equals(application.getApplicationID())){
                return application;
            }
        }
        return null;
    }
    
    public static void refreshPaymentFile() {
        LocalDate now = LocalDate.now();        
        ArrayList<Payment> payments = getAllPayments();
        ArrayList<String> buffer = new ArrayList<>();
        System.out.println(payments.size());
        for (int i = 0; i < payments.size(); i++) {
            Payment payment = payments.get(i);
            Application application = payment.getApplication();
            LocalDate startDate = application.getLocalStartDate().toLocalDate();
            if (payment.getPaymentStatus().equals("Paid")) {
                buffer.add(payment.toString());
                continue;
            }
            LocalDate paymentDueDate = startDate.plusMonths(i + 1).plusDays(7);
            if (now.isAfter(paymentDueDate)) {
                payment.setPaymentStatus("Overdue");
            }
            if (payment.getPaymentStatus().equals("Overdue")) {
                // TODO: only add 50 to the base price of the room type
//                payment.setAmount(payment.getAmount() + 50);
            }
            buffer.add(payment.toString());
        }
        String stringToWrite = String.join("\n", buffer);
        FileHandlerUtils.writeString(PATH, stringToWrite, false);
    }
}
