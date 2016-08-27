public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int start = 0, end = 0, maxvalue = 0;
         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
         
         for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             end = i;
             if (map.containsKey(c) && map.get(c) >= start) {//"the case tmmxuzt", if it is after the start, we need update the start, otherwise, add it. 
                 start = map.get(c) + 1;
                 map.put(c, i);
             }
             else {
                 map.put(c, i);
                 maxvalue = Math.max(maxvalue, end + 1 - start);
             }
         }
         return maxvalue;
    }
}