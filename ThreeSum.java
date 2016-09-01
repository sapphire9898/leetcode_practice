public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1; 
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                }
                else if (sum > 0) {
                    right--;
                }
                else {
                    ArrayList<Integer> newlist = new ArrayList<Integer>();
                    newlist.add(nums[i]);
                    newlist.add(nums[left]);
                    newlist.add(nums[right]);
                    res.add(newlist);
                    while (left + 1 < nums.length && nums[left] == nums[left + 1]) left++;
                    while (right - 1 >= 0 && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}