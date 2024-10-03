import java.util.TreeSet;
import java.util.*;
public class TreesetDemo {
    public static void main(String[] args) {
        TreeSet treeSet1 =new TreeSet<>();
        treeSet1.add("Mango");
        treeSet1.add("banana");
        treeSet1.add("greps");
        treeSet1.add("Tomato");
       System.out.println(treeSet1);
       treeSet1.remove("banana");
       System.out.println(treeSet1);
      
    }
}
