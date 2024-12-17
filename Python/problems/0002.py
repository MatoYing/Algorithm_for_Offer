from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

"""
简单
"""
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        cur = dummy

        temp = False
        while l1 or l2:
            if l1 and l2:
                new = l1.val + l2.val
                l1 = l1.next
                l2 = l2.next
            elif l1:
                new = l1.val
                l1 = l1.next
            else:
                new = l2.val
                l2 = l2.next

            if temp:
                new += 1

            if new >= 10:
                temp = True
                new = new % 10
            else:
                temp = False

            cur.next = ListNode(new)
            cur = cur.next

        if temp:
            cur.next = ListNode(1)
        return dummy.next