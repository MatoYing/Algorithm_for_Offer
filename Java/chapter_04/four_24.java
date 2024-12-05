package chapter_4;

/*
* 206. 反转链表
* */
public class four_24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /**
     这个思路就是一个一个倒就行了，像1、2、3、4，先倒1、2，在倒1、3。
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        // ListNode cur = head;
        // 这个目前我认为是可以直接用head的，因为链表本身是要改变的，他们呢种另cur = head，
        // 这是用在比如说获得长度，添加节点，本身结构不变，为了第二次还能重头遍历所以head不能变
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
