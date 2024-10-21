import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class ColourList {

    public static void main(String[] args) {
       
        LinkedList<String> colours = new LinkedList<>();
        colours.add("red");
        colours.add("blue");
        colours.add("yellow");
        colours.add("orange");

  
        System.out.println("List of colours:");
        Iterator<String> iterator = colours.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        System.out.println("\nList of colours in reverse order:");
        ListIterator<String> listIterator = colours.listIterator(colours.size()); // Start at the end of the list
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        
        LinkedList<String> additionalColours = new LinkedList<>();
        additionalColours.add("pink");
        additionalColours.add("green");

        int index = colours.indexOf("blue") + 1; 

   
        System.out.println("\nModified List after inserting pink and green:");
        for (String colour : colours) {
            System.out.println(colour);
        }
    }
}
