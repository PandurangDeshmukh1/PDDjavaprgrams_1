public class Throws4 {
    public static void main(String[] args) {
        String str = null;

        try {
            System.out.println("String length: " + getStringLength(str));
        } catch (NullPointerException e) {
            System.out.println("Error: Cannot get the length of a null string.");
        }
    }

    public static int getStringLength(String str) throws NullPointerException {
        return str.length();
    }
}
