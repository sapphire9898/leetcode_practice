public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            if ((set.floor(nums[i] + t) != null && set.floor(nums[i] + t) >=  nums[i]) || (set.ceiling(nums[i] - t) != null &&  set.ceiling(nums[i] - t) <= nums[i])) return true;
            
            set.add(nums[i]);
            
            
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}