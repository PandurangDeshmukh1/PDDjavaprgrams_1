import java.util.ArrayList;
import java.util.Iterator;

public class collection {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ajay");

        Iterator<String> itr = al.iterator(); 
        while (itr.hasNext()) {
            System.out.println(itr.next()); 
        }
        al.add("Sita");
        System.out.println("Add another name"+al);
        al.set(al.indexOf("Ajay"), "Rahul");
    System.out.println("After replacing Ajay with Rahul: " + al);
    al.remove(1);
    System.out.println("Remove the name of "+1);
    }

}
