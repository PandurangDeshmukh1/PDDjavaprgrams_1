public class Method34 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 8, 1};
        System.out.println("Maximum value: " + findMaximum(arr));
    }

    public static int findMaximum(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }
}
// find maximum number in array 