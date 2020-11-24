import java.util.ArrayList;
import java.util.Random;
import org.joda.time.DateTime;

public class Main {

    public static void main(String[] args) {
        int numOfStudents = 5;
        int numOfModules = 5;
        int numOfCourses = 5;

        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Module> modules = new ArrayList<>();

        // Create Courses
        for (int i = 0; i < numOfCourses; i++) {
            String name = "Course Name " + i;
            ArrayList<Module> courseModules = new ArrayList<>();
            ArrayList<Student> courseStudents = new ArrayList<>();
            DateTime start_date = new DateTime();
            DateTime end_date = new DateTime();
            courses.add(new Course(name, courseModules, courseStudents, start_date, end_date));
        }

        // Create Modules
        for (int i = 0; i < numOfModules; i++) {
            String name = "Module Name " + i;
            String id = String.valueOf(new Random().nextDouble());
            DateTime start_date = new DateTime();
            DateTime end_date = new DateTime();
            ArrayList<Student> modStudents = new ArrayList<>();
            modules.add(new Module(name, id, start_date, end_date, modStudents, courses));
        }

        // Create Students
        for (int i = 0; i < numOfStudents; i++) {
            String name = "Student Name " + i;
            DateTime dob = new DateTime(1998, 8, 16, 12, 12);
            double id = new Random().nextDouble()*123;
            Course course = courses.get(i);
            if (i%2 == 0) {
                students.add(new Student(name, dob, id, course, modules, false));
            }
            students.add(new Student(name, dob, id, course, modules, true));
        }

        System.out.println(courses);
        System.out.println(modules);
        System.out.println(students);

    }

}// End Main
