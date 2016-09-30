public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int curr = calculate(A, i);
            if (max < curr) {
                max = curr;
            }
        }
        return max;
    }
    
    private int calculate(int[] A, int constant) {
        int sum = 0;
        // 0 * len - 1 - constant;
        int curr = A.length - constant;
        for (int i = 0; i < A.length; i++) {
            if (curr == A.length) curr = 0; 
            sum += i * A[curr++];
        }
         return sum;   
        }
        
        
    
}