/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // first traverse the list, find the len. k = k % len;
        // then find the critical listnodes. 
        
        if (head == null || k == 0) return head;
        ListNode dummyhead =  new ListNode(0);
        dummyhead.next = head;
        
        ListNode fast = dummyhead;
        ListNode slow = dummyhead;
        
        
        int len = 0;
        
        while (fast != null && fast.next != null) {
            fast = fast.next;
            len++;
        }
        k = k % len;
    
        if (k == 0) return head;
        
        fast = dummyhead;
        
        while (k-- > 0 && fast != null) {
            fast = fast.next;
        }
        
        
        
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        
        dummyhead.next = slow.next;
        fast.next = head;
        slow.next = null;
        return dummyhead.next;
        
    }
}