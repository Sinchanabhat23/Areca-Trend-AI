import java.util.*;

public class BasePrices {
    private static final Map<String, Integer> prices = new HashMap<>();
    static {
        prices.put("Saraku", 85500);
        prices.put("Rashi", 55800);
        prices.put("Bette", 64200);
        prices.put("Chali", 48800);
        prices.put("Api", 67500);
        prices.put("Hasa", 81200);
        prices.put("Gorabalu", 39500);
        prices.put("Kempugotu", 36200);
        prices.put("Bilegotu", 26800);
        prices.put("Sippegotu", 12800);
        prices.put("EDI", 26200);
    }

    public static int getPrice(String variety) {
        return prices.get(variety);
    }

    public static boolean exists(String variety) {
        return prices.containsKey(variety);
    }

    public static Set<String> getAllVarieties() {
        return prices.keySet();
    }
}
