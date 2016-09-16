public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        
        
        res.add(new ArrayList<Integer>());
        List<Integer> list = new ArrayList<Integer>();
        for (int k = 1; k <= nums.length; k++) {
            helper(res, list, nums, k, 0, 0);
        }
        
        // res.addAll(set);
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for (List<Integer> l : res) {
            Collections.sort(l);
            set.add(l);
        }
        res = new ArrayList<List<Integer>>();
        res.addAll(set);
        
        return res;
        
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int k, int start, int curr) {
        if (curr == k) {
            // Collections.sort(list);
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