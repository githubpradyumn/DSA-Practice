// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode removeElements(ListNode head, int val) {
//         ListNode curr = head;
//         ListNode prev = new ListNode(-1);
//         ListNode start = prev;
//         while(curr!=null){
//             while(curr!=null && curr.val==val){
//                 curr = curr.next;
//             }
//             while(curr!=null && curr.val!=val){
//                 prev.next = curr;
//                 curr = curr.next;
//                 prev = prev.next;
//             }
//         }
//         if(curr==null){
//             prev.next = null;
//         }
//         return start.next;
//     }
// }
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;  // unlink node
            } else {
                prev = curr;  // move prev only if node is kept
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
