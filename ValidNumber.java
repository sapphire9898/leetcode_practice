public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false; // check if empty string is valid. 
        
        // remove the spaces. 
        int i = 0, j = s.length() - 1;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        while (j >= 0 && s.charAt(j) == ' ') j--;
        
        
        
        if (i > j) return false;
        
        if (s.charAt(i) == '-' || s.charAt(i) == '+') i++;
        
        boolean dot = false, expo= false, numberbefore = false;
        
        while (i <= j) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberbefore = true;
            }
            else if (s.charAt(i) == '.') {
                if (dot || expo) return false;
                
                if (!numberbefore && (i == j || !(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'))) return false; // "46.e3" is okay, ".3" is okay. , "." is not. 
                dot = true;
                
            }
            else if (s.charAt(i) == 'e') {
                if (!numberbefore) return false;// ".e3" is not okay. "0.e3" is okay, ".0e4" is okay. 
                if (expo) return false;
                if (i == j || !((s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') || (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'))) return false;// after e there should be some numbers without dots or exponentials. can be with one '-' or '+' before . 
                expo = true;
                
            }
            else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (s.charAt(i - 1) != 'e') return false;   //"e+6" or "e-6" is okay. ".+6" is not. 
                if (i == j || !(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')) return false; // "e+" is not okay.  
            }
            
            else return false;
            i++;
        }
        
        return true;
        
    }
}