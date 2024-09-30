import java.util.LinkedHashMap;
import java.util.Map;

public class StringJava23 {
    public static void main(String[] args) {
        String str = "swiss";
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        char firstNonRepeating = '\0';
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                firstNonRepeating = entry.getKey();
                break;
            }
        }

        System.out.println("First non-repeating character: " + firstNonRepeating);
    }
}
