import java.util.*;

public class Plagiarism {
    HashMap<String, Set<String>> map = new HashMap<>();

    List<String> ngrams(String text, int n) {
        String[] w = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= w.length - n; i++) {
            String g = "";
            for (int j = 0; j < n; j++)
                g += w[i + j] + " ";
            res.add(g.trim());
        }
        return res;
    }

    void index(String id, String text) {
        for (String g : ngrams(text, 2)) {
            map.putIfAbsent(g, new HashSet<>());
            map.get(g).add(id);
        }
    }

    public static void main(String[] args) {
        Plagiarism p = new Plagiarism();
        p.index("doc1", "this is a test document");
        p.index("doc2", "this is a test file");

        System.out.println(p.map);
    }
}