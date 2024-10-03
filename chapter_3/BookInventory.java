import java.util.*;

public class BookInventory {
    public static void main(String[] args) {
        Hashtable<String, Integer> inventory = new Hashtable<>();
        inventory.put("1984", 5);
        inventory.put("To Kill a Mockingbird", 2);
        inventory.put("The Great Gatsby", 3);

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Book: " + entry.getKey() + ", Copies: " + entry.getValue());
        }
    }
}
