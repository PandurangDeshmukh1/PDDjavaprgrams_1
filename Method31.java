public class Method31 {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println("Reversed String: " + reverseString(str));
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
// reverse String 