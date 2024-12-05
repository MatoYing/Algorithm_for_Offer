from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

"""
思路很简单，就是两个头结点都先走一遍，获得长度，让后让长的先走完呢个差值，然后在一起走，相遇时，就是第一个重合节点。
"""
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        cur1 = headA
        cur2 = headB

        lengthA = 0
        while cur1:
            lengthA += 1
            cur1 = cur1.next

        lengthB = 0
        while cur2:
            lengthB += 1
            cur2 = cur2.next

        cur1 = headA
        cur2 = headB
        if lengthA >= lengthB:
            for _ in range(lengthA - lengthB):
                cur1 = cur1.next
        else:
            for _ in range(lengthB - lengthA):
                cur2 = cur2.next

        while True:
            if cur1 != cur2:
                cur1 = cur1.next
                cur2 = cur2.next
            else:
                return cur1
