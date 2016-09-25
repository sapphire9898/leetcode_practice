public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;
        for (int i : nums) {
            minNumber = Math.min(i, minNumber);
            maxNumber = Math.max(i, maxNumber);
        }
        
        int n = nums.length;
        
        if (minNumber == maxNumber) return 0;
        
        int divider = (int) Math.ceil(((double)maxNumber - minNumber) / ((double)n - 1)); // n - 1 bucket. 
        
        if (divider == 0) divider++;
        
        int[] localmin = new int[n];
        
        int[] localmax = new int[n];
        Arrays.fill(localmin, -1);
        Arrays.fill(localmax, -1);
        // fill the empty bucket.
        
        
        for (int i = 0; i < n; i++) {
            int t = (nums[i] - minNumber) / divider;// find the index of the number. 
            localmin[t] = min(localmin[t], nums[i]);
            localmax[t] = max(localmax[t], nums[i]);
        }
        
        int ans = divider, left = 0, right = 1;
        while (left < n - 1) {
            while (right < n && localmin[right] == -1) {
                // the bucket is empty;
                right++;
            }
            if (right >= n) break;
            ans = Math.max(ans, localmin[right] - localmax[left]);
            // the last max and the next min between two buckets. 
            left = right;//update the left;
            right++;
        }
        
        return ans;
        
    }
    
    private int min(int a, int b) {
        if (a == -1) return b;
        
        return a < b ? a : b;
    }
    
    private int max(int a, int b) {
        if (a == -1) return b;
        
        return a > b ? a : b;
    }
}