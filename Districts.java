import java.util.*;

public class Districts {
    private static final Set<String> districts = new HashSet<>(Arrays.asList(
        "Shivamogga", "Uttara Kannada", "Dakshina Kannada", "Davangere", "Chikkamagaluru",
        "Tumkur", "Chitradurga", "Udupi", "Hassan", "Bagalkot",
        "Ballari", "Belagavi", "Bengaluru", "Bidar", "Chamarajanagar",
        "Dharwad", "Gadag", "Haveri", "Kalaburagi", "Kodagu",
        "Kolar", "Koppal", "Mandya", "Mysuru", "Raichur",
        "Ramanagara", "Vijayapura", "Yadgir"
    ));

    public static boolean exists(String district) {
        return districts.contains(district);
    }

    public static Set<String> getAll() {
        return districts;
    }
}
