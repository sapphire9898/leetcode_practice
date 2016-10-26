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
    public int largestBSTSubtree(TreeNode root) {
        // for every TreeNode in root, find out whether it is a valid BST.
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        HashMap<TreeNode, Integer> map = new HashMap<>();
        isBSThelper(root, map);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                queue.offer(curr.left);
                isBSThelper(curr.left, map);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                isBSThelper(curr.right, map);
            }
        }
        int res = 0;
        for (Integer i : map.values()) {
            res = Math.max(i, res);
        }
        
        return res;
    }
    private void isBSThelper(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return;
        if (helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            map.put(root, count(root));
            return;
        }
        else {
            return;
        }
        
    }
    
    private int count(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + count(root.left) + count(root.right);
    }
    
    private boolean helper(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;
        
        if (root.val < minValue || root.val > maxValue) return false;
        
        
        boolean leftIsTrue = helper(root.left, minValue, Math.min(root.val, maxValue));
        boolean rightIsTrue = helper(root.right, Math.max(minValue, root.val), maxValue);
        
        if (leftIsTrue && rightIsTrue) return true;
        else return false;
    }
}