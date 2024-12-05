from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

"""
相遇时：
f = 2s(快指针每次2步，慢指针1步)
f = s + nb(相遇时，刚好走了n圈)
所以相遇时：s = nb
相遇之后，让fast从头
当fast指针走到f=a步时，slow指针走到步s=a+nb，此时 两指针重合，并同时指向链表环入口。
"""
class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = head
        fast = head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

            # 第一次相遇
            if slow == fast:
                break

        # 正常来说，上面wile结束肯定是因为break；还有可能就是原图根本就没换环，比如[1,2]和[1]
        # 过滤无环的情况
        if fast is None or fast.next is None:
            return None

        fast = head
        while fast != slow:
            fast = fast.next
            slow = slow.next

        return fast