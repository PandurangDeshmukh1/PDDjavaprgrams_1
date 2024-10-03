import java.util.HashSet;

public class UniqueNumbers {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(20);  // Duplicate, won't be added

        System.out.println("HashSet: " + numbers);

        numbers.remove(30);
        System.out.println("After removing 30: " + numbers);

        System.out.println("HashSet contains 40: " + numbers.contains(40));
        System.out.println("Size of HashSet: " + numbers.size());
    }
}
