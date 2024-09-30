public class Method33 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 8, 1};
        System.out.println("Minimum value: " + findMinimum(arr));
    }

    public static int findMinimum(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) min = num;
        }
        return min;
    }
}
// minimum  in aaray;
