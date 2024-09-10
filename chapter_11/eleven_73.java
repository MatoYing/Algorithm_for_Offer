package chapter_11;

/*
* 875. 爱吃香蕉的珂珂
* */
public class eleven_73 {
    /**
     思路说白了就是把1到piles最大的值都试一遍。
     ！！！这是最后一道二分查找的题目，可以发现，二分查找最难的地方就是跳出while后，到底return
     哪个值。解决办法，在二分查找中去有更多约束（像和mid-1或mid+1有什么关系），尽量只可能返回
     mid。最后的答案一定是在跳出while呢个值附近，以此为突破点来去解决while外返回什么。
     */
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1;
        // 因为它每个小时只会选择一堆香蕉吃，所以最快也就是1小时1堆，所以right = max
        int right = max;
        // 时间有余right就减，不行left就加
        while (left <= right) {
            int mid = (left + right) / 2;
            int time = eatTime(mid, piles);
            // [2,2] 2
            // if (mid == 1) {
            //     return mid;
            // }
            if (time == h) {
                // 为什么不能直接返回mid：等于h时，题目要的的最小k（有好多个k等于h，他有一个区间，所以要的书mid-1之后就不满足h的mid）
                // mid等于1一定就是最小了,也就意味着最慢都可能用不了h天
                if (mid == 1 || eatTime(mid - 1, piles) == h - 1)
                    return mid;
                // 一定是这里导致了while不满足，所以return left
                right = mid - 1;
            } else if (time > h){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // [1,1,1]4,如果是这种，因为不可能够4天，所以right一定是最小了都不够（1）
        // 还有上面第一个if里的mid-1，所以返回right+1
        return right + 1;
    }

    public int eatTime(int mid, int[] piles) {
        int time = 0;
        for (int pile : piles) {
            time += pile / mid;
            if (pile % mid != 0)
                time += 1;
        }
        return time;
    }
}
