public class Method29 {
    public static void main(String[] args) {
        int a = 54, b = 24;
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
// find gretest GCD (Gretest comman discover)