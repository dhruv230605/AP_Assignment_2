import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String code;
    private String title;
    private int credits;
    private ArrayList<Course> prereqs;
    private double grade;
    private Professor professor;
    private String timings;
    private HashMap<Student, Double> studentGrades;
    private ArrayList<Feedback> feedbackList;
    private int enrolledStudents = 0;
    private int dropWeek;


    //timings, location and professor in courseSchedule

    //For professor
    private String syllabus;
    private int enrollmentLimit;
    private String officeHours;


    public Course(String code, String title, int credits, ArrayList<Course> prereqs, String syllabus,int enrollmentLimit, String officeHours, String timings, Professor professor, int dropWeek ) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.prereqs = prereqs;
        this.grade = 0;
        this.enrollmentLimit = enrollmentLimit;
        this.officeHours = officeHours;
        this.syllabus = syllabus;
        this.professor = professor;
        this.timings = timings;
        this.studentGrades = new HashMap<>();
        this.feedbackList = new ArrayList<>();
        this.dropWeek = dropWeek;
    }

    public String getCode() {return code;}
    public String getTitle() {return title;}
    public int getCredits() {return credits;}
    public ArrayList<Course> getPrereqs() {return prereqs;}
    public double getGrade() {return grade;}
    public String getTimings(){return timings;}
    public Professor getProfessor() {return professor;}
    public int getDropWeek(){return dropWeek;}

    public void setSyllabus(String syllabus){this.syllabus = syllabus;}
    public void setCredits(int credits){this.credits = credits;}
    public void setGrade(double grade) {this.grade = grade;}
    public void setEnrollmentLimit(int enrollmentLimit){this.enrollmentLimit = enrollmentLimit;}

    public int getEnrolledStudents() { return enrolledStudents; }

    public void setOfficeHours(String officeHours){this.officeHours = officeHours;}
    public void setProfessor(Professor professor) { this.professor = professor; }
    public void setTimings(String timings){this.timings = timings;}
    public void setDropWeek(int dropWeek){this.dropWeek = dropWeek;}

    //Method for Drop Deadline
    public boolean canDrop(int week, Course course){
        return week <= course.dropWeek;
    }

//Implemented in TA instead. Keep here until sure to remove
    public void setGrade(Student student, double grade) {
        if (grade >= 0 && grade <= 10) {
            studentGrades.put(student, grade);

        } else {
            System.out.println("Invalid grade");
        }
    }

    public double getGrade(Student student) {
        return studentGrades.getOrDefault(student, 0.0);
    }

    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
        System.out.println("Feedback added for course: " + title);
    }

    public ArrayList<Feedback> getFeedbackList(){
        return feedbackList;
    }

    public void displayFeedback() {
        System.out.println("Feedback for course: " + title);
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
        } else {
            for (Feedback feedback : feedbackList) {
                feedback.displayFeedback();
            }
        }
    }

    public void enrollStudent() throws CourseFullException {
        if (enrolledStudents >= enrollmentLimit) {
            throw new CourseFullException("Course " + title + " is already full.");
        }
        enrolledStudents++;
    }

    public void displayCourse() {
        System.out.println("Course Code: " + code);
        System.out.println("Title: " + title);
        System.out.println("Syllabus: "+syllabus);
        System.out.println("Credits: " +credits);
        System.out.println("Prerequisites: "+prereqs);
        System.out.println("Grade: " + grade);
        System.out.println("Enrollment limit: "+enrollmentLimit);
        System.out.println("officeHours " + officeHours);
        System.out.println("Timings: " +timings);
        if (professor != null) {
            System.out.println("Professor: " + professor.name);
        }
        else {
            System.out.println("Professor: Not assigned.");
        }
    }


}
