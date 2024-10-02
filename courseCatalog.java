import java.util.ArrayList;

public class courseCatalog {
    private ArrayList<Course> courses;

    public courseCatalog() {
        this.courses = new ArrayList<>();
    }

//Admin can add and remove courses
    public void addCourse(Course course) {
        courses.add(course);
    }
    public void removeCourse(Course course){
        courses.remove(course);
    }

    public void displayCatalog() {
        System.out.println("Course Catalog:");
        for (Course course : courses) {
            course.displayCourse();
            System.out.println();
        }
    }
    public Course findCourseByName(String courseName) {
        for (Course course : courses) {
            if (course.getTitle().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}

