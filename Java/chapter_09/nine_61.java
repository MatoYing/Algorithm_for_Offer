package chapter_9;

import java.util.*;

/*
* 373. 查找和最小的 K 对数字
* */
public class nine_61 {
    /**
     看见题目中有说找最小的几个什么什么，可以考虑堆。
     当然能用堆排序，肯定也能用别的排序。肤浅理解的话，你要最小的几个，堆排序的话只用排一部分，
     可能更省吧。
     思路不难，主要是写法注意一下。
     这也算是大根堆的妙用。正常看到求最小的几个什么，肯定会想到小根堆，但这个无脑用小根堆会超出
     内存限制，所以需要卡一下。但小根堆没法卡，它只能poll出最小的。所以使用了大根堆，它每次poll
     出最大的，然后和当前的比，比当前的大就把它扔了用新的。然后通过“maxHeap.size()>=k”卡内存。
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 数组的写法！！！！
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] + p2[1] - p1[0] - p1[1]);
        // 这里和k比大小算是妙用（不加会超时）。首先因为这里的两个数组是顺序的。
        // 比如说nums2的长度大于了k，后面就没必要比了，因为我只要k个，nums1最少1个
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                if (maxHeap.size() >= k) {
                    // 取数组方式
                    int[] root = maxHeap.peek();
                    if (root[0] + root[1] > nums1[i] + nums2[j]) {
                        // 扔掉大的
                        maxHeap.poll();
                        maxHeap.offer(new int[] {nums1[i], nums2[j]});
                    }
                } else {
                    maxHeap.offer(new int[] {nums1[i], nums2[j]});
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        // 因为上面卡了k，所以只可能比k小
        while (!maxHeap.isEmpty()) {
            int[] vals = maxHeap.poll();
            res.add(Arrays.asList(vals[0], vals[1]));
        }
        Collections.reverse(res);
        return res;
        // 为啥不能直接return Collections.reverse(res)？
        // 因为Collections.reverse(res)返回的void
    }
}
