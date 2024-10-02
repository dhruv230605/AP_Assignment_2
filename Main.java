import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static HashMap<String, Professor> professors = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<Course> s1Courses = new ArrayList<>();
        ArrayList<Complaints> s1Complaints = new ArrayList<>();
        Student_records.addStudent(new Student("Dhruv", "1234567890", 1, s1Courses, s1Complaints, "d", "d"));

        ArrayList<Course> s2Courses = new ArrayList<>();
        ArrayList<Complaints> s2Complaints = new ArrayList<>();
        Student_records.addStudent(new Student("Aryan", "0987654321", 1, s2Courses, s2Complaints, "a", "a"));

        ArrayList<Course> s3Courses = new ArrayList<>();
        ArrayList<Complaints> s3Complaints = new ArrayList<>();
        Student_records.addStudent(new Student("Rohan", "1122334455", 1, s3Courses, s3Complaints, "r", "r"));

        ArrayList<Course> p1Courses = new ArrayList<>();
        Professor p1 = new Professor("Varun", p1Courses, "v", "v");
        professors.put("v", p1);
        ArrayList<Course> p2Courses = new ArrayList<>();
        Professor p2 = new Professor("Fahim", p2Courses, "f", "f");
        professors.put("f", p2);
        courseCatalog catalog = new courseCatalog();
        Course c1 = new Course("101", "LA", 4, new ArrayList<>(), "Linear Algebra", 300, "MWF 10-11", "MWF 10-11", professors.get("v"), 10);
        catalog.addCourse(c1);
        Course c2 = new Course("102", "IP", 4, new ArrayList<>(), "Introduction to Programming", 300, "TTh 1-2:30", "TTh 1-2:30", professors.get("f"), 10);
        catalog.addCourse(c2);
        Course c3 = new Course("103", "HCI", 4, new ArrayList<>(), "Design Techniques", 300, "MWF 11-12", "MWF 11-12", professors.get("v"), 10);
        catalog.addCourse(c3);
        Course c4 = new Course("104", "DC", 4, new ArrayList<>(), "Circuits and Hardware", 300, "TTh 9-10:30", "TTh 9-10:30", professors.get("f"), 10);
        catalog.addCourse(c4);
        Course c5 = new Course("105", "COM", 4, new ArrayList<>(), "Communication Skills", 300, "MWF 2-3", "MWF 2-3", professors.get("v"), 10);
        catalog.addCourse(c5);
        Course c6 = new Course("201", "DSA", 4, new ArrayList<>(), "Data Structures and Algorithms", 300, "MWF 10-11", "MWF 10-11 ", professors.get("v"), 20);
        catalog.addCourse(c6);
        Course c7 = new Course("202", "BE", 4, new ArrayList<>(), "Basic Electronics", 300, "TTh 1-2:30 ", "TTh 1-2:30 ", professors.get("f"), 20);
        catalog.addCourse(c7);
        Course c8 = new Course("203", "PNS", 4, new ArrayList<>(), "Probability and Statistics", 300, "MWF 11-12 ", "MWF 11-12 ", professors.get("f"), 20);
        catalog.addCourse(c8);
        Course c9 = new Course("204", "MB", 4, new ArrayList<>(), "Money and Banking", 300, "TTh 9-10:30 ", "TTh 9-10:30", professors.get("v"), 20);
        catalog.addCourse(c9);
        Course c10 = new Course("205", "CO", 4, new ArrayList<>(), "Computer Organisation", 300, "MWF 2-3 ", "MWF 2-3 ", professors.get("f"), 20);
        catalog.addCourse(c10);
        p1.assignCourse(c1);p1.assignCourse(c3);p1.assignCourse(c5);p1.assignCourse(c6);p1.assignCourse(c9);
        p2.assignCourse(c2);p2.assignCourse(c4);p2.assignCourse(c7);p2.assignCourse(c8);p2.assignCourse(c10);
        List<Student> studentRecords = Student_records.getAllStudents();
        for (Student student : Student_records.getAllStudents()) {
            Course course101 = findCourseByCode("101", catalog.getCourses());
            Course course102 = findCourseByCode("102", catalog.getCourses());
            Course course103 = findCourseByCode("103", catalog.getCourses());
            Course course104 = findCourseByCode("104", catalog.getCourses());
            Course course105 = findCourseByCode("105", catalog.getCourses());

            student.addMyCourse(course101);
            student.addMyCourse(course102);
            student.addMyCourse(course103);
            student.addMyCourse(course104);
            student.addMyCourse(course105);

            Students_enrolled.enrollStudent(course101, student);
            Students_enrolled.enrollStudent(course102, student);
            Students_enrolled.enrollStudent(course103, student);
            Students_enrolled.enrollStudent(course104, student);
            Students_enrolled.enrollStudent(course105, student);
        }
        //Instantiating TAs
        ArrayList<Course> ta1Courses = new ArrayList<>();
        ArrayList<Complaints> ta1Complaints = new ArrayList<>();
        TeachingAssistant ta1 = new TeachingAssistant("Bargotia", "1116537111", 1, ta1Courses, ta1Complaints, "b", "b");

        ArrayList<Course> ta2Courses = new ArrayList<>();
        ArrayList<Complaints> ta2Complaints = new ArrayList<>();
        TeachingAssistant ta2 = new TeachingAssistant("Thomas", "2225367222", 2, ta2Courses, ta2Complaints, "t", "t");

        ArrayList<Course> ta3Courses = new ArrayList<>();
        ArrayList<Complaints> ta3Complaints = new ArrayList<>();
        TeachingAssistant ta3 = new TeachingAssistant("Zara", "3335673333", 3, ta3Courses, ta3Complaints, "z", "z");

        Student_records.addStudent(ta1);
        Student_records.addStudent(ta2);
        Student_records.addStudent(ta3);

        ta1.assignToCourse(c1);
        ta1.assignToCourse(c2);
        ta1.assignToCourse(c3);
        ta1.assignToCourse(c4);
        ta1.assignToCourse(c5);

        ta2.assignToCourse(c6);
        ta2.assignToCourse(c7);
        ta2.assignToCourse(c8);
        ta2.assignToCourse(c9);
        ta2.assignToCourse(c10);

        TA_records.addTA(ta1);
        TA_records.addTA(ta2);
        TA_records.addTA(ta3);


        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the University Course Registration System");
            System.out.println("1. Enter the Application");
            System.out.println("2. Exit the Application");
            System.out.print("Choose an option: ");
            int choic = sc.nextInt();
            sc.nextLine();

            switch (choic) {
                case 1:
                    handleUserSelection(sc, catalog);
                    break;
                case 2:
                    exit = true;
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }

    private static void handleUserSelection(Scanner sc, courseCatalog catalog) {
        System.out.println("Select your role:");
        System.out.println("1. Student");
        System.out.println("2. Professor");
        System.out.println("3. Administrator");
        System.out.println("4. Teaching Assistant");
        System.out.print("Choose an option: ");
        int role = sc.nextInt();
        sc.nextLine();

        switch (role) {
            case 1:
                handleStudent(sc, catalog);
                break;
            case 2:
                handleProfessor(sc);
                break;
            case 3:
                handleAdmin(sc, catalog);
                break;
            case 4:
                handleTA(sc, catalog);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void handleStudent(Scanner sc, courseCatalog catalog) {
        System.out.println("1. Sign Up");
        System.out.println("2. Login");
        System.out.print("Choose an option: ");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                signUpStudent(sc);
                break;
            case 2:
                loginStudent(sc, catalog);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void handleProfessor(Scanner sc) {
        System.out.println("1. Sign Up");
        System.out.println("2. Login");
        System.out.print("Choose an option: ");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                signUpProfessor(sc);
                break;
            case 2:
                loginProfessor(sc);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void handleAdmin(Scanner sc, courseCatalog catalog) {
        System.out.print("Enter admin password: ");
        String password = sc.nextLine();
        Admin admin = new Admin("iiitdadmin"); //name and password kept same
//        courseCatalog catalog = new courseCatalog();

        //Exception Handling for Invalid Login
        try{
            if(!"iiitdadmin".equals(password)){
                throw new InvalidLoginException("Incorrect admin password");
            }
            System.out.println("Welcome, Administrator.");
            adminHomePage(sc, admin, catalog);
        }
        catch(InvalidLoginException e){
            System.out.println(e.getMessage());
        }
    }

    private static void handleTA(Scanner sc, courseCatalog catalog) {
        System.out.println("1. Login");
        System.out.print("Choose an option: ");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                loginTA(sc, catalog);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void loginTA(Scanner sc, courseCatalog courseCatalog) {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        //Exception Handling for Invalid Login
    try {
        TeachingAssistant ta = TA_records.getAllTAs().stream()
                .filter(taUser -> taUser.email.equals(email))
                .findFirst().orElse(null);

        if (ta != null && ta.getPassword().equals(password)) {
            System.out.println("Logged in");
            taHomePage(sc, ta, courseCatalog);
        }
        else {
            throw new InvalidLoginException("Invalid Password");
        }
    }
    catch (InvalidLoginException e){
        System.out.println(e.getMessage());
    }
    }

    private static void taHomePage(Scanner sc, TeachingAssistant ta, courseCatalog courseCatalog) {
        while (true) {
            System.out.println("1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. Remove Course");
            System.out.println("4. Submit Complaint");
            System.out.println("5. View Complaints");
            System.out.println("6. View Grades");
            System.out.println("7. View my courses");
            System.out.println("8. Give Feedback");
            System.out.println("9. View Assigned Courses");
            System.out.println("10. View Student Grades");
            System.out.println("11. Assign Grades");
            System.out.println("12. Logout");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    courseCatalog.displayCatalog();
                    break;
                case 2:
                    System.out.print("Enter course name: ");
                    String courseNameToAdd = sc.nextLine();
                    Course courseToAdd = courseCatalog.findCourseByName(courseNameToAdd);
                    if (courseToAdd != null) {
                        ta.addCourse(courseToAdd);
                    }
                    else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 3:
                    int cur_week = 11;
                    System.out.print("Enter course name to remove: ");
                    String courseNameToRemove = sc.nextLine();
                    Course courseToRemove = courseCatalog.findCourseByName(courseNameToRemove);

                    //Course Drop Deadline Exception Handling
                    try {
                        if (courseToRemove != null) {
                            ta.removeMyCourse(courseToRemove, cur_week);
                            System.out.println("Course removed successfully.");
                        }
                    }
                    catch (CourseDropDeadlineException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter your complaint: ");
                    String complaintDescription = sc.nextLine();
                    ta.submitComplaint(complaintDescription);
                    break;
                case 5:
                    ta.viewComplaints();
                    break;
                case 6:
                    ta.viewGrades();
                    break;
                case 7:
                    ta.viewCourses();
                    break;
                case 8:
                    System.out.print("Enter course name to give feedback: ");
                    String feedbackCourseName = sc.nextLine();
                    Course feedbackCourse = courseCatalog.findCourseByName(feedbackCourseName);
                    if (feedbackCourse != null && ta.getCourses().contains(feedbackCourse)) {
                        System.out.print("Enter rating (1-5) or press Enter to skip: ");
                        String ratingInput = sc.nextLine();
                        Integer rating = ratingInput.isEmpty() ? null : Integer.parseInt(ratingInput);

                        System.out.print("Enter feedback comment or press Enter to skip: ");
                        String comment = sc.nextLine();

                        ta.submitFeedback(feedbackCourse, rating, comment);
                    }
                    else {
                        System.out.println("Course not found or you haven't completed this course.");
                    }
                    break;
                case 9:
                    ta.viewAssignedCourses();
                    break;
                case 10:
                    System.out.print("Enter course name to view grades: ");
                    String courseNameToView = sc.nextLine();
                    Course courseToView = courseCatalog.findCourseByName(courseNameToView);
                    if (courseToView != null) {
                        ta.viewStudentGrades(courseToView);
                    }
                    else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 11:
                    System.out.print("Enter course name to assign grades: ");
                    String courseNameToGrade = sc.nextLine();
                    Course courseToGrade = courseCatalog.findCourseByName(courseNameToGrade);
                    if (courseToGrade != null) {
                        System.out.print("Enter student name to assign grade: ");
                        String studentName = sc.nextLine();
                        Student studentToGrade = Student_records.getStudentByName(studentName);
                        if (studentToGrade != null) {
                            System.out.print("Enter grade (0-10): ");
                            int grade = sc.nextInt();
                            sc.nextLine();
                            ta.setGrade(studentToGrade, courseToGrade, grade);
                        }
                        else {
                            System.out.println("Student not found.");
                        }
                    }
                    else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 12:
                    System.out.println("Logging out");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }




    private static void signUpStudent(Scanner sc) {
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Contact: ");
        String contact = sc.nextLine();
        System.out.println("Semester: ");
        int semester = sc.nextInt();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        ArrayList<Course> s1Courses = new ArrayList<>();
        ArrayList<Complaints> s1Complaints = new ArrayList<>();
        Student s1 = new Student(name, contact, semester, s1Courses, s1Complaints);
        s1.email = email;
        s1.password = password;

        Student_records.addStudent(s1);

        System.out.println("Student registration successful.");
    }

    private static void loginStudent(Scanner sc, courseCatalog courseCatalog) {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        //Exception Handling for Invalid Login
    try {
        Student s1 = Student_records.getAllStudents().stream()
                .filter(student -> student.email.equals(email))
                .findFirst().orElseThrow(() -> new InvalidLoginException("Invalid email"));

        if (s1 != null && s1.getPassword().equals(password)) {
            System.out.println("Logged in");
            studentHomePage(sc, s1, courseCatalog);
        }
        else {
            throw new InvalidLoginException("Invalid password");
        }
    }
    catch(InvalidLoginException e){
        System.out.println(e.getMessage());
    }
    }

    private static void signUpProfessor(Scanner sc) {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        ArrayList<Course> myCourses = new ArrayList<>();

        professors.put(email, new Professor(name, myCourses, email, password));
        System.out.println("Professor registration successful.");
    }


    private static void loginProfessor(Scanner sc) {
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();


        //Exception Handling for Invalid Login
    try{
        if (!professors.containsKey(email)){
            throw new InvalidLoginException("Invalid email");
        }
        Professor professor = professors.get(email);
        if (professor.getPassword().equals(password)){
            System.out.println("Welcome, You have successfully logged in.");
            professorHomePage(sc, professor);
        }
        else {
            throw new InvalidLoginException("Invalid password");
        }
    }
    catch(InvalidLoginException e){
        System.out.println(e.getMessage());
    }
    }



    private static void studentHomePage(Scanner sc, Student student, courseCatalog courseCatalog) {
        while (true) {
            System.out.println("\nWelcome, " + student.name + "!");
            System.out.println("1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. Remove Course");
            System.out.println("4. Submit Complaint");
            System.out.println("5. View Complaints");
            System.out.println("6. View Grades");
            System.out.println("7. View my courses");
            System.out.println("8. Give Feedback");
            System.out.println("9. Logout");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    courseCatalog.displayCatalog();
                    break;
                case 2:
                    System.out.print("Enter course name to add: ");
                    String courseNameToAdd = sc.nextLine();
                    Course courseToAdd = courseCatalog.findCourseByName(courseNameToAdd);
                    if (courseToAdd != null) {

                        //Exception Handling for Invalid Course Registeration done inside addCourse function
                        student.addCourse(courseToAdd);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 3:
                    int cur_week = 11;
                    //To input what week is it right now, setting value to 11 by default
//                    System.out.println("What week is it right now?");
//                    int cur_week = sc.nextInt();
//                    sc.nextLine();
                    System.out.print("Enter course name to remove: ");
                    String courseNameToRemove = sc.nextLine();
                    Course courseToRemove = courseCatalog.findCourseByName(courseNameToRemove);


            //Implemented Course Drop Deadline Exception inside removeMyCourse method in Student class
                try{
                    if (courseToRemove != null) {
                        student.removeMyCourse(courseToRemove, cur_week);
                        System.out.println("Course removed successfully.");
                    }
                    }
                catch(CourseDropDeadlineException e){
                    System.out.println(e.getMessage());
                }
                    break;
                case 4:
                    System.out.print("Enter your complaint: ");
                    String complaintDescription = sc.nextLine();
                    student.submitComplaint(complaintDescription);
                    break;
                case 5:
                    student.viewComplaints();
                    break;
                case 6:
                    student.viewGrades();
                    break;
                case 7:
                    student.viewCourses();
                    break;
                case 8:
                    System.out.print("Enter course name to give feedback: ");
                    String feedbackCourseName = sc.nextLine();
                    Course feedbackCourse = courseCatalog.findCourseByName(feedbackCourseName);
                    if (feedbackCourse != null && student.getCourses().contains(feedbackCourse)) {
                        System.out.print("Enter rating (1-5) or press Enter to skip: ");
                        String ratingInput = sc.nextLine();
                        Integer rating = ratingInput.isEmpty() ? null : Integer.parseInt(ratingInput);

                        System.out.print("Enter feedback comment or press Enter to skip: ");
                        String comment = sc.nextLine();

                        student.submitFeedback(feedbackCourse, rating, comment);
                    } else {
                        System.out.println("Course not found or you haven't completed this course.");
                    }
                    break;
                case 9:
                    System.out.println("Logging out");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void professorHomePage(Scanner sc, Professor professor) {
        while (true) {
            System.out.println("1. View My Courses");
            System.out.println("2. Update Course Details");
            System.out.println("3. View Enrolled Students");
            System.out.println("4. View All Enrolled Students (all courses)");
            System.out.println("5. View Course Feedback");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    ArrayList<Course> s = professor.getMyCourses();
                    for (Course course1: s){
                        course1.displayCourse();
                        System.out.println();
                    }
                    break;
                case 2:
                    updateCourseDetails(sc, professor);
                    break;
                case 3:
                    System.out.println("Enter name of course: ");
                    String name = sc.nextLine();
                    Course course = findCourseByCode(name, professor.getMyCourses());
                    professor.viewEnrolledStudents(course);
                    break;
                case 4:
                    professor.viewAllEnrolledStudents();
                    break;
                case 5:
                    System.out.print("Enter the code of the course: ");
                    String feedbackCourseCode = sc.nextLine();
                    Course feedbackCourse = findCourseByCode(feedbackCourseCode, professor.getMyCourses());
                    if (feedbackCourse != null) {
                        professor.viewCourseFeedback(feedbackCourse);
                    } else {
                        System.out.println("Course not found. Please enter a valid course name.");
                    }
                    break;
                case 6:
                    System.out.println("Logging out");
                    return;
                default:
                    System.out.println("Invalid.");
            }
        }
    }
    private static void updateCourseDetails(Scanner sc, Professor professor) {
        System.out.println("Select a course to update:");
        ArrayList<Course> courses = professor.getMyCourses();
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i+1) + ". " + courses.get(i).getTitle());
        }
        System.out.print("Enter the index of the course to update: ");
        int courseChoice = sc.nextInt();
        sc.nextLine();
        if (courseChoice < 1 || courseChoice > courses.size()) {
            System.out.println("Invalid course selection.");
            return;
        }
        Course selectedCourse = courses.get(courseChoice - 1);

        while (true) {
            System.out.println("\nUpdate options for " + selectedCourse.getTitle() + ":");
            System.out.println("1. Update Syllabus");
            System.out.println("2. Update Class Timings");
            System.out.println("3. Update Credits");
            System.out.println("4. Update Prerequisites");
            System.out.println("5. Update Enrollment Limit");
            System.out.println("6. Update Office Hours");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new syllabus: ");
                    String syllabus = sc.nextLine();
                    professor.setSyllabus(selectedCourse, syllabus);
                    break;
                case 2:
                    System.out.print("Enter new class timings: ");
                    String timings = sc.nextLine();
                    professor.setTimings(selectedCourse, timings);
                    break;
                case 3:
                    System.out.print("Enter new credit value: ");
                    int credits = sc.nextInt();
                    sc.nextLine();
                    professor.setCredits(selectedCourse, credits);
                    break;
                case 4:
//prereqs add here -- missing
                    updatePrerequisites(sc, professor, selectedCourse);
                    break;
                case 5:
                    System.out.print("Enter new enrollment limit: ");
                    int limit = sc.nextInt();
                    sc.nextLine();
                    professor.setEnrollmentLimit(selectedCourse, limit);
                    break;
                case 6:
                    System.out.print("Enter new office hours: ");
                    String officeHours = sc.nextLine();
                    professor.setOfficeHours(selectedCourse, officeHours);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println("Course updated successfully.");
        }
    }

    private static void updatePrerequisites(Scanner sc, Professor professor, Course course) {
        while (true) {
            System.out.println("\nPrerequisite options:");
            System.out.println("1. Add Prerequisite");
            System.out.println("2. Remove Prerequisite");
            System.out.println("3. Back to Course Update Menu");
            System.out.print("Choose an option:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter prerequisite course code to add: ");
                    String addCode = sc.nextLine();
                    Course prereqToAdd = findCourseByCode(addCode, professor.getMyCourses());
                    if (prereqToAdd != null) {
                        professor.addPrereq(course);
                        System.out.println("Prerequisite added successfully.");
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter prerequisite course code to remove: ");
                    String removeCode = sc.nextLine();
                    Course prereqToRemove = findCourseByCode(removeCode, course.getPrereqs());
                    if (prereqToRemove != null) {
                        professor.removePrereq(prereqToRemove);
                        System.out.println("Prerequisite removed");
                    } else {
                        System.out.println("Course not found");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static Course findCourseByCode(String code, ArrayList<Course> courses) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    private static void adminHomePage(Scanner sc, Admin admin, courseCatalog catalog) {
        while (true) {
            System.out.println("\nWelcome, Admin ");
            System.out.println("1. Manage Course Catalog");
            System.out.println("2. Manage Student Records");
            System.out.println("3. Assign professors to courses");
            System.out.println("4. Handle Complaints");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    manageCourses(sc, admin, catalog);
                    break;
                case 2:
                    manageStudentRecords(sc, admin);
                    break;
                case 3:
                    assignProfessors(sc, admin, catalog);
                    break;
                case 4:
                    handleComplaints(sc, admin);
                    break;
                case 5:
                    System.out.println("Logging out");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    //Manage courses
    private static void manageCourses(Scanner sc, Admin admin, courseCatalog catalog) {
        while (true) {
            System.out.println("1. Add a course");
            System.out.println("2. Remove a course");
            System.out.println("3. View catalog");
            System.out.println("5. Return to main menu");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addCourse(sc, catalog);
                    break;
                case 2:
                    removeCourse(sc, catalog);
                    break;
                case 3:
                    catalog.displayCatalog();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addCourse(Scanner sc, courseCatalog catalog) {
        System.out.print("Enter course code: ");
        String code = sc.nextLine();
        System.out.print("Enter course title: ");
        String title = sc.nextLine();
        System.out.print("Enter credits: ");
        int credits = sc.nextInt();
        sc.nextLine();

//Error here maybe
        System.out.print("Enter prerequisites (comma-separated course codes): ");
        String prereqsInput = sc.nextLine();
        ArrayList<Course> prereqs = new ArrayList<>();

        if (!prereqsInput.trim().isEmpty()) {
            String[] prereqCodes = prereqsInput.split(",");
            for (String prereqCode : prereqCodes) {
                prereqCode = prereqCode.trim();

                Course prereqCourse = catalog.findCourseByName(prereqCode);
                if (prereqCourse != null) {
                    prereqs.add(prereqCourse);
                } else {
                    System.out.println("Course with code " + prereqCode + " not found in the catalog.");
                }
            }
        }
        ArrayList<Course> myCourses = new ArrayList<>();
        System.out.print("Enter syllabus: ");
        String syllabus = sc.nextLine();
        System.out.print("Enter enrollment limit: ");
        int enrollmentLimit = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter office hours: ");
        String officeHours = sc.nextLine();
        System.out.print("Enter timings: ");
        String timings = sc.nextLine();
//            public Professor(String name, ArrayList<Course> myCourses, String email, String password)
        System.out.println("Enter professor name: ");
        String p1_name = sc.nextLine();
        Professor p1 = findProfessorByName(p1_name);
        System.out.println("Enter Course Drop Deadline week: ");
        int d1 = sc.nextInt();
        sc.nextLine();
        Course newCourse = new Course(code, title, credits, prereqs, syllabus, enrollmentLimit, officeHours, timings, p1, d1);
        catalog.addCourse(newCourse);
        System.out.println("Course added successfully.");
    }

    private static void removeCourse(Scanner sc, courseCatalog catalog) {
        System.out.print("Enter the name of the course to remove: ");
        String courseName = sc.nextLine();
        Course courseToRemove = catalog.findCourseByName(courseName);
        if (courseToRemove != null) {
            catalog.removeCourse(courseToRemove);
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

//Manage styudent records
public static void manageStudentRecords(Scanner sc, Admin admin) {
    int choice = -1;
    while (choice != 0) {
        System.out.println("1. Update student grades");
        System.out.println("2. View all students");
        System.out.println("3. Search for a student by name");
        System.out.println("4. Update student information");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter name of student: ");
                String name2 = sc.nextLine();

                System.out.println("Enter course title:");
                String title = sc.nextLine();
                System.out.println("Enter grade: ");
                Double grade = sc.nextDouble();
                admin.updateStudentGrade(name2, title, grade);
                //after semestergrade check
                break;

            case 2:
                admin.viewAllStudentRecords();
                break;
            case 3:
                System.out.print("Enter student name to search: ");
                String name = sc.nextLine();
                admin.viewStudentRecord(name);
                break;
            case 4:
                System.out.println("Enter name of student: ");
                String name1 = sc.nextLine();
                System.out.println("Update name or contact? (name/contact)");
                String type = sc.nextLine();
                System.out.println("Enter new value: ");
                String newValue = sc.nextLine();
                admin.updateStudentInfo(name1, type,newValue);
                break;
            case 0:
                System.out.println("Exiting");
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }
}


    //For assigning professors
    private static void assignProfessors(Scanner sc, Admin admin, courseCatalog catalog) {
        System.out.print("Enter the professor's code: ");
        String professorName = sc.nextLine();

        Professor professor = findProfessorByName(professorName);

        if (professor == null) {
            System.out.println("Professor not found.");
            return;
        }

        System.out.println("Available Courses:");
        catalog.displayCatalog();

        System.out.print("Enter the course title to assign: ");
        String courseTitle = sc.nextLine();

        Course course = catalog.findCourseByName(courseTitle);

        if (course != null) {
            if (course.getProfessor() == null) {
                admin.assignProfessorToCourse(professor, course);
                System.out.println("Professor " + professor.name + " has been assigned to " + course.getTitle());
            } else {
                System.out.println("This course already has a professor assigned.");
            }
        } else {
            System.out.println("Course not found.");
        }
    }

    private static Professor findProfessorByName(String professorName){
        return professors.get(professorName);
    }



    //For handling complaints

    private static void handleComplaints(Scanner sc, Admin admin) {

        ArrayList<Student> allStudents = Student_records.getAllStudents();

        admin.viewAllComplaints(allStudents);

        System.out.print("Enter the name of the student to resolve a complaint: ");
        String studentName = sc.nextLine();

        Student student = Student_records.getStudentByName(studentName);

        if (student != null) {
            ArrayList<Complaints> complaints = student.getComplaints();
            if (complaints.isEmpty()) {
                System.out.println("No complaints found for this student.");
                return;
            }

            System.out.println("Complaints by " + student.name + ":");
            for (int i = 0; i < complaints.size(); i++) {
                System.out.println((i + 1) + ". " + complaints.get(i).getDescription() + " (" + complaints.get(i).getStatus() + ")");
            }

            System.out.print("Select a complaint number to resolve: ");
            int complaintIndex = sc.nextInt() - 1;
            sc.nextLine();

            if (complaintIndex >= 0 && complaintIndex < complaints.size()) {
                System.out.print("Enter resolution: ");
                String resolution = sc.nextLine();
                admin.resolveComplaint(student, complaintIndex, resolution);
                System.out.println("Complaint resolved.");
            } else {
                System.out.println("Invalid complaint selection.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

}
