import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int comp = target - num;
            if (map.containsKey(comp)) {
                System.out.println(num + " + " + comp);
            }
            map.put(num, 1);
        }
    }
}