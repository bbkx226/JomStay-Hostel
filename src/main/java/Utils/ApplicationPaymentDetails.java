/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class ApplicationPaymentDetails {

    private Application application;
    private PaymentStatus status;
    private LocalDate dueDate;
    private double totalAmtDue;
    private double amtPayable;
    private int totalRentalMonths;
    private ArrayList<LocalDate> rentalPeriodDates;
    private List<Payment> payments;

    public ApplicationPaymentDetails(Application application, List<Payment> payments) {
        refreshPaymentFile();
        this.application = application;
        this.payments = payments;
        if (payments.isEmpty()) {
            this.status = PaymentStatus.NA;
            return;
        }
        this.totalAmtDue = 0;
        this.amtPayable = 0;

        LocalDate startDate = application.getLocalStartDate().toLocalDate();
        LocalDate endDate = application.getLocalEndDate().toLocalDate();
        this.totalRentalMonths = (int) ChronoUnit.MONTHS.between(startDate, endDate);
        this.rentalPeriodDates = new ArrayList<>();
        for (int i = 0; i < totalRentalMonths; i++) {
            rentalPeriodDates.add(startDate.plusMonths(i));
        }

        LocalDate now = LocalDate.now();
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
                }
                case PENDING -> {
                    LocalDate periodEndDate = periodStartDate.plusMonths(1);
                    if (now.isAfter(periodStartDate) && now.isBefore(periodEndDate)) {
                        this.status = payment.getStatus();
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

    public String getStatusString() {
        return status.getStatusString();
    }

    public String getDueDateString(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
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

    public String getTotalRentalMonthsString() {
        return switch (this.status) {
            case PAID, NA ->
                Config.NOT_APPLICABLE;
            default ->
                "" + totalRentalMonths;
        };
    }
}
