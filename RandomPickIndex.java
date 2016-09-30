public class Solution {
    Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    

    public Solution(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }    
    }
    
    public int pick(int target) {
        if (!map.containsKey(target)) return -1;
        int num = map.get(target).size();
        Random ran = new Random(); 
        int x = ran.nextInt(num);
        
        return map.get(target).get(x);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */