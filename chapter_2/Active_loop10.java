public class Active_loop10 {
    public static void main(String[] args) {
        int number = 40;

        while (number >= 1) {
            System.out.print(number + ": ");

            if (number > 20) {
                System.out.println("High");
            } else {
                System.out.println("Low");
            }

            number--;
        }

        System.out.println("Countdown completed.");
    }
}
