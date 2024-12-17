from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

"""
1.将left-right进行翻转
2.将left-1连到right
3.将left连到right+1
"""
class Solution:

    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        # 1 -> [2 -> 3 -> 4] -> 5

        # 如果left=1会报错，所以别管三七二十一，上来直接声明dummy
        # left_node = head
        # for _ in range(left - 2):
        #     left_node = left_node.next

        dummy = ListNode(-1)
        dummy.next = head
        left_node = dummy
        for _ in range(left - 1):
            # 就是1
            left_node = left_node.next

        ###########模版###########
        pre = None
        # 就是2
        cur = left_node.next
        for _ in range(right - left + 1):
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        ##########################

        # 注意这俩顺序
        # 我刚开始还单独用变量存了“2”，其实没必要
        left_node.next.next = cur
        left_node.next = pre

        return dummy.next



