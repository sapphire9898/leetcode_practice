/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length <= 2) return points.length;
        
        
        int count = 0;
        for (int i = 0; i < points.length - 1; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            Point a = points[i];
            int same = 0;
            for (int j = i + 1; j < points.length; j++) {
                Point b = points[j];
                if (b.x == a.x && b.y == a.y) {
                    same++;
                    continue;
                }
                
                double slope = a.x == b.x ? Integer.MAX_VALUE : 0.0 + (double)(b.y - a.y) / (double)(b.x - a.x);
                // pay attention to the double problem.
                
                if (!map.containsKey(slope)) {
                    map.put(slope, 1);
                }
                else {
                    map.put(slope, map.get(slope) + 1);
                }
            }
            
            // choose the max from the map.values();
            int max = 0;
            for (Integer curr : map.values()) {
                max = Math.max(curr, max);
            }
            count = Math.max(max + same + 1, count);
        }
        
        return count;
        
    }
}