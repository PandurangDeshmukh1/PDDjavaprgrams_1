import java.util.Scanner;

public class GreetUser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        String upperCaseName = userName.toUpperCase();
        System.out.println("Hello, " + upperCaseName + ", nice to meet you!");

        scanner.close();
    }
}
