import java.util.*;

public class RateLimiter {
    HashMap<String, Integer> map = new HashMap<>();
    int LIMIT = 3;

    boolean allow(String client) {
        int count = map.getOrDefault(client, 0);
        if (count < LIMIT) {
            map.put(client, count + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RateLimiter rl = new RateLimiter();

        System.out.println(rl.allow("A"));
        System.out.println(rl.allow("A"));
        System.out.println(rl.allow("A"));
        System.out.println(rl.allow("A")); // blocked
    }
}