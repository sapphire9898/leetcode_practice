public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        HashSet<List<Integer>> res_backup = new HashSet<List<Integer>>();
        helper(res, list, candidates, target);
        
        for (List<Integer> li : res) {
            Collections.sort(li);
            res_backup.add(li);
        }
        res = new ArrayList<List<Integer>>(res_backup);
        
        return res;
    }
    
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target) {
        if (target < 0) return;
        else if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i : candidates) {
            if (target >= i) {
            list.add(i);
            helper(res, list, candidates, target - i);
            list.remove(list.size() - 1);
            }
             
        }
    }
}