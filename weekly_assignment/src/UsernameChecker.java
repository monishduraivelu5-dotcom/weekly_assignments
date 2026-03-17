import java.util.*;

public class UsernameChecker {
    HashMap<String, Integer> users = new HashMap<>();
    HashMap<String, Integer> attempts = new HashMap<>();

    boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    void register(String username, int id) {
        users.put(username, id);
    }

    List<String> suggest(String username) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String s = username + i;
            if (!users.containsKey(s)) res.add(s);
        }
        return res;
    }

    String mostAttempted() {
        return Collections.max(attempts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        UsernameChecker uc = new UsernameChecker();
        uc.register("john_doe", 1);

        System.out.println(uc.checkAvailability("john_doe"));
        System.out.println(uc.checkAvailability("jane"));
        System.out.println(uc.suggest("john_doe"));
        System.out.println(uc.mostAttempted());
    }
}