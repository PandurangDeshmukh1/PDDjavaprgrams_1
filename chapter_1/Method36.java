public class Method36 {
    public static void main(String[] args) {
        String str = "radar";
        System.out.println(str + " is palindrome: " + isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}
