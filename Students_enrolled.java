import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Students_enrolled {
    private static Map<Course, ArrayList<Student>> enrollmentMap = new HashMap<>();

    public static void enrollStudent(Course course, Student student) {
        enrollmentMap.putIfAbsent(course, new ArrayList<>());
        enrollmentMap.get(course).add(student);
    }

    public static ArrayList<Student> getEnrolledStudents(Course course) {
        return enrollmentMap.getOrDefault(course, new ArrayList<>());
    }
}
