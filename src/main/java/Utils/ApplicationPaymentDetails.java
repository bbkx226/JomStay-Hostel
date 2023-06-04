package Utils;

import Models.Application;
import Models.Payment;
import static Models.Payment.PaymentStatus;
import static Utils.PaymentHandling.refreshPaymentFile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KZ
 */
// class to store the extra details about payment
public class ApplicationPaymentDetails {

    private PaymentStatus status;
    private LocalDate dueDate;
    private double totalAmtDue;
    private double amtPayable;
    private int totalRentalMonths;
    private ArrayList<LocalDate> rentalPeriodDates;

    // constructor
    public ApplicationPaymentDetails(Application application) {
        List<Payment> payments = PaymentHandling.getApplicationPayments(application);
        if (payments.isEmpty()) {
            this.status = PaymentStatus.NA;
            return;
        }
        refreshPaymentFile();
        this.totalAmtDue = 0;
        this.amtPayable = 0;

        LocalDate startDate = application.getLocalStartDate();
        LocalDate endDate = application.getLocalEndDate();
        this.totalRentalMonths = (int) ChronoUnit.MONTHS.between(startDate, endDate);
        this.rentalPeriodDates = new ArrayList<>();
        for (int i = 0; i < totalRentalMonths; i++) {
            rentalPeriodDates.add(startDate.plusMonths(i));
        }

        LocalDate now = LocalDate.now();
        this.status = PaymentStatus.PENDING;
        for (Payment payment : payments) {
            LocalDate periodStartDate = startDate.plusMonths(payments.indexOf(payment));
            switch (payment.getStatus()) {
                case PAID -> {
                    this.status = PaymentStatus.PAID;
                    continue;
                }
                case OVERDUE -> {
                    this.status = PaymentStatus.OVERDUE;
                    this.dueDate = periodStartDate.plusDays(7);
                    this.totalAmtDue += payment.getAmount();
                    break;
                }
                case PENDING -> {
                    LocalDate periodEndDate = periodStartDate.plusMonths(1);
                    if (now.isBefore(startDate)) {
                        this.dueDate = startDate.plusDays(7);
                    } else if (now.isAfter(periodStartDate)
                            && now.isBefore(periodEndDate)
                            && ! status.equals(PaymentStatus.OVERDUE)) {
                        this.status = PaymentStatus.PENDING;
                        this.dueDate = periodStartDate.plusDays(7);
                        this.totalAmtDue += payment.getAmount();
                    }
                    this.amtPayable += payment.getAmount();
                }
                default -> {
                    break;
                }
            }
        }
    }
    
    // setters and getters
    public PaymentStatus getStatus() {
        return status;
    }
    
    public String getStatusString() {
        return status.getStatusString();
    }
    
    public String getDueDateString(DateTimeFormatter formatter) {
        return switch (this.status) {
            case PAID, NA ->
                Config.NOT_APPLICABLE;
            default ->
                dueDate.format(formatter);
        };
    }

    public String getTotalAmtDueString(String currency) {
        return switch (this.status) {
            case PAID, NA ->
                Config.NOT_APPLICABLE;
            default ->
                currency + totalAmtDue;
        };
    }

    public String getAmtPayableString(String currency) {
        return switch (this.status) {
            case PAID, NA ->
                Config.NOT_APPLICABLE;
            default ->
                currency + amtPayable;
        };
    }
    
    public ArrayList<String> getStringDueDates(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        ArrayList<String> buffer = new ArrayList<>();
        for (LocalDate date : rentalPeriodDates) {
            if (rentalPeriodDates.indexOf(date) == rentalPeriodDates.size()) {
                break;
            }
            buffer.add(date.plusDays(7).format(formatter));
        }
        return buffer;
    }
    
    public ArrayList<String> getStringRentalPeriods(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        ArrayList<String> buffer = new ArrayList<>();
        for (LocalDate date : rentalPeriodDates) {
            if (rentalPeriodDates.indexOf(date) == rentalPeriodDates.size()) {
                break;
            }
            buffer.add(date.format(formatter) + " ~ " + date.plusMonths(1).format(formatter));
        }
        return buffer;
    }
}
