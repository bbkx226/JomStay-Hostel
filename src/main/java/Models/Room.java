// @author Brandon Ban Kai Xian TP067094
package Models;

import java.util.*;

public class Room {
    private String roomID, status;
    private RoomType roomType;
    private boolean servicing;
    private static final List<String> allStatus = new ArrayList<>(Arrays.asList("Available", "Occupied", "Reserved"));
    
    public Room(String roomID, String status, boolean servicing, RoomType roomType) {
        this.roomID = roomID;
        this.status = status;
        this.servicing = servicing;
        this.roomType = roomType;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (allStatus.contains(status)){
            this.status = status;  
        }
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isServicing() {
        return servicing;
    }
    
    public String getServicingString() {
        if (servicing) {
            return "Yes";
        }
        return "No";
    }

    public void setServicing(boolean servicing) {
        this.servicing = servicing;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.roomID);
        hash = 11 * hash + Objects.hashCode(this.status);
        hash = 11 * hash + Objects.hashCode(this.roomType);
        hash = 11 * hash + (this.servicing ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Room other = (Room) obj;
        if (this.servicing != other.servicing) return false;
        if (!Objects.equals(this.roomID, other.roomID)) return false;
        if (!Objects.equals(this.status, other.status)) return false;
        return Objects.equals(this.roomType, other.roomType);
    }

    @Override
    public String toString() {
        return String.format("%s %s %b %s", 
                roomID, status, 
                servicing, 
                roomType.getTypeName());
    }
}
