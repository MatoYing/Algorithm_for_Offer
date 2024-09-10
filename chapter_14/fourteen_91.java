package chapter_14;

/*
* 剑指 Offer II 091. 粉刷房子
* */
public class fourteen_91 {
    /**
     和打家劫舍对比，它的要求是不能连的偷，所以dp[i]=min(i-2，i-1)，（注意当时例子10、1、1、
     10的理解），而这个是要连续的，但不能同色，下面这个写法就保证了不能同色，每个dp都是当前最好
     的结果，局部最优到最终的全局最优。
     我一直最担心的问题就是局部最优会不会影响到全局最优。不好解答，我需要看看去年的实验报告。
     强行解答，比如一个颜色超便宜，它的前一个也很便宜，前一个选了这个，导致现在不能选这个颜色，但是
     在别的情况下，依然会选上这个颜色。
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}
