package chapter_14;

/*
* 416. 分割等和子集
* */
public class fourteen_101 {
    /**
     得理解理解，又好理解，又不好理解。对比一维和二维的01背包的写法。
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // 开始转为01背包，dp代表，容量为j的书包最多可以放多少
        // 此时nums[i]，不仅是它的重量还是它的价值
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            // 且需要注意的是第二层的循环我们需要从大到小计算，因为如果我们从小到大更新，dp[j - nums[i]]这一步已经不是上一层了（像01背包的表格）
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        if (dp[target] == target) {
            return true;
        } else {
            return false;
        }
    }

    // 二维写法
    public boolean canPartition2(int[] nums) {
         int len = nums.length;
         int sum = 0;
         for (int i = 0; i < len; i++) {
             sum += nums[i];
         }
         if (sum % 2 != 0)
             return false;
         int target = sum / 2;

         int[][] dp = new int[len + 1][target + 1];
         for (int i = 1; i <= len; i++) {
             for (int j = 1; j <= target; j++) {
                 if (j < nums[i - 1])
                     dp[i][j] = dp[i - 1][j];
                 else
                     dp[i][j] = Math.max(dp[i -1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
             }
         }
         if (dp[len - 1][target] == target)
             return true;
         else
             return false;
     }
}
