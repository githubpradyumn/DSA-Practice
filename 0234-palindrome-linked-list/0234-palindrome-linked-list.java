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
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        ListNode curr = head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            stack.push(curr.val);
            curr=slow;
        }
        if(fast!=null){
            slow=slow.next;
        }
        while(!stack.isEmpty()){
            if(stack.pop()!=slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}