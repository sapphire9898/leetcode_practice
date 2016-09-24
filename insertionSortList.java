/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
       
       
        ListNode curr = dummy, prev = null;
        while (head != null) {
            ListNode next = head.next;
            while (curr != null && head.val >= curr.val) {
                prev = curr;
                curr = curr.next;
            }
            
            prev.next = head;
            head.next = curr;
            
            head = next;
            
            curr = dummy;
            prev = null;
        }
       
        return dummy.next;
        
        
        
    }
}