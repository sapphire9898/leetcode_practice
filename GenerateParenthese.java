public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n <= 0) {
            return res;
        }
        helper(res, "", n, 0, 0);
        return res;
    }
    
    private void helper(List<String> res, String ans, int n, int leftn, int rightn) {
        if (rightn > leftn || leftn > n || rightn > n) return;
        if (leftn == n && rightn == n) {
            res.add(ans);
            return;
        }
        
        helper(res, ans + "(", n, leftn + 1, rightn);
        helper(res, ans + ")", n, leftn, rightn + 1);
        
    }
}