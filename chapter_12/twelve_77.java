package chapter_12;

import chapter_4.four_27;

/*
* 148. 排序链表
* */
public class twelve_77 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /**
     为什么链表用归并排序？
     因为链表只能“顺序访问”，其它排序算法无法很好的施展，而恰恰归并排序可以很好的发挥。

     这个题挺好的，看起来难，分开看其实很简单。
     */
    public ListNode sortList(ListNode head) {
        // 递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 找到链表中间节点并断开链表
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;
        // 开始递归
        ListNode left = sortList(head);  // head其实就是leftHead(已经断开了)
        ListNode right = sortList(rightHead);
        // 合并有序链表
        return mergeTwoLists(left, right);
    }

    // （876. 链表的中间结点）
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        // 传入head只有两个节点的时候，slow会指向第二个节点
        // 让fast提前走一个，就相当于下面呢中找到中间结点后又退一个
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        // 当时呢道题像[1,2]返回的是2，因为它规定了这种偶数个链表时返回第二个
        // ListNode slow = head;
        // ListNode fast = head;
        // while (fast != null && fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // return slow;
    }

    // （21. 合并两个有序链表）
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode head = new ListNode();
        ListNode real_head = head;
        // 用来标志是谁走没了
        boolean flag = false;
        while (true) {
            if (list1 == null) {
                break;
            } else if (list2 == null){
                flag = true;
                break;
            }
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            } else {
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }
        }
        if (flag) {
            while (list1 != null) {
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            }
        } else {
            while (list2 != null) {
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }
        }
        return real_head.next;
    }
}
