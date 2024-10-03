public class Exeption3 {
    public static void main(String[] args) {
        String str = null;

        try {
            System.out.println("String length: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Error: Cannot get the length of a null string.");
        }

        System.out.println("Program continues after the exception.");
    }
}

