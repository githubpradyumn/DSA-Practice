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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        temp=head;
        int arr[]=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=temp.val;
            temp=temp.next;
        }
        k = k % len;
    int[] rotated = new int[len];

    for(int i = 0; i < len; i++){
        rotated[(i + k) % len] = arr[i];
    }
        ListNode newhead=new ListNode(rotated[0]);
        temp=newhead;
        for(int i=1;i<len;i++){
            ListNode newnode=new ListNode(rotated[i]);
            temp.next=newnode;
            temp=newnode; 
        }
        return newhead;
    }
}