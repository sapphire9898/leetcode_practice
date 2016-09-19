/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        while (root != null) {
            
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode tempChild = dummy;
            while (root != null) {
                if (root.left != null) {
                    tempChild.next = root.left;
                    tempChild = tempChild.next;
                }
                if (root.right != null) {
                    tempChild.next = root.right;
                    tempChild = tempChild.next;
                }
                root = root.next;
            }
            root = dummy.next;
        }
        
        
        
    }
}