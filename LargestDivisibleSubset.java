// the first brute-force solution will TLE. 
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        
        for (int num : nums) {
            //if exist num % key == 0, then append to the list, then update the key to num;
            //else create (num, new ArrayList<Integer> with only num) into the map.
            boolean exit = false;
            HashMap<Integer, ArrayList<Integer>> curr = new HashMap<Integer, ArrayList<Integer>>(map);
            int maxsize = Integer.MIN_VALUE;
            for (int k : curr.keySet()) {
                if (num % k == 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>(curr.get(k));
                    maxsize = Math.max(list.size(), maxsize);
                    exit = true;
                }
            }
            for (ArrayList list : curr.values()) {
                if (list.size() == maxsize) {
                    ArrayList<Integer> newlist = new ArrayList<Integer>(list);
                    newlist.add(num);
                    map.put(num, newlist);
                }
            }
            if (!exit) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(num);
                map.put(num, list);
            }
        }
        
        int maxvalue = Integer.MIN_VALUE;
        for (ArrayList list : map.values()) {
            if (list.size() > maxvalue) {
                maxvalue = list.size();
                result = new ArrayList<Integer>(list);
            }
        }
        return result;
        
    }
}


// the second solution is based on dynamic programming. 
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[maxIndex] < dp[i]) {
                maxIndex = i;
            }
        }
        
        int temp = nums[maxIndex];
        int index = maxIndex;
        for (int i = maxIndex; i >= 0; i--) {
            if (temp % nums[i] == 0 && dp[index] - dp[i] <= 1) {
                result.add(nums[i]);
                temp = nums[i];
                index = i;
            }
        }
        Collections.sort(result);

        return result;
        
    }
}





