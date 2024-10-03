import java.util.HashSet;

public class HashDemo {
    public static void main(String[] args) {
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("Item 0");
        hashSet1.add("Item 1");
        hashSet1.add("Item 2");
        hashSet1.add("Item 3");
        hashSet1.add("Item 4");
        hashSet1.add("Item 5");
        System.out.println(hashSet1);
        hashSet1.remove(1);
        System.out.println(hashSet1);
    }
}
