public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // if we find a array that is size len is equal to k, we only use the len + 1 window to find the target k;
        // But how to find the first one is equal to k? Use HashMap ? 
        
        // first process the corner case. 
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) {
            return nums[0] == k ? 1 : 0;
        }
        
        int[] sumFromHead = new int[nums.length + 1];
        sumFromHead[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sumFromHead[i] += nums[i - 1] + sumFromHead[i - 1];
        }
        // sum[0] = 0, sum[1] = num[0], sum[2] = num[0] + num[1], .. sum[]
        // sum from nums[i] +.. +  nums[j] = sum[j + i + 1] - sum[i]; the res = j - i + 1;
        
        //find the difference with k with the max range. 
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            int target = sumFromHead[i] - k;
            if (map.containsKey(target)) {
                res = Math.max(i - map.get(target) - 1, res);
            }
    
            if (!map.containsKey(sumFromHead[i])) {
                map.put(sumFromHead[i], i - 1);
            }
        }
        
        return res;
    }
}