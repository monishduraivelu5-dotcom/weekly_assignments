import java.util.*;

public class Analytics {
    HashMap<String, Integer> views = new HashMap<>();

    void process(String url) {
        views.put(url, views.getOrDefault(url, 0) + 1);
    }

    public static void main(String[] args) {
        Analytics a = new Analytics();
        a.process("home");
        a.process("home");
        a.process("about");

        System.out.println(a.views);
    }
}