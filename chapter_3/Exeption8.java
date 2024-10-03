public class Exeption8 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        try {
            System.out.println("Accessing index 5: " + numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds. Please check the array size.");
        }

        System.out.println("Program continues after the exception.");
    }
}

