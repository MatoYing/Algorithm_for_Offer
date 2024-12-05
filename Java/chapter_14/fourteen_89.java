package chapter_14;

/*
* 198. 打家劫舍
* */
public class fourteen_89 {
    /**
     最大的问题：状态转移方程怎么写？因为他只是不能连续，其他方式都可以。
     其实这个dp和上一道题一样，就i-2和i-1比就行。
     eg：[10,1,1,10]，按我的理解它只可能取10和1；1和10。其实不是的，最终就是10和10
     过程：
     dp[0] = 10
     dp[1] = 10
     dp[2] = 11
     dp[3] = 20
     换个角度想：状态转移方程其实唯一的作用就是保证不连续取，并不会保证中间到底隔了几个，而我只需要
     保证不要连续取就行。每个dp都是该位置最好的结果（有点贪心的意思），而我要尽可能多拿，所以要么拿
     i-2要么就是拿i-1。
     */
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
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
