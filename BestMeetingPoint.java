public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xList = new ArrayList<Integer>();
        List<Integer> yList = new ArrayList<Integer>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xList.add(i);
                    yList.add(j);
                }
            }
        }
        
        return solve(xList) + solve(yList);
    }
    
    private int solve(List<Integer> list) {
        
        int len = list.size();
        Collections.sort(list);
        
        int sum = 0, left = 0, right = len - 1;
        while (left < right && list.get(left) < list.get(right)) {
            sum += list.get(right) - list.get(left);
            right--;
            left++;
        }
        return sum;
    }
}