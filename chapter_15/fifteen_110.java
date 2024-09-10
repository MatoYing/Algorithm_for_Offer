package chapter_15;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
* 797. 所有可能的路径
* */
public class fifteen_110 {
    /**
     没想到这道题令我最大的困惑居然是不知道怎么传每个答案list。
     和DFS对比，它传list的方式是，一直就一个，每次不合适退回来remove掉最后一个；最后合适的时候，new一个新的。
     而BFS，每次加一个就创一个新的。
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        List<List<Integer>> list = new ArrayList<>();
        Queue<ArrayList<Integer>> queue = new ArrayDeque<>();
        for (int i : graph[0]) {
            ArrayList<Integer> cur = new ArrayList();
            cur.add(0);
            cur.add(i);
            queue.offer(cur);
        }
        while (queue.size() != 0) {
            int size = queue.size();
            while (size != 0) {
                ArrayList<Integer> temp = queue.poll();
                if (temp.get(temp.size() - 1) == target) {
                    list.add(temp);
                } else {
                    int index = temp.get(temp.size() - 1);
                    for (int i : graph[index]) {
                        ArrayList<Integer> cur = new ArrayList(temp);
                        cur.add(i);
                        queue.offer(cur);
                    }
                }
                size--;
            }
        }
        return list;
    }
}
