public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) return res;
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String str : strs) {
            char[] cArray = str.toCharArray();
            Arrays.sort(cArray);
            String curr = String.valueOf(cArray);
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<String>());
            }
            map.get(curr).add(str);
        }
        
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
        
        
    }
    
    
}