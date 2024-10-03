import java.util.*;

public class LibraryBooks {
    public static void main(String[] args) {
        Map<String, Integer> books = new HashMap<>();
        books.put("1984", 5);
        books.put("To Kill a Mockingbird", 2);
        books.put("The Great Gatsby", 3);

        for (Map.Entry<String, Integer> entry : books.entrySet()) {
            System.out.println("Book: " + entry.getKey() + ", Copies: " + entry.getValue());
        }
    }
}
