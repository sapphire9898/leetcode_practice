public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        int index = 0;
        for (int i = k; i < nums.length; i++) {
            res[index++] = queue.peek();
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
        }
        res[index] = queue.peek();
        return res;
    }
}