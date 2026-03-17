public class ParkingLot {
    String[] table = new String[10];

    int hash(String s) {
        return Math.abs(s.hashCode()) % table.length;
    }

    void park(String car) {
        int i = hash(car);
        while (table[i] != null)
            i = (i + 1) % table.length;

        table[i] = car;
        System.out.println("Parked at " + i);
    }

    public static void main(String[] args) {
        ParkingLot p = new ParkingLot();
        p.park("CAR1");
        p.park("CAR2");
    }
}