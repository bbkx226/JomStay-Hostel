package hostelsystem;
/**
 *
 * @author bbkx
 */

import DesignUI.Splash;
import Models.Student;
import Utils.StudentHandling;
import java.util.ArrayList;

public class HostelSystem {

    public static void main(String[] args) {
        ArrayList<Student> students = StudentHandling.getStudents();
        for (Student student : students) {
            System.out.println(student.toString());
        }
        new Splash().start();
    }
}
