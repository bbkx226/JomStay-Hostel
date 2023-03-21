package main.java;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * LoginRecords
 */
public class LoginSystem {
    private static ArrayList<Login> loginRecords;

    private LoginSystem() {
        loginRecords = new ArrayList<>();
    }

    public static LoginSystem getInstance() {
        return LoginSystemHolder.INSTANCE;
    }

    private static class LoginSystemHolder {
        private static final LoginSystem INSTANCE = new LoginSystem();
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