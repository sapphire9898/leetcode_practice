/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n || m < 0 || n < 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode prev = dummy;
        
        for (int i = 0; i < m; i++) {
            if (curr == null) return null;
            prev = curr;
            curr = curr.next;
            
        }
        
        if (curr == null) return head;
        
        ListNode nNode = curr, postnNode = curr.next;
        
        
        for (int i = m ;i < n; i++) {
            if (postnNode == null) return null;
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        curr.next = postnNode;
        prev.next = nNode;
        
        
        return dummy.next;
    }
}