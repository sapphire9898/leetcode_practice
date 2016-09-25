public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int a = (n - 1) / 26;
            // be careful for the special case of 26. 
            int b = n % 26;
            
            // b == 1 , A;
            // b == 2, B;
            //....  25.
            // b == 0; Z; 
            sb.append(b == 0 ? 'Z' : (char)('A' + b - 1));
            
            n = a;
        }
        
        return sb.reverse().toString();
    }
}