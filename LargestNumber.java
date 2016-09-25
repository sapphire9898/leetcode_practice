public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        
        
        Arrays.sort(res, new Comparator<String>() {
            public int compare(String i, String j) {
                String s1 = i + j;
                String s2 = j + i;
                return s2.compareTo(s1);
            }
        });
        if (res[0].charAt(0) == '0') return "0";
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < nums.length; i++) {
            result.append(res[i]);
        }
        return result.toString();
    }
}