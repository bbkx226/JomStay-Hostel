package Models;

/**
 *
 * @author bbkx2
 */
public class Admin extends User {
    // constructor
    public Admin(String ID, String name, String email, String username, String password) {
        super(ID, name, email, username, password);
        
    }

    // (display) system login record for authentication and authorisation process
    // public static void viewLoginRecord() {
    //    System.out.println(LoginSystem.loginRecordsToString());
    // }

    // Add/update/read/delete hostel room information
    public static void editRooms() {
        System.out.println("Edit rooms.");
    }
    
    // Manage students’ hostel application
    public static void viewApplications() {
        System.out.println("View student applications.");
    }
    
    // Check students’ record
    public static void viewStudents() {
        System.out.println("view student info.");
    }
    
    // Generate report such as monthly income, number of rooms available, etc.
    public static void viewReports() {
        System.out.println("view reports.");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Admin other = (Admin) obj;
        if ((this.getUsername() == null) ? (other.getUsername() != null) : !this.getUsername().equals(other.getUsername())) {
            return false;
        }
        if (!this.getPassword().equals(other.getPassword())) {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
}
