import java.util.Arrays;

public class Method35 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3};
        sortArray(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void sortArray(int[] array) {
        Arrays.sort(array);
    }
}
// serial stored array in method 
