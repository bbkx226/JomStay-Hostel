package main.java;

import java.time.LocalDateTime;

/**
 * Login
 */
public class Login {
    private String userID;
    private LocalDateTime timestamp;
    private boolean status;
    
    public Login(String userID, LocalDateTime timestamp, boolean status) {
        this.userID = userID;
        this.timestamp = timestamp;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        String statusString;
        if (status == true) {
            statusString = "Success";
        } else {
            statusString = "Failed";
        }
        return timestamp + " " + userID + " " + statusString;
    }
    
}