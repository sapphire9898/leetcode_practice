public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        
        res.add(new ArrayList<Integer>());
        List<Integer> list =new ArrayList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            helper(res, list, nums, i, 0, 0);
        }
        
        return res;
    }
    
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int k, int start, int curr) {
        if (curr == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (start >= nums.length) return;
        
        
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, k, i + 1, curr + 1);
            list.remove(list.size() - 1);
        }
    }
}