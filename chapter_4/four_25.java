package chapter_4;

/*
* 445. 两数相加 II
* */
public class four_25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /**
     首先为什么不能直接把来两个链表的数全读完，在相加存到新的链表中，因为会溢出。
     思路就是分别反转两个链表，然后正常加，注意进一。

     到时候能用栈就用栈吧，这个非常麻烦。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode l3 = new ListNode();
        // 保存头节点
        ListNode head;
        head = l3;
        boolean flag = false;
        while (true) {
            int temp;

            //计算链表对应的和
            if (l1 != null && l2 != null) {
                temp = l1.val + l2.val;
            }
            else if (l1 != null) {
                temp = l1.val;
            }
            else {
                temp = l2.val;
            }

            //计算新节点的值
            if (flag == true) {
                // 小心[1][9,9]
                temp += 1;
                if (temp >= 10) {
                    temp %= 10;
                    flag = true;
                } else
                    flag = false;
            } else {
                if (temp >= 10) {
                    temp %= 10;
                    flag = true;
                } else
                    flag = false;
            }
            l3.val = temp;

            // 小心[0][0]，所以l1!=null && l2!=null
            if (l1 != null && l2 != null && l1.next != null && l2.next != null) {
                l1 = l1.next;
                l2 = l2.next;
                l3.next = new ListNode();
                l3 = l3.next;
            } else if (l1 != null && l1.next != null) {
                // l2已经结束
                l1 = l1.next;
                // 为了上边计算temp的判断
                l2 = null;
                l3.next = new ListNode();
                l3 = l3.next;
            } else if (l2 != null && l2.next != null) {
                // l1已经结束
                l2 = l2.next;
                l1 = null;
                l3.next = new ListNode();
                l3 = l3.next;
            } else {
                // 两个都加完了
                if (flag) {
                    // 万一有进一
                    l3.next = new ListNode(1);
                    l3 = l3.next;
                    return reverseList(head);
                } else
                    return reverseList(head);
            }
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
