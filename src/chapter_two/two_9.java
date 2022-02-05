package chapter_two;

/*
* 713. 乘积小于K的子数组
* */
public class two_9 {
    /**
        思路：
            这和面试题8差不多。最关键的就是“count += right - left + 1”。
            网友解释：right-left+1的切入点是思维要放在区间的右边往左边延伸，例如区间
            [1, 2, 3, 4]满足要求，固定住right(4)的点，可选区间右[4]、[4, 3]、[4,
            3, 2]、[4, 3, 2, 1]即为数组的长度，也就是right-left+1。而right是递增
            的，此时[1, 2, 3]的区间已经处理完（[3]、[3, 2]、[3、2、1]）。
            起初我自己的想法是，每次卡出来right的最大值，然后想办法求left和right间这
            几个数有多少中组合，这到是也能写出来，不过没人家简单。人家的思路是每走个right，
            就计算（每个组合都包含right）。
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int sum = 1;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum *= nums[right];
            while (left <= right && sum >= k) {
                sum /= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }
}
