public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        // design a map[256], when encount map[]++;   so there are only two values in the map should be less than 0; if there are more, the count should be move. 
        // when map[]-- == 1; then it's deleted from the target string. count--;
        // when map[]++ == 0; then a new value is added to the target string, count++;
        // we need to maintain that the count is less than or equal to 2; 
        
        int[] map = new int[256];
        int start = 0, end = 0, count = 0, res = 0;
        while (end < s.length()) {
            while (end < s.length() && count <= 2) {
                if(map[s.charAt(end++)]++ == 0) {
                    count++;
                }
            }
            
            if (count <= 2) {
                res = Math.max(res, end - start);
                break;
            }
            // end now make the count > 2; from start to end - 1; 
            res = Math.max(res, end - start - 1);
            
            while (count > 2 && start <= end) {
                if (map[s.charAt(start++)]-- == 1) {
                    count--;
                    if (count <= 2) {
                        res = Math.max(res, end - start);  
                        
                    }
                }
            }
            
        }
        return res;
    }
}