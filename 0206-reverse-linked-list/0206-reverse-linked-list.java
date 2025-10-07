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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr = head;
        ListNode next = head;
        ListNode dummy = null;
        while(curr!=null){
            next = curr.next;
            curr.next = dummy;
            dummy = curr;
            curr = next;
        }
        // if(curr!=null){
        //     curr.next = dummy;
        // }
        return dummy;
    }
}