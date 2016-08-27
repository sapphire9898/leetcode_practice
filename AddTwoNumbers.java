/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode dummyhead = new ListNode(0);
        ListNode curr = dummyhead;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            sum = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            
            ListNode next = new ListNode(sum);
            curr.next = next;
            curr = curr.next;
            
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        
        if (carry > 0) {
            ListNode next = new ListNode(carry);
            curr.next = next;
        }
        return dummyhead.next;
        
    }
}