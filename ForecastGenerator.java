import java.util.*;

public class ForecastGenerator {

    public static class Forecast {
        public Date date;
        public String timeline;
        public int price;

        public Forecast(Date date, String timeline, int price) {
            this.date = date;
            this.timeline = timeline;
            this.price = price;
        }
    }

    public static List<Forecast> generate(String variety) {
        List<Forecast> list = new ArrayList<>();
        int base = BasePrices.getPrice(variety);
        Random rand = new Random();

        for(int i = 0; i <= 2; i++) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_YEAR, i);
            Date date = cal.getTime();

            String timeline = (i==0) ? "Today" : (i==1 ? "Tomorrow" : "Day After");
            int trend = i * 45;
            int noise = rand.nextInt(301) - 150; // -150 to +150
            int predicted = base + trend + noise;

            list.add(new Forecast(date, timeline, predicted));
        }

        return list;
    }
}
