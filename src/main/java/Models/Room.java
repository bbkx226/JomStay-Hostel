package Models;

import java.util.*;

public class Room {
    private String roomID, status;
    private boolean servicing;
    private int pax;
    private int pricePerPax;
    private static final List<String> allStatus = new ArrayList<>(Arrays.asList("Available", "Occupied"));
    
    public Room(String roomID, String status, boolean servicing, int pax, int pricePerPax) {
        this.roomID = roomID;
        this.status = status;
        this.servicing = servicing;
        this.pax = pax;
        this.pricePerPax = pricePerPax;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setServicing(boolean servicing) {
        this.servicing = servicing;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }
    
    public void setPricePerPax(int pricePerPax) {
        this.pricePerPax = pricePerPax;
    }

    public String getRoomID() {
        return roomID;
    }

    public String getStatus() {
        return status;
    }

    public boolean isServicing() {
        return servicing;
    }
    
    public int getPax() {
        return pax;
    }
    
    public int getPricePerPax() {
        return pricePerPax;
    }

    public static List<String> getAllStatus() {
        return allStatus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.roomID);
        hash = 29 * hash + Objects.hashCode(this.status);
        hash = 29 * hash + (this.servicing ? 1 : 0);
        hash = 29 * hash + this.pax;
        hash = 29 * hash + this.pricePerPax;
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
        final Room other = (Room) obj;
        if (this.servicing != other.servicing) {
            return false;
        }
        if (this.pax != other.pax) {
            return false;
        }
        if (this.pricePerPax != other.pricePerPax) {
            return false;
        }
        if (!Objects.equals(this.roomID, other.roomID)) {
            return false;
        }
        return Objects.equals(this.status, other.status);
    }

    @Override
    public String toString() {
        return String.format("%s %s %b %d %d\n", roomID, status, servicing, pax, pricePerPax);
    }

    
    
    
}
