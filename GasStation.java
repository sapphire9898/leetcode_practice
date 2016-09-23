public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;
        
        
        int total = 0;
        int sum = 0;
        int index = -1;
        
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i;
            }
        }
        return total < 0 ? -1 : index + 1;
        
    }
}