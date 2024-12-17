from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

"""
思路类似”26. 删除有序数组中的重复项“。
"""
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None

        slow = head
        fast = head.next
        while fast:
            if fast.val != slow.val:
                slow.next = fast
                slow = slow.next
                fast = fast.next
            else:
                fast = fast.next

        # 记得切断后面不相关的
        slow.next = None

        return head