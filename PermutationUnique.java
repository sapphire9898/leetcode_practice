public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
 
        res = helper(nums, 0);
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for (List<Integer> l : res) {
            set.add(l);
        }
        res = new ArrayList<List<Integer>>(set);
        return res;
        
    }
    
    private List<List<Integer>> helper(int[] nums, int index) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (index == nums.length) {
            List<Integer> list = new ArrayList<Integer>();
           
            res.add(list);
            return res;
        }
        
        
      
        
        for (List<Integer> l : helper(nums, index + 1)) {
            
            for (int i = 0; i <= l.size(); i++) {
                if (i > 1 && l.get(i - 1) == nums[index]) continue;
                
                ArrayList<Integer> yo = new ArrayList<>(l);
                yo.add(i, nums[index]);
                res.add(yo);
                
            }
        }
        return res;
        
    }
}