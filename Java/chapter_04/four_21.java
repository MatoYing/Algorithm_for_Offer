package chapter_4;

/*
* 19. 删除链表的倒数第 N 个结点
* */
public class four_21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     快慢指针，low比fast快几个，最后走到末尾也就找到了倒数第几个
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 建立头结点（方便统一边界操作）
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode low = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        low.next = low.next.next;
        // 去掉头结点
        ListNode ans = dummy.next;
        return ans;
    }
}
