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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }else if (head.next == null) {
            return head;
        } else {
            ListNode l1 = head;
            ListNode l2 = head.next;
            while(l2!=null){
                if(l1.val == l2.val){
                    l1.next = l2.next;
                    l2 = l2.next;
                } else {
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
        }
    return head;
    }
}