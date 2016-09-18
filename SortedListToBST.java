/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        
        ListNode prevMid = findMid(dummy);
        ListNode rootNode = prevMid.next;
        ListNode rightNode = rootNode.next;
        
        prevMid.next = null;
        TreeNode root = new TreeNode(rootNode.val);
        
        root.left = sortedListToBST(dummy.next);
        root.right = sortedListToBST(rightNode);
        
        return root;
    }
    
    
    private ListNode findMid(ListNode head) {
        // we should return the prev mid node. 
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        return prev;
    }

}