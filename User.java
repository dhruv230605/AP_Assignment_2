abstract class User {
    public abstract String getPassword();
    public abstract String getEmail();
    abstract void viewCourses();
    abstract void addMyCourse(Course course);
    abstract void removeMyCourse(Course course);
}
