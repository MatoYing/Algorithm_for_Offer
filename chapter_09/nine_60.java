package chapter_9;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
* 347. 前 K 个高频元素
* */
public class nine_60 {
    /**
     这题最重要的掌握类似hashMap的这种怎么排序，就是让hashMap变成Map.Entry，
     成为一个整体不用分开考虑，只需要使用getKey()和getValue()！！！
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Map.Entry让一个hashMap值变成一个整体，否则只能拿key，要不拿value
        // hashMap排序就让他变成Map.Entry，成为一个整体不用分开考虑，只需要使用getKey()和getValue()
        // 这个写法很好，利用了lambda表达式。官方呢个解法在PriorityQueue里套数组也不错
        // 或者就用最原始的写法，不推荐
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        // entrySet()：将map转成Map.Entry
        queue.addAll(map.entrySet());
        int[] ans = new int[k];
        for (int i = 0; i < k; i++){
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }
}
