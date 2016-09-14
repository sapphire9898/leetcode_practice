public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n <= 0) return res;
        
        int[] nums = new int[n];
       
        generateList(res, nums, n, 0);
        
        
        return res;
        
    }
    
    
    private void generateList(List<List<String>> resList, int[] nums, int n, int count) {
        if (count == n) {
            resList.add(new ArrayList<String>(nQueens(nums)));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(nums, count, i)) {
                nums[count] = i;
                generateList(resList, nums, n, count + 1);
                nums[count] = 0;
            }
        }
    }
    
    
    private boolean isValid(int[] nums, int rownumber, int colnumber) {
        for (int i = 0; i < rownumber; i++) {
            
            if (nums[i] == colnumber) return false;
            if (Math.abs(i - rownumber) == Math.abs(nums[i] - colnumber)) return false;
            
        }
        return true;
    }
    
    private List<String> nQueens(int[] nums) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == j) {
                    sb.append('Q');
                    
                }
                else sb.append('.');
            }
            res.add(sb.toString());
        }
        
        return res;
 
        
    }
}