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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0 || inorder.length != postorder.length) return null;
        
        int n = inorder.length;
        TreeNode root = helper(inorder, 0, n - 1, postorder, 0, n - 1);
        return root;
    }
    
    private TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if (instart > inend) return null;
        
        TreeNode root = new TreeNode(postorder[postend]);
        
        int i = instart;
        for (; i <= inend; i++) {
            if (inorder[i] == postorder[postend]) {
                break;
            }
        }
        
        //inorder_left : instart to i - 1;
        //inorder_right : i + 1 to inend;
        
        // postorder_left : poststart to poststart + i - 1 - instart;
        // postorder_right :postend - 1 - (inend - i - 1) to  postend - 1;
        
        
        root.left = helper(inorder, instart, i - 1, postorder, poststart, poststart + i - 1- instart);
        root.right = helper(inorder, i + 1, inend, postorder, postend - 1 - inend + i + 1, postend - 1);
        
        
        return root;
        
    }
}