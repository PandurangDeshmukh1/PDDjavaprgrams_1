public class Active_loop3 {
    public static void main(String[] args) {
        int number = 1;

        while (number <= 30) {
            System.out.print(number + ": ");

            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("Multiple of both 3 and 5");
            } else if (number % 3 == 0) {
                System.out.println("Multiple of 3");
            } else if (number % 5 == 0) {
                System.out.println("Multiple of 5");
            } else {
                System.out.println("Not a multiple of 3 or 5");
            }

            number++;
        }

        System.out.println("Loop completed.");
    }
}
