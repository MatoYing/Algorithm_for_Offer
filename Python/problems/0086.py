from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

"""
刚开始的想法：
1）把第一个大于k的标记下来
2）声明一个空的Linkedlist，存小于k的
3）麻烦的就是每次都得有一个指针记录“小的”的前一个，删了小的后，这个指针在连“小的”后一个
4）最后把原链表接到“小的”链表后面

更好的想法：
1）先声明两个空链表A、B，然后顺序遍历head
2）遇到“小的”整体接到A（A.next = original）
3）遇到正常的整体接到B
（也就是一会剩下的链表都跟在了A后，一会右都跟在了B后）
4）将B接到A得后面

第二个逻辑更简单，不用有“删”的步骤了，不容易出错。以后遇到这种合并链表的类型，用这种思路，不要想着“删点”。
"""
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        dummy_small = ListNode(-1)
        dummy_normal = ListNode(-1)

        cur1 = dummy_small
        cur2 = dummy_normal

        while head is not None:
            if head.val < x:
                cur1.next = head
                cur1 = cur1.next
                head = head.next
            else:
                cur2.next = head
                cur2 = cur2.next
                head = head.next

        # 这步很关键
        # 就比如左面题上的图，cur2切到5后，cur1接到了2，但5其实还是连接2的，所以要额外让它等于None
        # 可以养成一个习惯，但凡遇到这种拼接、走到末尾的情况，一定记得考虑这个问题
        cur2.next = None

        cur1.next = dummy_normal.next

        return dummy_small.next