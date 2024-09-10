package chapter_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 56. 合并区间
* */
public class twelve_74 {
    /**
     思路还是比较简单的，按第一个值排序，然后一个一个看能不能合就行。
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        // 声明一个数组操作起来麻烦，而且list还能直接toArray
        List<int[]> merged = new ArrayList<>();
        // int[][] merged = new int[intervals.length][2];
        // 标志最后一个值有没有被合并
        boolean flag = false;
        for (int i = 0; i < intervals.length - 1; i++) {
            int k = i + 1;
            while (intervals[k][0] <= intervals[i][1]) {
                intervals[i][1] = Math.max(intervals[k][1], intervals[i][1]);
                k++;
                if (k == intervals.length) {
                    flag = true;
                    break;
                }
            }
            merged.add(intervals[i]);
            // 从k开始遍历。减一是因为到了for循环会再加一下
            i = k - 1;
        }
        // 如果最后一个值没有被合并的话，上面是处理不掉的
        if (!flag)
            merged.add(intervals[intervals.length - 1]);
        return merged.toArray(new int[merged.size()][]);
    }
}
