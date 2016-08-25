public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }
        int len = num.length();
        //i is the length of the first number. 
        for (int i = 1; i <= (len - 1) / 2; i++) {
            if (num.charAt(0) == '0' && i >= 2) {
                break;
            }
            // j is the length of the first number and the second number;
            for (int j = i + 1; (len - j) >= Math.max(j - i, i); j++) {
                if (j - i >= 2 && num.charAt(i) == '0') break;
                long num1 =  Long.valueOf(num.substring(0, i));
                long num2 = Long.valueOf(num.substring(i, j));
                if (helper(num.substring(j), num1, num2)) {
                    return true;
                }
            }
        }
        return false;
        
    }
    
    
    //whether the str is started with the sum of num1 and num2;
    private boolean helper(String str, long num1, long num2) {
        if (str.equals("")) return true;
        long sum = num1 + num2;
        
        String sum_string = ((Long)(sum)).toString();
        
        if (!str.startsWith(sum_string)) {
            return false;
        }
        
        return helper(str.substring(sum_string.length()), num2, sum);
        
    }
    
    
    
}