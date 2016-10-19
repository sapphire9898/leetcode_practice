/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        // prev is the node to add 1  if the nodes afterwards are 9. 
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val != 9) {
                prev = curr;
            }
            curr = curr.next;
        }
        
        // curr.next == null, if prev.next = curr, then we only need to check if curr == 9
        // if curr == 9, curr = 0, prev += 1;
        // if curr != 9, curr += 1;
        if (curr.val != 9) {
            curr.val += 1;
        }
        else {
        if (prev.next == curr) {
            if (curr.val == 9) {
                curr.val = 0;
                prev.val += 1;
            }
            else curr.val += 1;
        }
        // curr.next == null, curr is the node of last one. if prev == 1, pre.next -- curr are 9; we need to do something.
        else {
            prev.val += 1;
            ListNode changeIndex = prev.next;
            while (changeIndex != curr.next) {
                changeIndex.val = 0;
                changeIndex = changeIndex.next;
            }
        }
        }
        
        return dummy.val == 1 ? dummy : head;
         // check 9999999.
        
        
        
    }
}