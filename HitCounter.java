public class HitCounter {
    TreeMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new TreeMap<Integer, Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (!map.containsKey(timestamp)) {
            map.put(timestamp, 0);
        }
        map.put(timestamp, map.get(timestamp) + 1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int res = 0;
        for (Integer i : map.subMap(timestamp - 300 + 1, timestamp + 1).keySet()) {
            res += map.get(i);
        }
        return res;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */