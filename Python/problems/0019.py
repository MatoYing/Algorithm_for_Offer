from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

"""
如何找到倒数第k个node？直接记住：
从dummy开始，先让cur1走k步，然后cur2和cur1一起走，直到cur1为None。
上面的结论包括head = [1], n = 1这种也适用。
"""
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head
        cur1 = dummy
        cur2 = dummy

        # 找第n个的前一个
        for i in range(n + 1):
            cur1 = cur1.next

        while cur1:
            cur2 = cur2.next
            cur1 = cur1.next

        cur2.next = cur2.next.next

        return dummy.next