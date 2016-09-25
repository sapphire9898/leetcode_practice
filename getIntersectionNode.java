public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
            ListNode currenta = headA;
            ListNode currentb = headB;
            while (currenta != currentb) {
                
                currenta = (currenta == null)? headB : currenta.next;
                currentb = (currentb == null)? headA : currentb.next;
            }
            return currentb;
            
       
        
        
    }
}