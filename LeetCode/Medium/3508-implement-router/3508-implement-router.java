import java.util.*;

class Router {
    private static class Packet {
        int source, dest, ts;
        Packet(int s, int d, int t) { source = s; dest = d; ts = t; }
    }

    private final int memoryLimit;
    private final Deque<Packet> queue;                 // FIFO
    private final Set<String> packetSet;               // detect duplicates
    private final Map<Integer, ArrayList<Integer>> destTimestamps; // dest -> timestamps
    private final Map<Integer, Integer> destHead;      // dest -> current head index

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.packetSet = new HashSet<>();
        this.destTimestamps = new HashMap<>();
        this.destHead = new HashMap<>();
    }

    private String keyFor(int s, int d, int t) {
        return s + "#" + d + "#" + t;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = keyFor(source, destination, timestamp);
        if (packetSet.contains(key)) {
            return false; // duplicate
        }

        // If full, evict oldest
        if (queue.size() == memoryLimit) {
            evictOldest();
        }

        Packet p = new Packet(source, destination, timestamp);
        queue.addLast(p);
        packetSet.add(key);

        // Append timestamp
        ArrayList<Integer> list = destTimestamps.computeIfAbsent(destination, k -> new ArrayList<>());
        list.add(timestamp);
        destHead.putIfAbsent(destination, 0);

        return true;
    }

    private void evictOldest() {
        Packet oldest = queue.removeFirst();
        String key = keyFor(oldest.source, oldest.dest, oldest.ts);
        packetSet.remove(key);

        ArrayList<Integer> list = destTimestamps.get(oldest.dest);
        if (list != null) {
            int head = destHead.getOrDefault(oldest.dest, 0);
            head++;
            if (head >= list.size()) {
                destTimestamps.remove(oldest.dest);
                destHead.remove(oldest.dest);
            } else {
                destHead.put(oldest.dest, head);
            }
        }
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];

        Packet p = queue.removeFirst();
        String key = keyFor(p.source, p.dest, p.ts);
        packetSet.remove(key);

        ArrayList<Integer> list = destTimestamps.get(p.dest);
        if (list != null) {
            int head = destHead.getOrDefault(p.dest, 0);
            head++;
            if (head >= list.size()) {
                destTimestamps.remove(p.dest);
                destHead.remove(p.dest);
            } else {
                destHead.put(p.dest, head);
            }
        }

        return new int[]{p.source, p.dest, p.ts};
    }

    public int getCount(int destination, int startTime, int endTime) {
        ArrayList<Integer> list = destTimestamps.get(destination);
        if (list == null) return 0;
        int head = destHead.getOrDefault(destination, 0);
        int size = list.size();
        if (head >= size) return 0;

        int left = lowerBound(list, head, size, startTime);
        int right = upperBound(list, head, size, endTime);
        return Math.max(0, right - left);
    }

    private int lowerBound(ArrayList<Integer> list, int lo, int hi, int target) {
        int l = lo, r = hi;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int upperBound(ArrayList<Integer> list, int lo, int hi, int target) {
        int l = lo, r = hi;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}