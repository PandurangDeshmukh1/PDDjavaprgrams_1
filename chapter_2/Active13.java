public class Active01{
    public static void main(String[] args) {
        int number = 1;

        while (number <= 40) {
            System.out.print(number + ": ");

            if (number % 2 == 0) {
                System.out.println("Even");
            } else {
                System.out.println("Odd");
            }

            number++;
        }

        System.out.println("Loop completed.");
    }
}

