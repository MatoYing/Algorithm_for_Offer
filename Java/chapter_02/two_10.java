package chapter_2;

import java.util.HashMap;
import java.util.Map;

/*
* 560. 和为 K 的子数组
* */
public class two_10 {
    /**
     首先注意，这里说的是"子数组"，不能sort。
     结合leetcode官方解题的动画可以很好的理解.
     由于这道题数字可正可负，所以无法像前几道题的使用双指针（因为right右移sum不一定
     增加，left右移sum不一定减少）。
     ！！！很重要的一点，这道题永远卡住了right（就像上一道题一样）。
     为什么用map：可以快速查找sum-k，如果是一个数组是办不到的。
     map的value是干什么的，为什么count要加它，如果先加了一个1，后面变成2又加2不会重复吗：
     自己写一下应该也懂了，要记住他卡住了right，因为题目要求的是count，如果比如说sum-k
     等于7，sum为...7(a)..7(b)..，答案就是right到b，和right到a；而之前的是当时呢个right
     到a。

     总而言之，理解这道题需要看leetcode的动画+记住永远卡住right
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int count = 0;
        // 比如说k=1，sum只有一个为1，所以1-1，count+1，看图就能懂
        mp.put(0, 1);
        for (int num: nums) {
            sum += num;
            count += mp.getOrDefault(sum - k, 0);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return count;

    }

}
