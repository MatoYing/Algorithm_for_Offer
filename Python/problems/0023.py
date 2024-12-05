import heapq
from typing import List, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

"""
刚开始我没有看懂这个参数，因为是LinkedList，所有只要放一个Node就可以，
比如，head: Optional[ListNode]，Optional就代表可以为空，为了便于理解可以直接删掉它，
变成head: ListNode

这里的lists: List[Optional[ListNode]]，就是lists: List[ListNode]，也就是多个LinkedList的head

整体思路还是很简单的，想要强调的是之前遇到要合并的，比如“86. 分隔链表”，就会想到声明两个dummy，
一个接小的，一个接大的，最后拼起来。

这个只用了一个dummy，因为每次heap出来的都是最小的，可以直接往后接的，不像“86. 分隔链表”可能“大”可能“小”。
每次取出最小的后，在把最小的next加入heap。
"""
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # 重载 __lt__ 方法，让ListNode可以比大小
        ListNode.__lt__ = lambda a, b: a.val < b.val

        heap = []

        for i in lists:
            # [[]]：等价于[None]
            if i is not None:
                heap.append(i)

        heapq.heapify(heap)

        dummy = ListNode(-1)
        cur = dummy

        while heap:
            node = heapq.heappop(heap)
            next_node = node.next
            # 堆里面不能放None
            if next_node is not None:
                heapq.heappush(heap, next_node)

            cur.next = node
            cur = cur.next

        return dummy.next