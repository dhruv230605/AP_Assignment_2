import java.util.ArrayList;

public class courseSchedule extends Course {
    private String timings;
    private String location;
    private Professor professor;

    public courseSchedule(String code, String title, int credits, ArrayList<Course> prereqs,String syllabus,int enrollmentLimit, String officeHours, String timings, String location, Professor professor, int dropWeek) {
        super(code, title, credits, prereqs, syllabus, enrollmentLimit, officeHours, timings, professor, dropWeek);
        this.timings = timings;
        this.location = location;
        this.professor = professor;
    }
//    //For professor
//    public courseSchedule(String code, String title,String syllabus, int credits, ArrayList<Course> prereqs, int enrollmentLimit, String officeHours, String timings, String location, Professor professor){
//        super(code, title, syllabus, credits, prereqs, enrollmentLimit, officeHours);
//        this.timings = timings;
//        this.location = location;
//        this.professor = professor;
//    }

    //Accessors
    public String getTimings(){return timings;}
    public String getLocation(){return location;}
    public Professor getProfessor() {return professor;}


    //Mutators
    public void setTimings(String timings){this.timings = timings;}

    // Display course schedule details
    @Override
    public void displayCourse() {
        super.displayCourse();
        System.out.println("Timings: " +timings);
        System.out.println("Location: " +location);
        System.out.println("Professor: " +professor.name);
    }
    public void displayCourse2() {
        System.out.println("Timings: " +timings);
        System.out.println("Location: " +location);
        System.out.println("Professor: " +professor);
    }

}
