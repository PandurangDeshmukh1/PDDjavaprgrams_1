import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private boolean isAvailable;

    public Book(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.isAvailable()) {
                book.borrow();
                return book;
            }
        }
        System.out.println("Book not available!");
        return null;
    }

    public void returnBook(Book book) {
        book.returnBook();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("1984"));
        library.addBook(new Book("Brave New World"));

        Book borrowedBook = library.borrowBook("1984");
        if (borrowedBook != null) {
            System.out.println("Borrowed: " + borrowedBook.getTitle());
        }

        library.returnBook(borrowedBook);
        System.out.println("Returned: " + borrowedBook.getTitle());
    }
}
