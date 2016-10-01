public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0] == null || buildings[0].length == 0) return res;
        
        class Point {
            int x;
            int height;
            boolean isStart;
            public Point(int x, int height, boolean isStart) {
                this.x = x;
                this.height = height;
                this.isStart = isStart;
            }
        }
        
        
        ArrayList<Point> list = new ArrayList<>();
        for (int[] arr : buildings) {
            list.add(new Point(arr[0], arr[2], true));
            list.add(new Point(arr[1], arr[2], false));
        }
        
        Collections.sort(list, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.x != b.x) {
                    return a.x - b.x;
                }
                else {
                    return (a.isStart ? -a.height : a.height) - (b.isStart ? -b.height : b.height);
                }
            }
            });
            
        int n = list.size();  
        PriorityQueue<Integer> queue = new PriorityQueue<>(n + 1, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        queue.offer(0);
        
        for (int i = 0; i < n; i++) {
            // if maxvalue of queue is changed, then add the maxvalue in the res; 
            Point curr = list.get(i);
            if (curr.isStart) {
                int prev = queue.peek();
                queue.add(curr.height);
                if (curr.height > prev) {
                    res.add(new int[]{curr.x, curr.height});
                }
            }
            else {
                int prev = queue.peek();
                queue.remove(curr.height);
                int next = queue.peek();
                
                if (prev != next) {
                    res.add(new int[]{curr.x, next});
                }
            }
            
            
        }
        
        return res;
        
        
    }
}