package chapter_12;

/*
* 23. 合并K个升序链表
* */
public class twelve_78 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /**
     为什么用分治（分而治之，应该就是归并排序吧）？顺序两个两个排和归并的排有啥区别？
     我觉的不用想呢么多，这个时间复杂度不好算，简单的想一个数组，把每一个ListNode想成一个数
     用冒泡和归并，显然归并更快，因为避免了一些比较，而且归并的时间复杂度小于冒泡排序。
     和“148. 排序链表”对比的看
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 对比“148. 排序链表”，这个不需要分，直接就和。
        return merge(lists, 0, lists.length - 1);
    }

    // 我觉得非常难想，画个二叉树便于理解，我觉得这种东西得背一下
    private ListNode merge(ListNode[] lists, int low, int high) {
        if (low == high) {
            return lists[low];
        }
        int mid = (high + low) / 2;
        ListNode l1 = merge(lists, low, mid);
        ListNode l2 = merge(lists, mid + 1, high);
        return mergeTwoLists(l1, l2);
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
