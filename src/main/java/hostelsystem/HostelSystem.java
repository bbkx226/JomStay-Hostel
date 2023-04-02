package hostelsystem;

import DesignUI.Splash;
import Models.Student;
import Utils.UserHandling;
import java.util.ArrayList;

public class HostelSystem {

    public static void main(String[] args) {
        ArrayList<Student> students = UserHandling.getStudents();
        for (Student student : students) {
            System.out.println(student.toString());
        }
        new Splash().start();
    }
}
