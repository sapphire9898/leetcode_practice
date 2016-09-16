/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head.next, prev = head;
        
        while (curr != null && curr.next != null) {
            if (prev.val == curr.val) {
                curr = curr.next;
                continue;
            }
            else {
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        if (prev.val != curr.val) {
            prev.next = curr;
        }
        else {
            prev.next = null;
        }

        return dummy.next;
    }
}