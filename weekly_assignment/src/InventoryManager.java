import java.util.*;

public class InventoryManager {
    HashMap<String, Integer> stock = new HashMap<>();
    Queue<Integer> waitingList = new LinkedList<>();

    synchronized String purchase(String product, int userId) {
        int available = stock.getOrDefault(product, 0);
        if (available > 0) {
            stock.put(product, available - 1);
            return "Purchased";
        } else {
            waitingList.add(userId);
            return "Waiting";
        }
    }

    public static void main(String[] args) {
        InventoryManager im = new InventoryManager();
        im.stock.put("item", 2);

        System.out.println(im.purchase("item", 1));
        System.out.println(im.purchase("item", 2));
        System.out.println(im.purchase("item", 3));
    }
}