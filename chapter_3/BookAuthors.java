import java.util.*;

public class BookAuthors {
    public static void main(String[] args) {
        Map<String, String> authors = new HashMap<>();
        authors.put("The Hobbit", "J.R.R. Tolkien");
        authors.put("Pride and Prejudice", "Jane Austen");
        authors.put("Moby Dick", "Herman Melville");

        for (Map.Entry<String, String> entry : authors.entrySet()) {
            System.out.println("Book: " + entry.getKey() + ", Author: " + entry.getValue());
        }
    }
}
