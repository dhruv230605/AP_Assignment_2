import java.util.ArrayList;

public class Admin {
    private String name;
    private String password = "iiitdadmin";

    // Constructor
    public Admin(String name) {
        this.name = name;
    }

//Methods for complaints
    public void viewAllComplaints(ArrayList<Student> students) {
        System.out.println("Complaints overview:");
        for (Student student : students) {
            System.out.println("Complaints by " + student.name + ":");
            for (Complaints complaint : student.getComplaints()) {
                complaint.displayComplaint();
                System.out.println();
            }
        }
    }

    // Update complaint status and resolution
    public void resolveComplaint(Student student, int complaintIndex, String resolution) {
        ArrayList<Complaints> complaints = student.getComplaints();
        if (complaintIndex >=0 &&  complaintIndex < complaints.size()) {
            Complaints complaint = complaints.get(complaintIndex);
            complaint.setResolution(resolution);
            complaint.setStatus("Resolved");
        } else {
            System.out.println("Invalid entry");
        }
    }


//Methods for student records
public void viewAllStudentRecords() {
    System.out.println("Student Records:");
    for (Student student : Student_records.getAllStudents()) {
        displayStudentInfo(student);
    }
}

    public void viewStudentRecord(String studentName) {
        Student student = Student_records.getStudentByName(studentName);
        if (student != null) {
            displayStudentInfo(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private void displayStudentInfo(Student student) {
        System.out.println("Name: " + student.name);
        System.out.println("Contact: " + student.contact);
        System.out.println("Email: " + student.email);
        System.out.println("Semester: " + student.semester);
        System.out.println("CGPA: " + student.getCGPA());
        System.out.println("Current Courses:");
        student.viewCourses();
    }

    public void updateStudentInfo(String studentName, String field, String newValue) {
        Student student = Student_records.getStudentByName(studentName);
        if (student != null) {
            switch (field.toLowerCase()) {
                case "name":
                    student.name = newValue;
                    break;
                case "contact":
                    student.contact = newValue;
                    break;
                default:
                    System.out.println("Invalid");
                    return;
            }
            Student_records.updateStudent(student);
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Error");
        }
    }

    public void updateStudentGrade(String studentName, String courseTitle, double newGrade) {
        Student student = Student_records.getStudentByName(studentName);
        if (student != null) {
            for (Course course : student.getCourses()) {
                if (course.getTitle().equals(courseTitle)) {
                    course.setGrade(newGrade);
                    System.out.println("Grade update");
                    student.afterSemesterGrade();
                    return;
                }
            }
            System.out.println("No such course");
        } else {
            System.out.println("No such student");
        }
    }

//Methods for assigning professors to courses
    public void assignProfessorToCourse(Professor professor, Course course) {

        if (professor.isAvailable()) {
            course.setProfessor(professor);
            professor.assignCourse(course);
            System.out.println("Assigned");
        } else {
            System.out.println("Professor is not available");
        }
    }

}

