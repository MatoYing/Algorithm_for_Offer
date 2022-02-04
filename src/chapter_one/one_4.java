package chapter_one;

/*
* 137. 只出现一次的数字 II
* */
public class one_4 {
    /**
     思路：
        题目中，除了一个出现了一次，其余都出现了三次。所以只要将所有的数加起
        来（用二进制来想），他们的和除以3，所得的余数就是那个仅出现一次的数。
     注意：
        虽然没有用到，任何一个数字异或它自己结果都是0。
     */
    public int singleNumber(int[] nums) {
        //因为int最高是32位（对于二进制）
        int[] sum = new int[32];
        int res = 0;
        for (int num : nums) {
            // 注意是从0位开始的
            for (int i = 0; i < 32; i++) {
                // 提取出来每位的数
                sum[i] += num >> (31 - i) & 1;  // 与1&，可以得到二进制的最后一位数
            }
        }
        //注意<<和+优先级
        for (int i = 0; i < 32; i++) {
            // 本身是0左移还是0
            res = (res << 1) + sum[i] % 3;
        }
        return res;
    }
}
