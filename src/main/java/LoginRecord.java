package main.java;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * LoginRecords
 */
public class LoginRecord {
    private static ArrayList<Login> loginRecords;
    private static LoginRecord INSTANCE;

    private LoginRecord() {
        loginRecords = new ArrayList<>();
    }

    public static LoginRecord getInstance() {
        return LoginRecord.INSTANCE;
    }

    private static class LoginRecordHolder {
        private static final LoginRecord INSTANCE = new LoginRecord();
    }
    
    public static ArrayList<Login> getLoginRecords() {
        return loginRecords;
    }

    public ArrayList<Login> searchLogin(String userID) {
        ArrayList<Login> searchResults = new ArrayList<>();
        for (Login login : loginRecords) {
            if (login.getUserID().contains(userID)) {
                searchResults.add(login);
            }
        }
        return searchResults;
    }

    public ArrayList<Login> searchLogin(LocalDateTime startTime, LocalDateTime endTime) {
        ArrayList<Login> searchResults = new ArrayList<>();
        for (Login login : loginRecords) {
            LocalDateTime timestamp = login.getTimestamp();
            if (timestamp.isAfter(startTime) && timestamp.isBefore(endTime)) {
                searchResults.add(login);
            }
        }
        return searchResults;
    }
    
    public ArrayList<Login> searchLogin(boolean status) {
        ArrayList<Login> searchResults = new ArrayList<>();
        for (Login login : loginRecords) {
            if (login.getStatus() == status) {
                searchResults.add(login);
            }
        }
        return searchResults;
    }

}