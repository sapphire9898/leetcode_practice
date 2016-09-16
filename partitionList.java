/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode first = new ListNode(0);
        ListNode lesscurr = first;
        
        ListNode large = new ListNode(1);
        ListNode largecurr = large;
        
        
        while (head != null) {
            if (head.val < x) {
                lesscurr.next = head;
                lesscurr = lesscurr.next;
            }
            else {
                largecurr.next = head;
                largecurr = largecurr.next;
            }
            head = head.next;
        }
        
        largecurr.next = null;// this line is very important. If not the program may be MLE. 
        lesscurr.next = large.next;
        
        return first.next;
        
    }
}