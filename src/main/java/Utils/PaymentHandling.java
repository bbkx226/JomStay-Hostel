package Utils;

import Models.Application;
import Models.Payment;
import Models.Payment.PaymentStatus;
import Utils.Config.filePath;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author KZ
 */
public final class PaymentHandling {

    private static final String PATH = filePath.PAYMENT_PATH.getValue();

    // get all the payments from the payment file
    public static ArrayList<Payment> getAllPayments() {
        ArrayList<Payment> buffer = new ArrayList<>();
        for (String line : FileHandlerUtils.readLines(PATH)) {
            String[] data = line.split(" ");
            Application application = compareToApplication(data[1]);
            double amount = Double.parseDouble(data[3]);
            Payment payment = new Payment(data[0], application, PaymentStatus.fromString(data[2]), amount, data[4], data[5]);
            buffer.add(payment);
        }
        return buffer;
    }

    // get all the payments of the specified application
    public static ArrayList<Payment> getApplicationPayments(Application application) {
        ArrayList<Payment> allPayments = getAllPayments();
        ArrayList<Payment> buffer = new ArrayList<>();
        for (Payment payment : allPayments) {
            if (application.equals(payment.getApplication())) {
                buffer.add(payment);
            }
        }
        return buffer;
    }
    
    // add new payments to file when an application is accepted by an admin
    public static void addNewPendingPayments(Application application) {
        LocalDate startDate = application.getLocalStartDate();
        LocalDate endDate = application.getLocalEndDate();
        long lengthOfStay = ChronoUnit.MONTHS.between(startDate, endDate);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lengthOfStay; i++) {
            ArrayList<Payment> payments = getAllPayments();
            String newPaymentID = "P" + String.format("%04d", payments.size() + i + 1);
            stringBuilder.append(newPaymentID).append(" ")
                    .append(application.getApplicationID()).append(" ")
                    .append(PaymentStatus.PENDING.getStatusString()).append(" ")
                    .append(application.getRoom().getRoomType().getRentalFee()).append(" ")
                    .append(Config.NOT_APPLICABLE).append(" ")
                    .append(Config.NOT_APPLICABLE).append("\n");
        }
        FileHandlerUtils.writeString(PATH, stringBuilder.toString(), true);
    }

    // update the payment file with the specified payment
    public static void updatePayment(Payment payment) {
        String ID = payment.getPaymentID();
        String lineToWrite = payment.toString();

        int index = Integer.parseInt(ID.substring(ID.length() - 4)) - 1;
        ArrayList<String> lines = FileHandlerUtils.readLines(PATH);
        lines.set(index, lineToWrite);

        String result = String.join("\n", lines);
        FileHandlerUtils.writeString(PATH, result, false);
    }

    // get the application object of the specified application id
    public static Application compareToApplication(String applicationID) {
        for (Application application : ApplicationHandling.getTotalApplications()) {
            if (applicationID.equals(application.getApplicationID())) {
                return application;
            }
        }
        return null;
    }
    
    // update the payment file to be up to date with the current date
    public static void refreshPaymentFile() {
        LocalDate now = LocalDate.now();
        ArrayList<Payment> payments = getAllPayments();
        StringBuilder stringBuilder = new StringBuilder();
        int month = 0;
        for (int i = 0; i < payments.size(); i++) {
            Application application = payments.get(i).getApplication();
            // after the first payment and check if it is the next application
            if (i > 12 && ! application.equals(payments.get(i - 1).getApplication())) {
                month = 0;
            }
            
            Payment payment = payments.get(i);
            if (payment.getStatus().equals(PaymentStatus.PENDING)) {
                LocalDate startDate = application.getLocalStartDate();
                LocalDate paymentDueDate = startDate.plusMonths(month).plusDays(7);
                if (now.isAfter(paymentDueDate)) {
                    payment.setStatus(PaymentStatus.OVERDUE);
                    payment.setAmount(application.getRoom().getRoomType().getRentalFee() + 50);
                }
            }
            month++;
            stringBuilder.append(payment.toString()).append("\n");
        }
        FileHandlerUtils.writeString(PATH, stringBuilder.toString(), false);
    }

    // update the payment file with the specified payment arraylist, the selected months to update and the payment method
    public static void updatePaymentFile(ArrayList<Payment> payments, ArrayList<Integer> selectedMonths, String paymentMethod) {
        int paymentMonth = 0;
        for (Payment payment : payments) {
            paymentMonth++;
            if (payment.getStatus().equals(PaymentStatus.PAID)) {
                continue;
            }
            if (selectedMonths.contains(paymentMonth)) {
                payment.setStatus(PaymentStatus.PAID);
                payment.setMethod(paymentMethod);
                payment.setDate(LocalDate.now().format(Config.dateFormats.FILE_PAYMENT_DATE.getFormatter()));
                updatePayment(payment);
            }
        }
    }
}
