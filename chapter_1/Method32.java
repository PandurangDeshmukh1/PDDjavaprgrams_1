public class Method32 {
    public static void main(String[] args) {
        int number = 12345;
        System.out.println("Number of digits in " + number + ": " + countDigits(number));
    }

    public static int countDigits(int n) {
        return String.valueOf(n).length();
    }
}
//find last digite 