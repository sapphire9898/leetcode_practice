public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k > n || k <= 0 || n <= 0) return res;

        List<Integer> ans = new ArrayList<Integer>();
        helper(res, ans, n, 1, k);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> ans, int n, int start, int k) {
        if (k == ans.size()) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        if (start > n) return;
        
        for (int i = start; i <= n; i++) {
            ans.add(i);
            helper(res, ans, n, i + 1, k);
            ans.remove(ans.size() - 1);
        }
    }
}