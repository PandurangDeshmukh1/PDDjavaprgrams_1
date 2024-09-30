import java.util.Arrays;
import java.util.HashSet;

public class Metho38 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        int[] uniqueArray = removeDuplicates(arr);
        System.out.println("Array without duplicates: " + Arrays.toString(uniqueArray));
    }

    public static int[] removeDuplicates(int[] array) {
        return new HashSet<>(Arrays.asList(Arrays.stream(array).boxed().toArray(Integer[]::new))).stream()
                .mapToInt(Integer::intValue).toArray();
    }
}
// without duplicate 
