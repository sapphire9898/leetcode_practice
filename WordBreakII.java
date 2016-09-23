public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return res;
        List<String> temp = new ArrayList<String>();
        if (check(s, wordDict))helper(res, temp, s, 0, wordDict);
        else return res;
        return res;
    }
    
    
    private boolean check(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (wordDict.contains(s.substring(j, i + 1)) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length() - 1];
    }
    
    private void helper(List<String> list, List<String> temp, String s, int start, Set<String> wordDict) {
         
        if (start == s.length()) {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < temp.size(); i++) {
                ans.append(temp.get(i));
                if (i != temp.size() - 1) {
                    ans.append(" ");
                }
            }
            list.add(ans.toString());
            return;
        }
        
        for (int j = start; j < s.length(); j++) {
            if (wordDict.contains(s.substring(start, j + 1))) {
                temp.add(s.substring(start, j + 1));
                helper(list, temp, s, j + 1, wordDict);
                temp.remove(temp.size() - 1);
            }
        }
        
    }
}