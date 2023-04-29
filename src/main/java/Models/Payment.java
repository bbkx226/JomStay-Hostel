package Models;

import Utils.Config;

/**
 *
 * @author KZ
 */

public class Payment {

    public enum PaymentStatus {
        PAID ("Paid"),
        OVERDUE ("Overdue"),
        PENDING ("Pending"),
        NA (Config.NOT_APPLICABLE);
        
        private final String statusString;
        
        PaymentStatus(String statusString) {
            this.statusString = statusString;
        }
        
        public String getStatusString() {
            return statusString;
        }
        
        public static PaymentStatus fromString(String statusString) {
            for (PaymentStatus status : PaymentStatus.values()) {
                if (status.getStatusString().equalsIgnoreCase(statusString)) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Invalid PaymentStatus string: " + statusString);
        }
    }
    
    private Application application;
    private double amount;
    private String paymentID, method, date;
    private PaymentStatus status;

    public Payment(String paymentID, Application application, PaymentStatus status, double amount, String method, String date) {
        this.paymentID = paymentID;
        this.application = application;
        this.status = status;
        this.amount = amount;
        this.method = method;
        this.date = date;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public Application getApplication() {
        return application;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.2f %s %s", 
                paymentID, application.getApplicationID(), 
                status.getStatusString(), amount, 
                method.replace(" ", "_"), 
                date);
    }
}