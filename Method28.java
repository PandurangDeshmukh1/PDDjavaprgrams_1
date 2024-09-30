public class Method28 {
    public static void main(String[] args) {
        int number = 29;
        System.out.println(number + " is prime: " + isPrime(number));
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
// check prime number 