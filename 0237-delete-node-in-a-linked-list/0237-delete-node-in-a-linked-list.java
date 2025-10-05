/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        // ListNode prev = curr;
        // if(curr.next!=null){
            while(curr!=node){
                curr = curr.next;
            }
        // }
        curr.val = curr.next.val;
        curr.next = curr.next.next;
    }
}