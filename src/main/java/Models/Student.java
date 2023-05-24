package Models;

import java.util.Objects;

/**
 *
 * @author bbkx2
 * @author KZ
 */
public class Student extends User {
    
    private String gender, loginDate, phoneNo, NRIC;
    private String nationality, race, religion, permanentAddress, medicalCondition, emerContactName, emerContactRelationship, emerContactNo;
    
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
        if(loginDate.equals("date")) return "No record found";
        return loginDate;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getNRIC() {
        return NRIC;
    }
    
    public String getNationality() {
        return nationality;
    }

    public String getRace() {
        return race;
    }

    public String getReligion() {
        return religion;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public String getEmerContactName() {
        return emerContactName;
    }

    public String getEmerContactRelationship() {
        return emerContactRelationship;
    }

    public String getEmerContactNo() {
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
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public void setEmerContactName(String emerContactName) {
        this.emerContactName = emerContactName;
    }

    public void setEmerContactRelationship(String emerContactRelationship) {
        this.emerContactRelationship = emerContactRelationship;
    }

    public void setEmerContactNo(String emerContactHPNo) {
        this.emerContactNo = emerContactHPNo;
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
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Student other = (Student) obj;
        if (!Objects.equals(this.gender, other.gender)) return false;
        if (!Objects.equals(this.phoneNo, other.phoneNo)) return false;
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