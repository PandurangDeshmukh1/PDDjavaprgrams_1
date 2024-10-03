import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exeption5 {
    public static void main(String[] args) {
        try {
            File file = new File("nonexistent.txt");
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please check the file path.");
        }

        System.out.println("Program continues after the exception.");
    }
}
