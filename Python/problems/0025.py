from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

"""
整体和“92. 反转链表 II”是比较相似的。
主要不同的地方是，92只有一个left_node，而这个left_node是变化的。
"""
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head
        pre_group = dummy

        # 拿到链表的长度
        temp = head
        length = 0
        while temp:
            length += 1
            temp = temp.next

        pre = None
        cur = head

        while length >= k:
            length -= k
            ###########模版###########
            # 不在是right - left + 1
            for _ in range(k):
                nxt = cur.next
                cur.next = pre
                pre = cur
                cur = nxt
            ##########################
            # temp用来处理变化的“left_node”
            temp = pre_group.next
            pre_group.next.next = cur
            pre_group.next = pre
            pre_group = temp

        return dummy.next