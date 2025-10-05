/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode curr = prev;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            curr = slow;
            slow = slow.next;
            curr.next = prev;
            prev = curr;
        }
        if(fast!=null){
            slow = slow.next;
        }
        while(curr!=null){
            if(curr.val!=slow.val){
                return false;
            }
            curr = curr.next;
            slow = slow.next;
        }
        return true;
    }
}