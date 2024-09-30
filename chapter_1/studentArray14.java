public class studentArray14 {
    public static void main(String[] args) {
        int[][] array = {
            {3, 5, 7},
            {2, 8, 1},
            {6, 4, 9}
        };

        int max = array[0][0];
        for (int[] row : array) {
            for (int num : row) {
                if (num > max) {
                    max = num;
                }
            }
        }

        System.out.println("Maximum element: " + max);
    }
}
// element of array using two daimention array
