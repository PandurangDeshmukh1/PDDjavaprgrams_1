public class StringJava18 {
    public static void main(String[] args) {
        String str = "Hello, World!";
        int vowelCount = 0;
        for (char c : str.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1) {
                vowelCount++;
            }
        }
        System.out.println("Number of vowels: " + vowelCount);
    }
}
//Number of value using String 