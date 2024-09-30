public class studentArray16 {
    public static void main(String[] args) {
        int[][] array1 = {
            {1, 2},
            {3, 4}
        };

        int[][] array2 = {
            {5, 6},
            {7, 8}
        };

        int rows = array1.length;
        int cols = array2[0].length;
        int[][] product = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < array1[0].length; k++) {
                    product[i][j] += array1[i][k] * array2[k][j];
                }
            }
        }

        System.out.println("Product of the two arrays:");
        for (int[] row : product) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
//product of two array using 2D array.
