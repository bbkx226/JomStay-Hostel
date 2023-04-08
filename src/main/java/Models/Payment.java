/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Objects;

/**
 *
 * @author KZ
 */
public class Payment {

    private Application application;
    private double amount;
    private String paymentID, paymentStatus, method, date;

    public Payment(String paymentID, Application application, String paymentStatus, double amount, String method, String date) {
        this.paymentID = paymentID;
        this.application = application;
        this.paymentStatus = paymentStatus;
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

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    public String getPaymentStatus() {
        return paymentStatus;
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
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.paymentID);
        hash = 83 * hash + Objects.hashCode(this.application);
        hash = 83 * hash + Objects.hashCode(this.paymentStatus);
        hash = 83 * hash + Objects.hashCode(this.amount);
        hash = 83 * hash + Objects.hashCode(this.method);
        hash = 83 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Payment other = (Payment) obj;
        if (!Objects.equals(this.paymentID, other.paymentID)) {
            return false;
        }
        if (!Objects.equals(this.application, other.application)) {
            return false;
        }
        if (!Objects.equals(this.paymentStatus, other.paymentStatus)) {
            return false;
        }
        if (!Objects.equals(this.paymentStatus, other.paymentStatus)) {
            return false;
        }
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        return Objects.equals(this.method, other.method);
    }

    @Override
    public String toString() {
        return paymentID + " " + application.getApplicationID() + " " + paymentStatus + " " + amount + " " + method.replace(" ", "_") + " " + date;
    }
}
