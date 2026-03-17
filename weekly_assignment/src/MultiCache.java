import java.util.*;

public class MultiCache {
    LinkedHashMap<Integer, String> L1 = new LinkedHashMap<>();
    HashMap<Integer, String> L2 = new HashMap<>();

    String get(int key) {
        if (L1.containsKey(key)) return "L1 HIT";

        if (L2.containsKey(key)) {
            L1.put(key, L2.get(key));
            return "L2 HIT";
        }

        String data = "DB";
        L2.put(key, data);
        return "DB HIT";
    }

    public static void main(String[] args) {
        MultiCache mc = new MultiCache();

        System.out.println(mc.get(1));
        System.out.println(mc.get(1));
    }
}
