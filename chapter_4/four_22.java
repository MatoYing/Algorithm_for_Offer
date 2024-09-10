package chapter_4;

/*
* 142. 环形链表 II
* */
public class four_22 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /**
     关键点：

     相遇时：
     f = 2s(快指针每次2步，慢指针1步)
     f = s + nb(相遇时，刚好走了n圈)
     所以相遇时：s = nb
     相遇之后，让fast从头
     当fast指针走到f=a步时，slow指针走到步s=a+nb，此时 两指针重合，并同时指向链表环入口 。

     其他思路（更容易想到，上面的low版）：
     比如：快慢指针第二次相遇时，就知道环的长度。然后再让快慢两个指针从头跑，快指针先移动，先
     移一个环的距离。然后快慢指针一个一个的走，相遇时快指针比慢指针快一圈，也就是环的入口处。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 第一次相遇
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        // 第二次相遇
        return fast;
    }
}
