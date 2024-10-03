public class StringConstructor5 {
    public static void main(String[] args) {
        byte[] byteArray = {72, 101, 108, 108, 111}; // ASCII for "Hello"
        String str = new String(byteArray);
        System.out.println("String from byte array: " + str);
    }
}
