public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) return -1;
        // use heap. 
        
        Queue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
            });
        
        for (int i : nums) {
            queue.offer(i);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.poll();
    }
    
}