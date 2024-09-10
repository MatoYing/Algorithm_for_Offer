package chapter_9;

import java.util.PriorityQueue;

/*
* 703. 数据流中的第 K 大元素
* */
public class nine_59 {

    PriorityQueue<Integer> pq;
    int k;

    /**
     还是比较简单的，理解清楚题意就好。题目是让你每次返回第K大的数字，也就意味着，你使用最大堆
     每次保存k个元素就可以（因为它是poll出的是最小的）。
     */
    public nine_59(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
    }

    public int add(int val) {
        pq.offer(val);
        // PriorityQueue默认是小根堆，所以每次poll出的是最小的元素，所以卡住size就可以。
        // 如果是大根堆：不能这么用，你poll就会把最大的扔出去。
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
