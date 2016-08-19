import java.util.Random;

public class Solution {
    private int[] original;
    
    public Solution(int[] nums) {
        
        original = nums;
        
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (original == null || original.length == 0) {
            return new int[0];
        }
        int[] a = original.clone();
        for (int i = 1; i < original.length; i++) {
           
            int new_index = (int)(Math.random() * (i + 1));
            swap(a, i, new_index);
        }
        return a;
        
    }
    private void swap(int[] a, int j, int i) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */