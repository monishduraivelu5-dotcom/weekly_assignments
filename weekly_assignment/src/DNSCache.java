import java.util.*;

public class DNSCache {
    class Entry {
        String ip;
        long expiry;

        Entry(String ip, long ttl) {
            this.ip = ip;
            this.expiry = System.currentTimeMillis() + ttl;
        }
    }

    HashMap<String, Entry> cache = new HashMap<>();

    String resolve(String domain) {
        if (cache.containsKey(domain)) {
            Entry e = cache.get(domain);
            if (System.currentTimeMillis() < e.expiry)
                return "HIT: " + e.ip;
            else
                cache.remove(domain);
        }
        String ip = "1.1.1.1";
        cache.put(domain, new Entry(ip, 3000));
        return "MISS: " + ip;
    }

    public static void main(String[] args) throws Exception {
        DNSCache dns = new DNSCache();
        System.out.println(dns.resolve("google.com"));
        Thread.sleep(1000);
        System.out.println(dns.resolve("google.com"));
    }
}