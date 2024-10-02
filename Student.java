import java.util.ArrayList;

public class Student extends User implements userType1  {
    public String name;
    public String contact;
    public int semester;
    public String email;
    public String password;
    private ArrayList<Course> myCourses;
    private ArrayList<Complaints> complaints;
    private ArrayList<Course> completedCourses;
    private int currentCredits;
    private static final int creditLimit = 20;
    private GPACalculator gpaCalculator;

    public Student(String name, String contact, int semester, ArrayList<Course> myCourses, ArrayList<Complaints> complaints ) {
        this.name = name;
        this.contact = contact;
        this.semester = semester;
        this.myCourses = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.currentCredits = 0;
        this.gpaCalculator = new GPACalculator();
    }

    public Student(String name, String contact, int semester, ArrayList<Course> myCourses, ArrayList<Complaints> complaints, String email, String password ){
        this.name = name;
        this.contact = contact;
        this.semester = semester;
        this.myCourses = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.currentCredits = 0;
        this.gpaCalculator = new GPACalculator();
        this.email = email;
        this.password = password;
    }
//Methods for login
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }

//Methods for courses
    public void addMyCourse(Course course){
        myCourses.add(course);
    }

    public void removeMyCourse(Course course, int cur_week) throws CourseDropDeadlineException
    {
        if (course.canDrop(cur_week, course)){
            myCourses.remove(course);
        }
        else{
            throw new CourseDropDeadlineException("Deadline has passed");
        }
    }

    //1st functionality
    public void viewCourses(){
        for (Course course: myCourses){
            course.displayCourse();
            System.out.println();
        }
    }
    public ArrayList<Course> getCourses(){
        return myCourses;
    }

    public void completedCourse(Course course){
        completedCourses.add(course);
    }

    //Are prerequisites for a course met? returns boolean
    public boolean prereqsMet(Course course){
        ArrayList<Course> prereqs = course.getPrereqs();
        for (Course prereq: prereqs){
            if (!completedCourses.contains(prereq)){
                return false;
            }
        }
        return true;
    }

    public void addCourse(Course course) {

        //Exception Handling for Invalid Course Registeration
        try {
            if (!prereqsMet(course)) {
                System.out.println("Prerequisites not met");
            } else if ((course.getCredits() + currentCredits) > 20) {
                System.out.println("Credit limit exceeded");
            } else {
                course.enrollStudent();
                myCourses.add(course);
                currentCredits += course.getCredits();
                System.out.println("Course Added");
            }
        }
        catch(CourseFullException e){
            System.out.println(e.getMessage());
        }
    }



    public boolean isSemesterComplete() {
        for (Course course : myCourses) {
            if (course.getGrade() == 0) { // 0 means not completed course, assuming min grade is 1
                return false;
            }
        }
        return true;
    }

    public void completeSemester() {
        if (isSemesterComplete()) {
            semester++;
            myCourses.clear();
            currentCredits = 0;
        } else {
            System.out.println("Semester isn't over yet");
        }
    }


//Methods for complaints
    public void submitComplaint(String description) {
        Complaints complaint = new Complaints(description);
        complaints.add(complaint);
        System.out.println("Complaint submitted successfully");
    }

    public void viewComplaints() {;
        for (Complaints complaint : complaints) {
            complaint.displayComplaint();
            System.out.println();
        }
    }
    public ArrayList<Complaints> getComplaints() {
        return complaints;
    }

//Methods for grade computation
public void viewGrades() {
    if (isSemesterComplete()) {
        System.out.println("Grades for completed courses:");
        for (Course course : myCourses) {
            System.out.println(course.getTitle() + ": " + course.getGrade());
        }
        System.out.println("CGPA: " + String.format("%.2f", gpaCalculator.getCGPA()));
    } else {
        System.out.println("Not yet");
    }
}

    public void afterSemesterGrade() {
        if (isSemesterComplete()) {
            double sgpa = gpaCalculator.calculateSGPA(myCourses);
            System.out.println("SGPA: " + String.format("%.2f", sgpa));
            System.out.println("CGPA: " + String.format("%.2f", gpaCalculator.getCGPA()));

            semester++;
            myCourses.clear();
            currentCredits = 0;
        } else {
            System.out.println("Not yet");
        }
    }

    public double getCGPA() {
        return gpaCalculator.getCGPA();
    }


    //For Feedback
    public void submitFeedback(Course course, Integer rating, String comment) {
        if (rating == null && (comment == null || comment.isEmpty())) {
            System.out.println("No Feedback provided");
            return;
        }
        Feedback feedback = new Feedback(course, this, rating, comment);
        System.out.println("Feedback submitted successfully");
        course.addFeedback(feedback);
    }



    public void removeMyCourse(Course course){
        return;
    }
}


