// @author They Kai Zhe
package Models;

import java.util.Objects;

public class Student extends User {
    private String email, gender, loginDate, phoneNo, NRIC;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.email);
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
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
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
    
    

}