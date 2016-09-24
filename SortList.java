/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        
        ListNode mid = findMid(head);
        ListNode second = mid.next;
        mid.next = null;
  
        
        return merge(sortList(head), sortList(second));
    }
    
    
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        
        while (l1 != null) {
            curr.next = l1;
            curr = curr.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            curr.next = l2;
            curr = curr.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
    
    
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        return prev;
    }
}