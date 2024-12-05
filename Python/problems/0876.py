from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

"""
思路就是，声明两个指针，从head开始，fast每次走两个，slow每次走一个，最后返回slow。
如果是偶数，返回中间偏后的点。
"""
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = head
        fast = head

        # 难道fast.next不为空还证明不了fast不为空吗？
        # 首先fast.next是为了保证fast.next.next不会报错
        # fast.next不为空可以证明fast不为空，但有一个问题是fast可能为空，从而导致fast.next报错
        # 而其实判断fast是为了保证fast.next不会报错
        # 例如[1,2,3,4,5,6]
        # 第一次fast从1走到3
        # 第二次fast从3走到5
        # 第三次fast从5走到None
        # 这时如果只判断fast.next是否为None将会报错
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        return slow