import java.util.*;

public class Autocomplete {
    HashMap<String, Integer> freq = new HashMap<>();

    void add(String q) {
        freq.put(q, freq.getOrDefault(q, 0) + 1);
    }

    List<String> search(String prefix) {
        List<String> res = new ArrayList<>();
        for (String s : freq.keySet())
            if (s.startsWith(prefix)) res.add(s);

        res.sort((a, b) -> freq.get(b) - freq.get(a));
        return res ;
    }

    public static void main(String[] args) {
        Autocomplete ac = new Autocomplete();
        ac.add("java");
        ac.add("javascript");
        ac.add("java");

        System.out.println(ac.search("jav"));
    }
}