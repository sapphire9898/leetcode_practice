public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < 1 || k < 0) return res;
        int[] nums = new int[10];
        for (int i = 1; i <= 9; i++) {
            nums[i] = i;
        }
        List<Integer> ans = new ArrayList<Integer>();
        helper(res, n, 0, k, 0, ans, nums, 1);
        return res;
        
    }
    
    private void helper(List<List<Integer>> res, int target, int currsum, int k, int currk, List<Integer> ans, int[] nums, int start) {
       
        
        if (k == currk && target == currsum) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        if (target < currsum) return;
        if (currk > k) return;
        
        //nums[i] = i;
        for (int i = start; i <= 9; i++) {
            if (nums[i] != -1) {
                ans.add(nums[i]);
                nums[i] = -1;
                helper(res, target, currsum + i, k, currk + 1, ans, nums, i + 1);
                
                nums[i] = i;
                ans.remove(ans.size() - 1);
            }
        }
        
    }
}