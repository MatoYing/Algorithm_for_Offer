from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

"""
1 -> 2 -> 3 -> 4
None <- 1, 2 -> 3 -> 4
None <- 1 <- 2, 3 -> 4
None <- 1 <- 2 <- 3, 4
None <- 1 <- 2 <- 3 <- 4
"""
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pre = None
        cur = head
        while cur:
            # 第一步，先拿到cur后面的
            nxt = cur.next
            # 第二步，变cur
            cur.next = pre
            # 第三步，向后移pre
            pre = cur
            # 第四步，向后移cur
            cur = nxt
        return pre
