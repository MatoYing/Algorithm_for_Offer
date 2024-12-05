package chapter_11;

import java.util.Random;

/*
* 528. 按权重随机选择
* */
public class eleven_71 {
    private int[] sums;
    private int total = 0;
    /**
     这题的意思就是对于w=[1,3]，挑选下标0的概率为1/(1+3)=0.25（即，25%）,也就是0到1的概率，
     而3也就是1到4的概率（看书上的图会立马理解）,像是堆积木（1堆3，终点成了4）。
     就是一个转换吧，然后用二分查找确定区间，确定下标。
     */
    public eleven_71(int[] w) {
        sums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }

    public int pickIndex() {
        Random random = new Random();
        // 这里不用total+1，因为你像[1,3]，坐标0的选项只有0，坐标1的选项有1，2，3（没有4），
        // 当然从1开始的话就需要total+1
        int p = random.nextInt(total);
        // 找到它的位置
        int left = 0;
        int right = sums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sums[mid] > p) {
                if (mid == 0 || sums[mid - 1] <= p)
                    return mid;
                else
                    right = mid - 1;
            } else if (sums[mid] == p)
                return mid + 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
