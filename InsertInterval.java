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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) return new ArrayList<Interval>(intervals);
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        
        intervals.add(newInterval);
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        Interval hold = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (hold.end >= current.start) {
                hold.end = Math.max(current.end, hold.end);
            }
            else {
                res.add(hold);
                hold = current;
            }
        }
        if (!res.contains(hold)) {
            res.add(hold);
        }
        return res;
    }
    
    
    
}