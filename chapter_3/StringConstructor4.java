public class StringConstructor4 {
    public static void main(String[] args) {
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str = new String(charArray, 1, 3); // Creates "ell"
        System.out.println("String from char array (offset and count): " + str);
    }
}
