public class StringConstructor6 {
    public static void main(String[] args) {
        byte[] byteArray = {72, 101, 108, 108, 111};
        String str = new String(byteArray, 1, 3); // Creates "el"
        System.out.println("String from byte array (offset and length): " + str);
    }
}
