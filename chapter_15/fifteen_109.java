package chapter_15;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
* 752. 打开转盘锁
* */
public class fifteen_109 {
    /**
     比较麻烦，不写了。
     */
    public int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            // intsz=q.size() 记录此时队列的大小，保证了在本次遍历的过程中只能遍历到在上次拨完后所有新产生的密码，也就是只能够遍历本层的所有节点，对于在遍历过程中新加入的节点是不会遍历的。
            int sz = q.size();
            for (int i=0;i<sz;i++) { // 将当前队列汇总的所有节点向周围扩散
                String cur = q.poll();
                // 由于deadends中"死亡密码"的存在，当遍历到这些密码时需要跳过，不进行任何操作。
                if (deads.contains(cur)) continue;
                // 当遇到要找的target时就应该结束并返回拨动次数 stepstep
                if (cur.equals(target)) return step;
                // BFS，一个一个拨动
                for (int j=0;j<4;j++) {

                    String up_adjust = plusOne(cur, j);

                    // 需要一个visited集合来存储这些已经遍历过的密码：
                    if (!visited.contains(up_adjust)) {
                        q.offer(up_adjust);
                        visited.add(up_adjust);
                    }

                    String down_adjust = minusOne(cur, j);
                    if (!visited.contains(down_adjust)) {
                        q.offer(down_adjust);
                        visited.add(down_adjust);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // 向上拨动
    public String plusOne(String cur, int j) {
        char[] ch = cur.toCharArray();

        if (ch[j] == '9') ch[j] = '0';
        else ch[j] += 1;

        return new String(ch);
    }

    // 向下拨动
    public String minusOne(String cur, int j) {

        char[] ch = cur.toCharArray();

        if (ch[j] == '0') ch[j] = '9';
        else ch[j] -= 1;

        return new String(ch);
    }
}
