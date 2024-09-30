public class StaticBlock48 {
    static int i; 
    
    static {
        i = 10;
        System.out.println("Static Block called");
    }

    public static void main(String[] args) {
        System.out.println(StaticBlock48.i);
    }
}
