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
    public List<Interval> merge(List<Interval> intervals) {
        // first we sort the intervals with the interval.start, and then merge them. 
        
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
            
        
        Interval hold = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start <= hold.end) {
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
    public List<Interval> merge(List<Interval> intervals) {
        // first we sort the intervals with the interval.start, and then merge them. 
        
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
            
        
        
        int start = intervals.get(0).start, end = intervals.get(0).end;
        
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval next = intervals.get(i + 1);
            if (next.start <= end) {
                end = Math.max(next.end, end);
            }
            else {
                res.add(new Interval(start, end));
                start = next.start;
                end = next.end;
            }
        }
       
        res.add(new Interval(start, end));
        
    
        return res;
        
        
    }
}