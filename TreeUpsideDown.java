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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr.left != null) {
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode newroot = curr;
        
        while (!stack.isEmpty()) {
            TreeNode leftChild = stack.pop();
            newroot.right = leftChild;
            newroot.left = leftChild.right;
            leftChild.left = null;
            leftChild.right = null;
            newroot = leftChild;
        }
        return curr;
    }
    
}