public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0) return res;
        
        List<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Boolean> map =  new HashMap<Integer, Boolean>();
        for (int num : nums) {
            map.put(num, false);
        }
        helper(res, ans, map, nums, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> ans, HashMap<Integer, Boolean> map, int[] nums, int count) {
        if (count == nums.length) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        
        
        for (int num : nums) {
            if (!map.get(num)) {
                map.put(num, true);
                ans.add(num);
                helper(res, ans, map, nums, count + 1);
                map.put(num, false);
                ans.remove(ans.size() - 1);
            }
        }
    }
}