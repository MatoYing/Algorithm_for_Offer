package chapter_two;

import java.util.HashMap;
import java.util.Map;

/*
* 525. 连续数组
* */
public class two_11 {
    /**
     可以参考：https://leetcode-cn.com/problems/contiguous-array/solution/525lian-xu-shu-zu-qian-zhui-he-hashbiao-riqe2/
     这个和面试题10还是比较相似的，依然是卡住right去找。这两道题要对比的看。
     首先为什么将0转成-1:我最先想的是，加起来的和等于长度除以2，就证明可以；显然将0转成
     -1，这样加起来为0，就可以证明可以。
     我将它的思路更简单的说一下。首先如果你不利用map的value也是可以的，...-2(a)、c...-2(b)...
     ，你可以就写个数组，到了b，它等于a，就说明c到b的和为0，也就是0、1个数相同。如果写成
     map的形式，（sum，index（最旧的和为sum的，因为要找长度最长的）），因为你卡的是right！
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        // 这个其实无关紧要，-1也好，1也好，主要看“1 - mp.get(sum)”你这儿怎么写
        mp.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                sum -= 1;
            else
                sum += 1;

            if (mp.containsKey(sum))
                maxLength = Math.max(maxLength, i - mp.get(sum));
            else
                mp.put(sum, i);
        }
        return maxLength;
    }
}
