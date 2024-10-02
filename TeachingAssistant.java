import java.util.ArrayList;

public class TeachingAssistant extends Student {
    private ArrayList<Course> assignedCourses;

    public TeachingAssistant(String name, String contact, int semester, ArrayList<Course> myCourses, ArrayList<Complaints> complaints, String email, String password) {
        super(name, contact, semester, myCourses, complaints, email, password);
        this.assignedCourses = new ArrayList<>();
    }

    public void assignToCourse(Course course) {
        if (!assignedCourses.contains(course)) {
            assignedCourses.add(course);
        } else {
            System.out.println("TA is already assigned to this course.");
        }
    }

    public void viewStudentGrades(Course course) {
        if (assignedCourses.contains(course)) {
            System.out.println("Grades for students in course: " + course.getTitle());
            ArrayList<Student> enrolledStudents = Students_enrolled.getEnrolledStudents(course);
            for (Student student : enrolledStudents) {
                System.out.println("Student: " + student.name + ", Grade: " + course.getGrade());
            }
        } else {
            System.out.println("TA is not assigned to this course.");
        }
    }

    public void setGrade(Student student, Course course, int grade) {
        if (assignedCourses.contains(course)) {
            if (grade >= 0 && grade <= 10) {
                course.setGrade(grade);
            } else {
                System.out.println("Invalid grade");
            }
        } else {
            System.out.println("TA is not assigned to this course, cannot set grade.");
        }
    }

    public void viewAssignedCourses() {
        if (assignedCourses.isEmpty()) {
            System.out.println("TA has not been assigned to any courses yet.");
        } else {
            System.out.println("Courses assigned to TA:");
            for (Course course : assignedCourses) {
                System.out.println(course.getTitle());
            }
        }
    }
}
