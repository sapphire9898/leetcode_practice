public class Solution {
    
    private String[][] phone = {{}, {}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
    public List<String> letterCombinations(String digits) {
    
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return res;
        
        helper(res, digits, "");
        return res;
    }
    
    private void helper(List<String> res, String digits, String ans) {
        if (digits.length() == 0) {
            res.add(ans);
            return;
        }
        
        int curr = Integer.valueOf(digits.substring(0, 1));
        for (String s : phone[curr]) {
            helper(res, digits.substring(1), ans + s);
        }
        
    }   
    
    
}