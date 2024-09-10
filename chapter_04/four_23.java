package chapter_4;

/*
* 160. 相交链表
* */
public class four_23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /**
     思路很简单，就是两个头结点都先走一遍，获得长度，让后让长的先走完呢个差值，然后在一起走，
     相遇时，就是第一个重合节点。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 计算a、b的长度
        int a = 0;
        int b = 0;
        // 存储头结点
        ListNode headA2 = headA;
        ListNode headB2 = headB;
        // 计算长度不两种，第一种更好一些
        while (headA != null) {
            a++;
            headA = headA.next;
        }

        while (headB.next != null) {
            b++;
            headB = headB.next;
        }
        b++;

        if (a > b) {
            for (int i = 0; i < Math.abs(a - b); i++)
                headA2 = headA2.next;
        } else {
            for (int i = 0; i < Math.abs(a - b); i++)
                headB2 = headB2.next;
        }
        // 这里不能写headA2.next=null，这样两个长度为1的会漏判
        while (headA2 != null) {
            if (headA2 == headB2)
                return headA2;
            headA2 = headA2.next;
            headB2 = headB2.next;
        }
        return null;
    }
}
