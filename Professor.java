import java.util.ArrayList;

public class Professor extends User implements userType1 {
    public String name;
    private String email;
    private String password;
    private ArrayList<Course> myCourses;

    public Professor(String name, ArrayList<Course> myCourses, String email, String password){
        this.name = name;
        this.myCourses = myCourses;
        this.email = email;
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }


//Methods for courses
    public void setSyllabus(Course course, String syllabus){
        course.setSyllabus(syllabus);
    }
    public void setTimings(Course course, String timings){
        course.setTimings(timings);
    }
    public void setCredits(Course course, int credits){
        course.setCredits(credits);
    }
    public void addPrereq(Course course) {

        course.getPrereqs().add(course);
    }
    public void removePrereq(Course course){
        course.getPrereqs().remove(course);
    }
    public void setEnrollmentLimit(Course course, int enrollmentLimit){
        course.setEnrollmentLimit(enrollmentLimit);
    }
    public void setOfficeHours(Course course, String officeHours){
        course.setOfficeHours(officeHours);
    }

    public String getEmail(){
        return this.email;
    }

    //
    public void assignCourse(Course course) {
        myCourses.add(course);
    }
    public void addMyCourse(Course course){
        myCourses.add(course);
    }
    public void removeMyCourse(Course course) {
        myCourses.remove(course);
    }

    public boolean isAvailable() {
        return myCourses.isEmpty();
    }
    public ArrayList<Course> getMyCourses() {
        return myCourses;
    }
    public void viewCourses(){
        for (Course course : getMyCourses()){
            System.out.println(course.getTitle());
        }
    }

//Methods for viewing enrolled students
public void viewEnrolledStudents(Course course) {
    if (!myCourses.contains(course)) {
        System.out.println("You are not teaching this course.");
        return;
    }

    ArrayList<Student> enrolledStudents = Students_enrolled.getEnrolledStudents(course);
    System.out.println("Students enrolled in " + course.getTitle() + ":");
    for (Student student : enrolledStudents) {
        displayStudentInfo(student);
    }
}

    private void displayStudentInfo(Student student) {
        System.out.println("Name: " + student.name);
        System.out.println("Contact: " + student.contact);
        System.out.println("Email: " + student.email);
        System.out.println("Semester: " + student.semester);
        System.out.println("CGPA: " + String.format("%.2f", student.getCGPA()));
        System.out.println("Academic Standing: " + getAcademicStanding(student.getCGPA()));

    }

    private String getAcademicStanding(double cgpa) {
        if (cgpa >= 9) return "Excellent";
        else if (cgpa >= 8) return "Good";
        else if (cgpa >= 6.5 ) return "Average";
        else if (cgpa >= 5.5) return "Fair";
        else return "Poor";
    }

    public void viewAllEnrolledStudents() {
        for (Course course : myCourses) {
            viewEnrolledStudents(course);
        }
    }

    //For Feedback
    public void viewCourseFeedback(Course course) {
        if (!myCourses.contains(course)) {
            System.out.println("You are not teaching this course.");
            return;
        }

        ArrayList<Feedback> feedbackList = course.getFeedbackList();
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available for this course.");
        }
        else {
            for (Feedback feedback : feedbackList) {
                feedback.displayFeedback();
                System.out.println();
            }
        }
    }

    public void viewAllCourseFeedback() {
        for (Course course : myCourses) {
            viewCourseFeedback(course);
        }
    }

}
