package chapter_14;

/*
* 926. 将字符串翻转到单调递增
* */
public class fourteen_92 {
    /**
     没想出来。
     思路比较简单，就是看这个位置是翻0还是翻1，然后分两个计数。
     */
    public int minFlipsMonoIncr(String s) {
        // dp[i][0]表示前i个元素，最后一个元素为0的最小翻转次数；
        // dp[i][1]表示前i个元素，最后一个元素为1的最小翻转次数
        int dp[][]=new int[s.length()][2];
        // 初始化
        if (s.charAt(0) == '0') {
            dp[0][1] = 1;
        } else {
            dp[0][0] = 1;
        }
        // 状态转移
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                // 翻0只需前面的加一
                dp[i][0] = dp[i - 1][0] + 1;
                // 1的话前面可以是0也可以是1
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            }
        }
        return Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);
    }
}
