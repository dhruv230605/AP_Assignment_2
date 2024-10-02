import java.util.ArrayList;
import java.util.List;

public class Student_records {
    private static List<Student> studentRecords = new ArrayList<>();

    public static void addStudent(Student student) {
        studentRecords.add(student);
    }

    public static ArrayList<Student> getAllStudents() {
        return new ArrayList<>(studentRecords);
    }

    public static Student getStudentByName(String name) {
        for (Student student : studentRecords) {
            if (student.name.equals(name)) {
                return student;
            }
        }
        return null;
    }

    public static void updateStudent(Student updatedStudent) {
        for (int i = 0; i < studentRecords.size(); i++) {
            if (studentRecords.get(i).name.equals(updatedStudent.name)) {
                studentRecords.set(i, updatedStudent);
                return;
            }
        }
    }
}