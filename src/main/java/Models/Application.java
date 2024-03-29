// @author Brandon Ban Kai Xian TP067094
package Models;

import Utils.Config;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Application {
    DateTimeFormatter createDateFormatter = Config.dateFormats.FILE_APPLICATION_CREATE_DATE.getFormatter();
    DateTimeFormatter startEndDateFormatter = Config.dateFormats.FILE_APPLICATION_START_END_DATE.getFormatter();
    
    private String applicationID, status, createDate, startDate, endDate;
    private Student student;
    private Room room;

    public Application(String applicationID, Student student, Room room, String status, String createDate, String startDate, String endDate) {
        this.applicationID = applicationID;
        this.status = status;
        this.createDate = createDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.student = student;
        this.room = room;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getStatus() {
        return status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public LocalDateTime getLocalCreateDate() {
        return LocalDateTime.parse(createDate, createDateFormatter);
    }
    
    public LocalDate getLocalStartDate() {
        return LocalDate.parse(startDate, startEndDateFormatter);
    }
    
    public LocalDate getLocalEndDate() {
        return LocalDate.parse(endDate, startEndDateFormatter);
    }
    
    public LocalDateTime getLocalCreateDate(String format) {
        return LocalDateTime.parse(createDate, DateTimeFormatter.ofPattern(format));
    }
    
    public LocalDate getLocalStartDate(String format) {
        return LocalDate.parse(startDate, DateTimeFormatter.ofPattern(format));
    }
    
    public LocalDate getLocalEndDate(String format) {
        return LocalDate.parse(endDate, DateTimeFormatter.ofPattern(format));
    }
    
    public Student getStudent() {
        return student;
    }

    public Room getRoom() {
        return room;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.applicationID);
        hash = 83 * hash + Objects.hashCode(this.status);
        hash = 83 * hash + Objects.hashCode(this.createDate);
        hash = 83 * hash + Objects.hashCode(this.startDate);
        hash = 83 * hash + Objects.hashCode(this.endDate);
        hash = 83 * hash + Objects.hashCode(this.student);
        hash = 83 * hash + Objects.hashCode(this.room);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Application other = (Application) obj;
        if (!Objects.equals(this.applicationID, other.applicationID)) return false;
        if (!Objects.equals(this.status, other.status)) return false;
        if (!Objects.equals(this.createDate, other.createDate)) return false;
        if (!Objects.equals(this.startDate, other.startDate)) return false;
        if (!Objects.equals(this.endDate, other.endDate)) return false;
        if (!Objects.equals(this.student, other.student)) return false;
        return Objects.equals(this.room, other.room);
    }
              
    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s\n", 
                applicationID, student.getID(), 
                room.getRoomID(), status, 
                createDate, startDate, 
                endDate);
    }
}
