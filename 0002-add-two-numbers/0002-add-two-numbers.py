# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        carry=0
        dummy=ListNode(-1)
        temp=dummy
        while l1 and l2:
            newval=carry+l1.val+l2.val
            carry=newval//10
            newnode=ListNode(newval%10)
            temp.next=newnode
            temp=temp.next
            l1=l1.next
            l2=l2.next

        while l1:
            newval=carry+l1.val
            carry=newval//10
            newnode=ListNode(newval%10)
            temp.next=newnode
            temp=temp.next
            l1=l1.next
        
        while l2:
            newval=carry+l2.val
            carry=newval//10
            newnode=ListNode(newval%10)
            temp.next=newnode
            temp=temp.next
            l2=l2.next
        
        if carry:
            temp.next = ListNode(carry)

        return dummy.next


        
        
        






        