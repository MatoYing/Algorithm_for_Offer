from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

"""
dummy = ListNode(-1)
dummy.next = head
slow = dummy
fast = head
刚开始我是像做“删除排序链表中的重复元素I”一样，用了上面的声明，应该是也能做的，逻辑复杂些，
你需要每次去比slow.next.val == fast.next.val（“保”slow）。

下面的方式会简洁很多，也是“保”slow，但比较时只用fast比。

经验：这种删点的，都是要“保”slow，如果不能slow.val == fast.val这样比，也就是如果合适直接添加slow，
就用fast.val == fast.next.val试一试。
而这个其实就是slow.next.val == fast.next.val的变形，但这种逻辑太复杂了。
"""
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        slow = dummy
        fast = head

        # 不能写fast and fast.next，最后一个点判断不了
        # “链表的中间结点”呢到题写是因为它只是寻找中间节点，根据它的规律正好可以满足fast and fast.next同时判断
        while fast:
            if fast.next and fast.val == fast.next.val:
                temp = fast.val
                while True:
                    fast = fast.next
                    # 注意这里的is None
                    if fast.next is None or fast.next.val != temp:
                        fast = fast.next
                        break
            else:
                slow.next = fast
                slow = slow.next
                fast = fast.next

        slow.next = None

        return dummy.next
