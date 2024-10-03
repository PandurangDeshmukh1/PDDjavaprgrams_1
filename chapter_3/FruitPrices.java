import java.util.*;

public class FruitPrices {
    public static void main(String[] args) {
        Map<String, Double> prices = new HashMap<>();
        prices.put("Apple", 1.99);
        prices.put("Banana", 0.99);
        prices.put("Cherry", 2.99);

        for (Map.Entry<String, Double> entry : prices.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }
}
