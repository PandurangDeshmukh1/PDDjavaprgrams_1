import java.util.ArrayList;
import java.util.Iterator;

public class Remove {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ajay");

        // Adding a new name
        al.add("Sita");
        System.out.println("After adding Sita: " + al);

        // Removing a name
        al.remove("Vijay");
        System.out.println("After removing Vijay: " + al);

        // Replacing a name
        al.set(al.indexOf("Ajay"), "Rahul");
        System.out.println("After replacing Ajay with Rahul: " + al);

        // Iterating over the list
        System.out.println("Final list of names:");
        Iterator<String> itr = al.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
