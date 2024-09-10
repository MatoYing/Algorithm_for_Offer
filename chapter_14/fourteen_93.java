package chapter_14;

import java.util.HashMap;
import java.util.Map;

/*
* 873. 最长的斐波那契子序列的长度
* */
public class fourteen_93 {
    /**
     很难，不看答案根本想不到。和之前有个共同点吧就是把条件缩小化，像这个变成卡两个。
     dp[i][j]：以arr[i],arr[j]结尾的斐波那契式。
     */
    public int lenLongestFibSubseq(int[] arr) {
        int dp[][] = new int[arr.length - 1][arr.length];
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // 要构成要与arr[i],arr[j]构成斐波那契式的倒数第三个值
                int step = arr[j] - arr[i];
                if (map.containsKey(step) && map.get(step) < i) {
                    int k = map.get(step);
                    //////////
                    // 进入这个if，也就意味着确定了倒数第三个值
                    // 然后继续往前推，以arr[k],arr[i]结尾的斐波那契式有几个
                    // 因为dp[i][j]默认是0，但你选了arr[i],arr[j]也就意味着有了两个，所以下面的要加2；这里是要加k的，所以加1
                    dp[i][j] = dp[k][i] + 1;  // 这个1就是k
                    //////////
                    maxLen = Math.max(maxLen, dp[i][j] + 2);  // 2代表着i和j
                }
            }
        }
        return maxLen;
    }
}
