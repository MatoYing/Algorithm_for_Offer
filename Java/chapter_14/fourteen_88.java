package chapter_14;

/*
* 746. 使用最小花费爬楼梯
* */
public class fourteen_88 {
    /**
     动态规划五部曲：
     1.确定dp[i]的下标以及dp值的含义：从楼梯第i个台阶向上爬需要支付的费用dp[i]；
     2.确定动态规划的递推公式：dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
     3.dp数组的初始化：你可以选择从下标为0或下标为1的台阶开始爬楼梯dp[0] = 0, dp[1] = 0;
     4.确定遍历顺序：分析递推公式可知当前值依赖前两个值来确定，所以递推顺序应该是从前往后；
     5.打印dp数组看自己写的对不对；
     */
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        // 定义dp数组：到达第i个台阶所需费用
        int[] dp = new int[size + 1];
        // dp数组初始化
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= size; i++) {
            // 从dp[i-1]花费cost[i-1]的费用可以到达dp[i];
            // 从dp[i-2]花费cost[i-2]的费用可以到达dp[i];
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[size];
    }
}
