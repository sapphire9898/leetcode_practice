/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // fix the slow and fast ListNodes with the distance n, if till the null, then return null. 
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        
        ListNode slow = dummyhead;
        ListNode fast = dummyhead;
        
        while (n-- > 0) {
            fast = fast.next;
            if (fast == null) return null;
        }
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyhead.next;
        
    }
}