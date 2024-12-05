package chapter_4;

/*
* 剑指 Offer II 029. 排序的循环链表
* */
public class four_29 {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    /**
     思路还是比较简单的，就常规思路去找就行，要注意的就是要单独处理比最大值大，比最小值小的值。
     */
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        // head不是头节点
        if (head == null) {
            head = node;
            node.next = node;
        }

        if (head.next == null) {
            head.next = node;
            node.next = head;
        }
        // 存头节点位置
        Node dummy;
        dummy = head;
        // 存最大值点
        Node max = head;
        do {
            // 正常插
            if ((head.val < insertVal && head.next.val > insertVal) || head.val == insertVal || head.next.val == insertVal) {
                Node temp = head.next;
                head.next = node;
                node.next = temp;
                return dummy;
            }
            // 找最大值点，最后插呢中比最大值大，或比最小值小的点
            if (head.val > head.next.val)
                max = head;
            head = head.next;
        } while (head != dummy);  // 节点的比较，就这样比！这样可以确定循环了一圈

        // 插入比最大值大，或比最小值小的点
        Node temp = max.next;
        max.next = node;
        node.next = temp;
        return dummy;
    }
}
