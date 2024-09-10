package chapter_7;

import java.util.ArrayDeque;
import java.util.Deque;

/*
* 剑指 Offer II 041. 滑动窗口的平均值
* */
public class seven_41 {
    Deque<Integer> deque;
    int size;
    int temp = 0;

    /**
     比较基础的队列用法。
     */
    /** Initialize your data structure here. */
    public seven_41(int size) {
        deque = new ArrayDeque<>();
        // this代表当前对象
        this.size = size;
    }

    public double next(int val) {
        if (temp == size) {
            deque.poll();
            deque.offer(val);
        } else {
            deque.offer(val);
            temp++;
        }
        int sum = 0;
        for (int i : deque) {
            sum += i;
        }
        return sum * 1.0 / temp;
    }
}
