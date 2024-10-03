class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}

public class Throws6 {
    public static void main(String[] args) {
        try {
            validateAge(-5);
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateAge(int age) throws AgeException {
        if (age < 0) {
            throw new AgeException("Error: Age cannot be negative.");
        }
        System.out.println("Valid age: " + age);
    }
}
