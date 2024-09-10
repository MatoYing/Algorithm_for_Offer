package chapter_14;

import java.util.Arrays;

/*
* 213. 打家劫舍 II
* */
public class fourteen_90 {
    /**
     很巧妙。这个问题可以转化成max（不偷第一个房子的最大值，不偷最后一个房子的最大值）
     */
    public int rob(int[] nums) {
        // 注意一个值的时候，copy出来是空
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int a = minRob(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int b = minRob(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(a, b);
    }

    public int minRob(int[] nums) {
        // 分割进来后可能是1个
        if (nums.length == 1)
            return nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
