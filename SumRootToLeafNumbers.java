/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return root.val + sum;
        }
        
        return helper(root.left, (root.val + sum) * 10) + helper(root.right, (root.val + sum) * 10);
    }
}