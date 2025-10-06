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
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = new ListNode(-1);
        ListNode start = prev;
        while(curr!=null){
            while(curr!=null && curr.val==val){
                curr = curr.next;
            }
            while(curr!=null && curr.val!=val){
                prev.next = curr;
                curr = curr.next;
                prev = prev.next;
            }
        }
        if(curr==null){
            prev.next = null;
        }
        return start.next;
    }
}