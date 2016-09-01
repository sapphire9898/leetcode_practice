public class Solution {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            while (i < nums.length - 3 && i > 0 && nums[i] == nums[i - 1]) i++;
            for (int j = i + 1; j < nums.length - 2; j++) {
                while (j < nums.length - 2 && j > i + 1 && nums[j] == nums[j - 1]) j++;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    }
                    else if (sum > target) {
                        right--;
                    }
                    else {
                        List<Integer> ans = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        res.add(ans);
                        while (left + 1 < nums.length - 1 && nums[left] == nums[left + 1]) left++;
                        while (right - 1 > left && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}