import java.util.*;

public class StudentGrades {
    public static void main(String[] args) {
        Map<String, Character> grades = new HashMap<>();
        grades.put("Alice", 'A');
        grades.put("Bob", 'B');
        grades.put("Charlie", 'C');

        for (Map.Entry<String, Character> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
