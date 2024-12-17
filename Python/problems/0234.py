from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

"""
题不错，可以练到寻找中间点和翻转链表。
刚开始不知道如何处理奇数和偶数的情况，写了下发现非常容易处理，比如
1 -> 2 -> 3 -> 4 -> 5
变为
1 -> 2 -> 3 <- 4 <- 5

1 -> 2 -> 3 -> 4 -> 5 -> 6
变为
1 -> 2 -> 3 -> 4 <- 5 <- 6

所有直接while head and tail，比val即可。
"""
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        middle = slow

        pre = None
        cur = middle
        while cur:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        last = pre

        while head and last:
            if head.val == last.val:
                head = head.next
                last = last.next
                continue
            else:
                return False

        return True