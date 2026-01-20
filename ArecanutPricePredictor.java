import java.util.*;

public class ArecanutPricePredictor {

    // Base prices for varieties (matches your HTML JS basePrices)
    static Map<String, Integer> basePrices = new HashMap<>();
    static {
        basePrices.put("Saraku", 85500);
        basePrices.put("Rashi", 55800);
        basePrices.put("Bette", 64200);
        basePrices.put("Chali", 48800);
        basePrices.put("Api", 67500);
        basePrices.put("Hasa", 81200);
        basePrices.put("Gorabalu", 39500);
        basePrices.put("Kempugotu", 36200);
        basePrices.put("Bilegotu", 26800);
        basePrices.put("Sippegotu", 12800);
        basePrices.put("EDI", 26200);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Karnataka Arecanut 3-Day Price Predictor ===");

        // Select Variety
        System.out.println("Available Varieties: " + basePrices.keySet());
        System.out.print("Enter Variety: ");
        String variety = sc.nextLine();

        if(!basePrices.containsKey(variety)) {
            System.out.println("Invalid variety. Exiting.");
            return;
        }

        int base = basePrices.get(variety);
        Random rand = new Random();

        System.out.println("\n3-Day Price Forecast for " + variety + ":");
        System.out.printf("%-15s %-15s %-20s\n", "Date", "Timeline", "Predicted Price");

        for(int i=0; i<=2; i++) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_YEAR, i);
            Date date = cal.getTime();

            String timeline = (i==0) ? "Today" : (i==1 ? "Tomorrow" : "Day After");
            
            // Regression logic: base + trend + small random fluctuation
            int trend = i * 45; // same as your JS
            int randomNoise = rand.nextInt(301) - 150; // -150 to +150
            int predicted = base + trend + randomNoise;

            System.out.printf("%-15s %-15s ₹ %,d\n", date.toString(), timeline, predicted);
        }

        sc.close();
    }
}
