package chapter_4;

/*
* 430. 扁平化多级双向链表
* */
public class four_28 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    /**
     很清楚（注意他呢个递归和迭代的不同顺序）：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/solution/gong-shui-san-xie-yi-ti-shuang-jie-di-gu-9wfz/

     如何消除之前的链表关系？我刚开始的想法就是用呢个网址递归的思路写迭代，这样应该写不了，
     因为没办法保存每个child后的节点。但是按照网址的迭代路线图是可以写的，就是先合并一层，
     再往下；而不是一直到了最下面，在往上和。
     这个代码结合呢个网址的迭代图一起看，异常清晰。
     */
    public Node flatten(Node head) {
        Node dummy = head;
        while (head != null) {
            if (head.child != null) {
                Node temp;
                Node curr;
                // 标记child的呢个节点，和之后的节点
                temp = head.next;
                curr = head;
                head.next = head.child;
                // 删除child指向
                head.child = null;
                // 顺序走child链
                while (head.next != null)
                    head = head.next;
                // 改变child链第一个prev
                curr.next.prev = curr;
                // 连接原来链表(小心[1,null,2,null,3,null])
                if (temp != null) {
                    head.next = temp;
                    // 改变连接后，原来后半部分当一个节点的prev
                    temp.prev = head;
                }
                // 回到分割前，继续遍历
                head = curr;
            }
            head = head.next;
        }
        return dummy;
    }
}
