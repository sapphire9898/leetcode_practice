public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        
        
        int cnt = 0;
        
        StringBuilder sb = new StringBuilder();
        
        
        
        int i = a.length() - 1, j = b.length() - 1;
        
        
        while (i >= 0 || j >= 0) {
            int acurr = i >= 0 ? (int)(a.charAt(i) - '0') : 0;
            int bcurr = j >= 0 ? (int)(b.charAt(j) - '0') : 0;
            
            int sum = acurr + bcurr + cnt;
            
            if (sum >= 2) cnt = 1;
            else cnt = 0;
            sb.append(sum % 2);
            i--;
            j--;
        }
        
        if (cnt > 0) {
            sb.append(cnt);
        }
        
        
        String res = sb.reverse().toString();
        
        // remove unnecessary zeroes. 
        int k = 0;
        while (res.charAt(k) == '0' && k < res.length() - 1) {
            k++;
        }
        res = res.substring(k);
        
        return res;
        
    }
}