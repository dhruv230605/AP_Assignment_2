import java.util.ArrayList;
import java.util.List;

public class GPACalculator {
    private ArrayList<Double> semesterGPAs;
    private double cgpa;

    public GPACalculator() {
        this.semesterGPAs = new ArrayList<>();
        this.cgpa = 0.0;
    }

    public double calculateSGPA(List<Course> courses) {
        if (courses.isEmpty()) {
            return 0.0;
        }
        double totalGradePoints = 0.0;
        int totalCredits = 0;

        for (Course course : courses) {
            totalGradePoints += course.getGrade() * course.getCredits();
            totalCredits += course.getCredits();
        }
        double sgpa = totalGradePoints / totalCredits;
        semesterGPAs.add(sgpa);
        updateCGPA();
        return sgpa;
    }

    private void updateCGPA() {
        if (semesterGPAs.isEmpty()) {
            cgpa = 0.0;
            return;
        }
        double totalGPA = 0.0;
        for (double sgpa : semesterGPAs) {
            totalGPA +=sgpa;
        }

        cgpa = totalGPA /semesterGPAs.size();
    }
    public double getCGPA() {
        return cgpa;
    }

    public ArrayList<Double> getSemesterGPAs() {
        return new ArrayList<>(semesterGPAs);
    }
}
