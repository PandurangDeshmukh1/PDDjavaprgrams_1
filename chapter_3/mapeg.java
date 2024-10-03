import java.util.*;
public class mapeg {
    public static void main(String[] args) {
        Map<Integer,String> mp=new HashMap<>();
        mp.put(11, "Mango");
        mp.put(12, "Banana");
        mp.put(13, "pineapple");
        for(Map.Entry me:mp.entrySet()){
            System.out.println(me.getKey()+" "+me.getValue());
        }
    }
}
