import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple");  // Duplicate, won't be added
        System.out.println("HashSet: " + hashSet);

        hashSet.remove("Banana");
        System.out.println("After removing Banana: " + hashSet);

        System.out.println("HashSet contains Cherry: " + hashSet.contains("Cherry"));
        System.out.println("Size of HashSet: " + hashSet.size());
    }
}
