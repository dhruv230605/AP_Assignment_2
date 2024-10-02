import java.time.LocalDate;

public class Complaints {
    private final String description;
    private String status;
    private final LocalDate date;
    private String resolution;

    public Complaints (String description){
        this.description = description;
        this.status = "Pending";
        this.date = LocalDate.now();
        this.resolution = "";
    }

    // Accessors
    public String getDescription() {return description;}
    public String getStatus() {return status;}
    public LocalDate getDate() {return date;}
    public String getResolution() {return resolution;}

    //Mutators for admin only
    public void setStatus(String status) {this.status = status;}
    public void setResolution(String resolution) {this.resolution = resolution;}

    // Complaint display
    public void displayComplaint() {
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
        System.out.println("Date: " + date);
        System.out.println("Resolution: " + resolution);
    }
}
