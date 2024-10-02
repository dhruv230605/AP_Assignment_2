import java.util.ArrayList;

public class TA_records {
    private static ArrayList<TeachingAssistant> allTAs = new ArrayList<>();

    public static void addTA(TeachingAssistant ta) {
        allTAs.add(ta);
    }

    public static ArrayList<TeachingAssistant> getAllTAs() {
        return allTAs;
    }

    public static TeachingAssistant findTAByEmail(String email) {
        return allTAs.stream().filter(ta -> ta.getEmail().equals(email)).findFirst().orElse(null);
    }
}

