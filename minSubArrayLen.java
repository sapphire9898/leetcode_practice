public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
     // the min window. 
     if (nums == null || nums.length == 0) return 0;
     int res = Integer.MAX_VALUE;
     int start = 0, end = 1, sum = nums[0];
     while (end < nums.length) {
         while (end < nums.length && sum < s) {
             sum += nums[end++];
             
         }
         
         while (start < nums.length && sum >= s) {
             sum -= nums[start++];
             res = Math.min(end - start + 1, res);
         }

     }
     
     
     return res == Integer.MAX_VALUE ? 0 : res;
     
    }
}