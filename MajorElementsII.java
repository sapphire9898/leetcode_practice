public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return list;

        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }

        int cnt1 = 0, cnt2 = 0, num1 = 0, num2 = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                cnt1++;
            }
            else if (nums[i] == num2) {
                cnt2++;
            }
            else if (cnt1 == 0) {
                num1 = nums[i];
                cnt1 = 1;
            }
            
            else if (cnt2 == 0) {
                num2 = nums[i];
                cnt2 = 1;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        

        cnt1 = 0;
        cnt2 = 0;
        for (int i : nums) {
            if (i == num1) cnt1++;
            else if (i == num2) cnt2++;
        }
        if (cnt1 > nums.length / 3) list.add(num1);
        if (cnt2 > nums.length / 3 && num2 != num1) list.add(num2);


        return list;
    }
}