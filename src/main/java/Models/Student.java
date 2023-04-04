package Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author bbkx2
 * @author KZ
 */
public class Student extends User {
    private static DateTimeFormatter formatter;
    
    private String gender, loginDate, phoneNo, NRIC;
    private static String nationality, race, religion, permanentAddress, medicalCondition, emerContactName, emerContactRelationship, emerContactNo;
    
    public Student(String ID, String name, String email, String username, String gender, String loginDate, String password, String phoneNo, String NRIC) {
        super(ID, name, email, username, password);
        this.gender = gender;
        this.loginDate = loginDate;
        this.phoneNo = phoneNo;
        this.NRIC = NRIC;
    }

    public String getGender() {
        return gender;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getNRIC() {
        return NRIC;
    }
    
    public static String getNationality() {
        return nationality;
    }

    public static String getRace() {
        return race;
    }

    public static String getReligion() {
        return religion;
    }

    public static String getPermanentAddress() {
        return permanentAddress;
    }

    public static String getMedicalCondition() {
        return medicalCondition;
    }

    public static String getEmerContactName() {
        return emerContactName;
    }

    public static String getEmerContactRelationship() {
        return emerContactRelationship;
    }

    public static String getEmerContactNo() {
        return emerContactNo;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setNRIC(String NRIC) {
        this.NRIC = NRIC;
    }
    
    public static void setNationality(String nationality) {
        Student.nationality = nationality;
    }

    public static void setRace(String race) {
        Student.race = race;
    }

    public static void setReligion(String religion) {
        Student.religion = religion;
    }

    public static void setPermanentAddress(String permanentAddress) {
        Student.permanentAddress = permanentAddress;
    }

    public static void setMedicalCondition(String medicalCondition) {
        Student.medicalCondition = medicalCondition;
    }

    public static void setEmerContactName(String emerContactName) {
        Student.emerContactName = emerContactName;
    }

    public static void setEmerContactRelationship(String emerContactRelationship) {
        Student.emerContactRelationship = emerContactRelationship;
    }

    public static void setEmerContactNo(String emerContactHPNo) {
        Student.emerContactNo = emerContactHPNo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.gender);
        hash = 67 * hash + Objects.hashCode(this.loginDate);
        hash = 67 * hash + Objects.hashCode(this.phoneNo);
        hash = 67 * hash + Objects.hashCode(this.NRIC);
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.loginDate, other.loginDate)) {
            return false;
        }
        if (!Objects.equals(this.phoneNo, other.phoneNo)) {
            return false;
        }
        return Objects.equals(this.NRIC, other.NRIC);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{");
        sb.append("ID=").append(super.getID());
        sb.append(", name=").append(super.getName());
        sb.append(", username=").append(super.getUsername());
        sb.append(", password=").append(super.getPassword());
        sb.append(", email=").append(super.getEmail());
        sb.append(", gender=").append(gender);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", phoneNo=").append(phoneNo);
        sb.append(", NRIC=").append(NRIC);
        sb.append(", nationality=").append(nationality);
        sb.append(", race=").append(race);
        sb.append(", permanentAddress=").append(permanentAddress);
        sb.append(", medicalCondition=").append(medicalCondition);
        sb.append(", emerContactName=").append(emerContactName);
        sb.append(", emerContactRelationship=").append(emerContactRelationship);
        sb.append(", emerContactNo=").append(emerContactNo);
        sb.append('}');
        return sb.toString();
    }
    
    

}