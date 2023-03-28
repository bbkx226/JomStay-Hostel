package Models;

import java.util.Objects;

public class Application {
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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Application other = (Application) obj;
        if (!Objects.equals(this.applicationID, other.applicationID)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.createDate, other.createDate)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        return Objects.equals(this.room, other.room);
    }

    @Override
    public String toString() {
        return "Application{" + "applicationID=" + applicationID + ", status=" + status + ", createDate=" + createDate + ", startDate=" + startDate + ", endDate=" + endDate + ", student=" + student + ", room=" + room + '}';
    }
    
    
}
