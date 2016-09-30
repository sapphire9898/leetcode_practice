public class Solution {
    public List<Integer> lexicalOrder(int n) {
        // generate numbers as going on. 
        List<Integer> res = new ArrayList<>();
        if (n < 1) return res;
        for (int i = 1; i < 10; i++) {
            helper(res, i, n);
        }
        return res;
    }
    
    
    private void helper(List<Integer> res, int curr, int n) {
        if (curr > n) return;
        else {
            res.add(curr);
            for (int i = 0; i <= 9; i++) {
                if (curr * 10 + i <= n) {
                    helper(res, curr * 10 + i, n);
                }
                else return;
            }
        }
        
    }
    
    
}



public class Solution {
    public List<Integer> lexicalOrder(int n) {
        
        List<Integer> res = new ArrayList<Integer>();
        int curr = 1;
       
        while (res.size() < n) {
            res.add(curr);
            
            if (curr * 10 <= n) {
                curr *= 10;
            }
            else if ((curr + 1) % 10 != 0 && (curr + 1 <= n)) {
                curr = curr + 1;
            }
            else {
                while ((curr / 10 % 10) == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return res;
        
    }
}