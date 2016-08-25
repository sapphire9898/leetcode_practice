
// the TLE brute-force version.
public class Solution {
   
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || nums == null || nums.length <= 1) return false;
        
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(0, i - k); j <= Math.min(nums.length - 1, i + k); j++) {
                if (i != j && Math.abs((long)nums[i] - (long)nums[j]) <= t) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

// The TreeSet version. 

public class Solution {
   
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || nums == null || nums.length <= 1) return false;
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            
            Integer largest = set.floor(nums[i] + t) ;
            Integer least = set.ceiling(nums[i] - t);
            
            // if largest is between nums[i] and (nums[i] + t) or least is between (nums[i] - t) and nums[i];
            if ((largest != null && largest >= nums[i]) || (least != null && least <= nums[i])) {
                return true;
            }
            
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
            
        }
        
        return false;
    }
}
