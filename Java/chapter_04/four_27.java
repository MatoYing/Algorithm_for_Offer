package chapter_4;

import java.util.ArrayList;
import java.util.List;

/*
* 234. 回文链表
* */
public class four_27 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /**
     很简单，分成两半，翻转，一个一个比。
     但我觉得更直接、更快速的方式就是放list（数组还得知道大小）里前后俩指针顺序比
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            if (list.get(left) != list.get(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
