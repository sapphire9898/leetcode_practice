/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        
        queue.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            Interval curr = queue.poll();
            if (intervals[i].start >= curr.end) {
               curr.end = intervals[i].end; 
            }
            else {
                queue.offer(intervals[i]);
            }
            queue.offer(curr);
        }
        return queue.size();
    }
}



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int rooms = 0;
        int endin = 0;
        
        for (int i = 0; i < start.length; i++) {
            if (start[i] < end[endin]) {
                rooms++;
            }
            else endin++;
        }
        return rooms;
        
    }
}