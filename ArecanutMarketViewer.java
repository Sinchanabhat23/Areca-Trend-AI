import java.io.*;
import java.text.*;
import java.util.*;
import com.opencsv.CSVReader; // Add opencsv library to read CSV

public class ArecanutMarketViewer {

    static class Record {
        String district;
        String variety;
        Date date;
        int price;

        Record(String district, String variety, Date date, int price) {
            this.district = district;
            this.variety = variety;
            this.date = date;
            this.price = price;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Record> records = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // adjust based on CSV date format

        // -------------------------------
        // 1️⃣ Load CSV
        // -------------------------------
        try (CSVReader reader = new CSVReader(new FileReader("arecanut_prices.csv"))) {
            String[] line;
            reader.readNext(); // skip header
            while ((line = reader.readNext()) != null) {
                try {
                    String district = line[0].trim();
                    String variety = line[1].trim();
                    Date date = sdf.parse(line[2].trim());
                    int price = Integer.parseInt(line[3].trim());
                    records.add(new Record(district, variety, date, price));
                } catch (Exception e) {
                    // skip invalid lines
                }
            }
        }

        // -------------------------------
        // 2️⃣ Language selection
        // -------------------------------
        System.out.println("Select Language / ಭಾಷೆ: 1-English, 2-Kannada");
        int langChoice = sc.nextInt();
        sc.nextLine(); // consume newline
        boolean isKannada = (langChoice == 2);

        String title = isKannada ? "ಅಡಿಕೆ ಮಾರುಕಟ್ಟೆ ಬೆಲೆ" : "Arecanut Market Price Viewer";
        String districtLabel = isKannada ? "ಜಿಲ್ಲೆಯನ್ನು ಆಯ್ಕೆಮಾಡಿ" : "Select District";
        String varietyLabel = isKannada ? "ಅಡಿಕೆ ಪ್ರಕಾರ ಆಯ್ಕೆಮಾಡಿ" : "Select Arecanut Variety";
        String dateLabel = isKannada ? "ದಿನಾಂಕ ಆಯ್ಕೆಮಾಡಿ" : "Select Date";
        String priceLabel = isKannada ? "ಮಾರುಕಟ್ಟೆ ಬೆಲೆ (₹/ಕ್ವಿಂಟಲ್)" : "Market Price (₹/Quintal)";

        System.out.println("\n=== " + title + " ===");

        // -------------------------------
        // 3️⃣ List districts
        // -------------------------------
        Set<String> districts = new TreeSet<>();
        for (Record r : records) districts.add(r.district);

        List<String> districtList = new ArrayList<>(districts);
        System.out.println(districtLabel + ":");
        for (int i = 0; i < districtList.size(); i++) {
            System.out.println((i + 1) + ". " + districtList.get(i));
        }
        System.out.print("Enter number: ");
        int districtIndex = sc.nextInt() - 1;
        sc.nextLine();
        String district = districtList.get(districtIndex);

        // -------------------------------
        // 4️⃣ List varieties
        // -------------------------------
        Set<String> varieties = new TreeSet<>();
        for (Record r : records) {
            if (r.district.equals(district)) varieties.add(r.variety);
        }

        List<String> varietyList = new ArrayList<>(varieties);
        System.out.println(varietyLabel + ":");
        for (int i = 0; i < varietyList.size(); i++) {
            System.out.println((i + 1) + ". " + varietyList.get(i));
        }
        System.out.print("Enter number: ");
        int varietyIndex = sc.nextInt() - 1;
        sc.nextLine();
        String variety = varietyList.get(varietyIndex);

        // -------------------------------
        // 5️⃣ List dates
        // -------------------------------
        Set<Date> dates = new TreeSet<>();
        for (Record r : records) {
            if (r.district.equals(district) && r.variety.equals(variety)) dates.add(r.date);
        }

        List<Date> dateList = new ArrayList<>(dates);
        System.out.println(dateLabel + ":");
        for (int i = 0; i < dateList.size(); i++) {
            System.out.println((i + 1) + ". " + sdf.format(dateList.get(i)));
        }
        System.out.print("Enter number: ");
        int dateIndex = sc.nextInt() - 1;
        Date selectedDate = dateList.get(dateIndex);

        // -------------------------------
        // 6️⃣ Filter and show price
        // -------------------------------
        boolean found = false;
        for (Record r : records) {
            if (r.district.equals(district) && r.variety.equals(variety) && r.date.equals(selectedDate)) {
                System.out.println(priceLabel + ": ₹ " + r.price);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(isKannada ? "ನಿರ್ದಿಷ್ಟ ಆಯ್ಕೆಗೆ ಡೇಟಾ ಲಭ್ಯವಿಲ್ಲ" : "No data available for selected options");
        }

        sc.close();
    }
}
