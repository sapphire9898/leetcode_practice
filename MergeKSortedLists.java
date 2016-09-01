/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }
    
    private ListNode helper(ListNode[] lists, int start, int end) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        else if (start + 1 == end) {
            return mergeTwoLists(lists[start], lists[end]);
        }
        
        int mid = (start + end) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        
        return mergeTwoLists(left, right);
        
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode current = dummyhead;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            
            if (val1 < val2) {
                current.next = l1;
                l1 = l1.next;
                
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
            
        }
        return dummyhead.next;
    }
}