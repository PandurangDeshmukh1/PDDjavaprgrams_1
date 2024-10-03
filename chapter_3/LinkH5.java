import java. util.*;
public class LinkH5 {
    public static void main(String[] args) {
        LinkedHashSet<String> is =new LinkedHashSet<>();
        is.add("Cafe Latte.....");
        is.add("Expresso......");
        is.add("Cafe Borgia");
        is.add("Cappiccian");
        Iterator<String> i=is.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        is.remove("Cafe Latte.....");
        System.out.println(is);
    }
}
