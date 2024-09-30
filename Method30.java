public class Method30 {
    public static void main(String[] args) {
        int base = 2, exponent = 3;
        System.out.println(base + " raised to the power of " + exponent + " is: " + power(base, exponent));
    }

    public static int power(int base, int exp) {
        if (exp == 0) return 1;
        return base * power(base, exp - 1);
    }
}
// calculate the power of Number 
