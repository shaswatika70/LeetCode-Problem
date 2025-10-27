import java.util.*;

class Router {
    private static class Packet {
        int source;
        int destination;
        int timestamp;

        Packet(int s, int d, int t) {
            source = s;
            destination = d;
            timestamp = t;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Packet)) return false;
            Packet p = (Packet) o;
            return source == p.source && destination == p.destination && timestamp == p.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

    private int memoryLimit;
    private Deque<Packet> queue; // FIFO storage
    private Set<Packet> uniquePackets; // for duplicate detection
    private Map<Integer, List<Integer>> destToTimestamps; // destination -> timestamps
    private Map<Integer, Integer> processedCount; // destination -> number of forwarded packets

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.uniquePackets = new HashSet<>();
        this.destToTimestamps = new HashMap<>();
        this.processedCount = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet pkt = new Packet(source, destination, timestamp);
        if (uniquePackets.contains(pkt)) {
            return false; // duplicate
        }
        // if full, forward oldest
        if (queue.size() == memoryLimit) {
            forwardPacket();
        }
        // add new packet
        queue.addLast(pkt);
        uniquePackets.add(pkt);
        destToTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) {
            return new int[] {};
        }
        Packet pkt = queue.removeFirst();
        uniquePackets.remove(pkt);

        // mark one more forwarded for that destination
        processedCount.put(pkt.destination,
                processedCount.getOrDefault(pkt.destination, 0) + 1);

        return new int[] { pkt.source, pkt.destination, pkt.timestamp };
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> times = destToTimestamps.get(destination);
        if (times == null) return 0;

        int startIdx = processedCount.getOrDefault(destination, 0);

        // binary search
        int lo = lowerBound(times, startTime, startIdx);
        int hi = upperBound(times, endTime, startIdx);

        return hi - lo;
    }

    // Find first index >= target
    private int lowerBound(List<Integer> list, int target, int fromIdx) {
        int lo = fromIdx, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // Find first index > target
    private int upperBound(List<Integer> list, int target, int fromIdx) {
        int lo = fromIdx, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
