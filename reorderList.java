/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode fast = head, slow = head, prev = null, first = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode second = reverse(slow);
        
        merge(first, second);
    }
    
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = null, curr = head, next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
        
    }
    
    
    private void merge(ListNode l1, ListNode l2) {
        
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            
            l1.next = l2;
            if (n1 == null) break;
            l2.next = n1;

            l1 = n1;
            l2 = n2;
        }
        
        
    }
    
    
    
   
    
}