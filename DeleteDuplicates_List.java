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
        ListNode dummyhead = new ListNode(-2);
        dummyhead.next = head;
        
        // if the values are equal to the prev, continue, 
        // be sure that the value is distinct, and then change the prev.  and delete the values. 
        
        int prevvalue = dummyhead.val;
        ListNode prev = dummyhead, curr = head, next = null;
       
        while (curr != null && curr.next != null) {
            if (curr.val == prevvalue) {
                curr = curr.next;
                continue;
            }
            else {
                if (curr.next.val != curr.val) {
                    prev.next = curr;
                    prev = curr;
                }
                prevvalue = curr.val;
                curr = curr.next;
            }
            
        }
        if (curr.val != prevvalue) {
            prev.next = curr;
        }
        else {
            prev.next = null;
        }
        
        return dummyhead.next;
        
    }
}



/////////////////////////////////////Bug_Free Version //////////////////////
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
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
       
        head = dummyhead;
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            }
            else {
                head = head.next;
            }
        }
        return dummyhead.next;
        
    }
}