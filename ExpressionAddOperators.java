public class Solution {
   
    public List<String> addOperators(String num, int target) {
        // divide and conquer. 
        List<String> res = new ArrayList<String>();
        // for two lists of integers, we need to - + * to find whether we could get the target, but first, we need to find what numbers can get via composing numbers and symbols. 
        if (num == null || num.length() == 0) return res;
        helper(res, num, "", 0, target, 0, 0);
        
        return res;
    }
    
    
    private void helper(List<String> res, String num, String path, int pos, int target, long eval, long mult) {
       // from the pos; 
       if (pos == num.length() && target == eval) {
           res.add(path);
           return;
       }
       
       for (int i = pos; i < num.length(); i++) {
           if (i != pos && num.charAt(pos) == '0') {
               break;
           }
           long curr = Long.parseLong(num.substring(pos, i + 1));
           
           if (pos == 0) {
               helper(res, num, path + curr, i + 1, target, curr, curr);
           }
           else {
               helper(res, num, path + '+' + curr, i + 1, target, eval + curr, curr);
               helper(res, num, path + '-' + curr, i + 1, target, eval - curr, -curr);
               helper(res, num, path + '*' + curr, i + 1, target, eval - mult + mult * curr, mult * curr);
           }
           
       }
        
    }
}