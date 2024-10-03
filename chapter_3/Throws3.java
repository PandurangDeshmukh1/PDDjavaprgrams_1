public class Throws3 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        try {
            System.out.println("Accessing index 5: " + accessArray(numbers, 5));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds.");
        }
    }

    public static int accessArray(int[] array, int index) throws ArrayIndexOutOfBoundsException {
        return array[index];
    }
}

