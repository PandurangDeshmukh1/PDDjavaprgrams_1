import java.util.*;

public class CountryCapitals {
    public static void main(String[] args) {
        Map<String, String> capitals = new HashMap<>();
        capitals.put("USA", "Washington, D.C.");
        capitals.put("France", "Paris");
        capitals.put("Japan", "Tokyo");

        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            System.out.println("Capital of " + entry.getKey() + ": " + entry.getValue());
        }
    }
}

