public class Feedback {
    private String courseTitle;
    private String studentName;
    private GenericFeedback<Integer> numericFeedback;
    private GenericFeedback<String> textualFeedback;

    public Feedback(Course course, Student student, Integer rating, String comment) {
        this.courseTitle = course.getTitle();
        this.studentName = student.name;
        this.numericFeedback = new GenericFeedback<>(rating);
        this.textualFeedback = new GenericFeedback<>(comment);
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getNumericFeedback() {
        return numericFeedback.getFeedback();
    }

    public String getTextualFeedback() {
        return textualFeedback.getFeedback();
    }

    public void displayFeedback() {
        System.out.println("Feedback for course: " + courseTitle);
        System.out.println("Student: " + studentName);
        System.out.println("Rating: " + (numericFeedback.getFeedback() != null ? numericFeedback.getFeedback() : ""));
        System.out.println("Comment: " + (textualFeedback.getFeedback() != null ? textualFeedback.getFeedback() : ""));
    }
}

