public class Solution {
    public String multiply(String num1, String num2) {
        // space?
        // the negative or positive. 
        // take out the number. 
        
        num1.trim();
        num2.trim();
        
        // boolean isNegative1 = false, isNegative2 = false;
        // if (num1.charAt(0) == '-' || num1.charAt(0) == '+')  {
        //     isNegative1 = num1.charAt(0) == '-';
        //     num1 = num1.substring(1);
        // }
        // if (num2.charAt(0) == '-' || num2.charAt(0) == '+') {
        //     isNegative2 == num1.charAt(0) == '-';
        //     num2 = num2.substring(1);
        // }
        
        int m = num1.length(), n = num2.length();
        int smaller = m < n ? m : n;
        
        String[] res = new String[smaller];
        boolean nSmaller = m >= n;
        
        for (int i = smaller - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int currsmaller = (int) ((nSmaller ? num2.charAt(i) : num1.charAt(i)) - '0');
            String curr = nSmaller ? num1 : num2;
            int sum = 0, cout = 0, num = 0;
            for (int j = curr.length() - 1; j >= 0; j--) {
                char c = curr.charAt(j);
                sum = (c - '0') * currsmaller + cout;
                num = sum % 10;
                cout = sum / 10;
                sb.append(num);
            }
            if (cout > 0) sb.append(cout);
            
            res[smaller - i - 1] = sb.reverse().toString();
            
        }
        
        
        String ans = process(res);
        
        int p = 0;
        while (p < ans.length() && ans.charAt(p) == '0') p++;
        if (p == ans.length()) return "0";
        else return ans.substring(p);
        
    }
    
    private String process(String[] res) {
        // the first string is full, the second string should be multiplied by 10, etc. 
        
        int m = res.length;
        // fill with zeroes. 
        int target = res[m - 1].length() + m - 1;
        for (int i = 0; i < m; i++) {
            res[i] =  res[i] + zeros(i);
            res[i] =  zeros(target - res[i].length()) + res[i];
        }
        
        StringBuilder sb = new StringBuilder();
        int cout = 0, sum = 0, num = 0;
        for (int i = target - 1; i >= 0; i--) {
            sum = cout;
            for (int j = 0; j < m; j++) {
                sum += (int) (res[j].charAt(i) - '0');
            }
            cout = sum / 10;
            num = sum % 10;
            sb.append(num);
        }
        
        if (cout > 0) {
            sb.append(cout);
        }
       
       return sb.reverse().toString();
        
    }
    
    private String zeros(int n) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append(0);
        }
        return sb.toString();
    }
    
}