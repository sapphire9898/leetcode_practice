public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return -1;
        int left = 1, right = nums.length - 1, cnt = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            cnt = 0;
            for (int i : nums) {
                if (i <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
//Then if the count is more than mid, the search space will be [1 mid] otherwise [mid+1 n]. 


// another method is to find the Linkedlist cycle. 
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return -1;
        int slow = nums[0], fast = nums[nums[0]];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        
        return slow;
    }
}
