public class Exeption10 {
    public static void main(String[] args) {
        String number = "abc";

        try {
            int result = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter a valid integer.");
        }

        System.out.println("Program continues after the exception.");
    }
}

