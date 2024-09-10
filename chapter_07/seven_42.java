package chapter_7;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* 933. 最近的请求次数
* */
public class seven_42 {

    Queue<Integer> queue;

    /**
     比较基础。
     */
    public seven_42() {
        queue = new ArrayDeque();
        // queue = new LinkedList();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000)
            queue.poll();
        return queue.size();
    }
}
