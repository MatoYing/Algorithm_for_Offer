package chapter_4;

/*
* 143. 重排链表
* */
public class four_26 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /**
     这个题评论都说好，确实。
     首先这个答案就是先拆分成两半，然后一个一个顺序连接就是答案。
     步骤就是：1.快慢指针找到中间节点；2.反转后半段链表；3.合并前半段链表和后半段链表
     */
    public void reorderList(ListNode head) {
        if (head.next == null)
            return;
        // 确定分割点
        ListNode low = head;
        ListNode fast = head;
        ListNode middle;

        low = head;
        fast = head;
        while (fast.next != null && fast.next.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        middle = low.next;
        // 彻底分割两个链表，这里如果不切干劲，最后，head如果最后一个连前半部分的最后一个会有环
        low.next = null;

        // 翻转后半链表
        middle = reverseList(middle);

        // 开始连接
        low = head;
        head = low;
        fast = head.next;
        while (true) {
            // 这儿的顺序注意一下，先顺的写上一圈，然后删减更改
            low.next = middle;
            low = low.next;
            middle = middle.next;
            // if这两个位置，以及middle = middle.next和fast = fast.next，这两个位置注意一下
            // if这两个位置主要是因为，奇数个和偶数个最后一点的位置不同，自己画一下更好理解
            if (middle == null && fast == null)
                break;
            low.next = fast;
            low = low.next;
            fast = fast.next;
            if (middle == null && fast == null)
                break;
        }
    }

    // 翻转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
