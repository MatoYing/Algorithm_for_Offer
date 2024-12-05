package chapter_2;

/*
* 209. 长度最小的子数组
* */
public class two_8 {
    /**
        思路：
            还是比较简单，很好想，这次的双指针都是在左面，right>=left，总的来说还是无脑去
            计算所有的组合。和不到target时，right一直右移,并加right所对应的值（for循环）
            ；和>=target时，left右移动，并减left所对应的值（while循环）。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum >= target) {
                // 如果left==right，并且sum>target，1就一定是最小的了
                // 但是加这句用时可以超过40.23%，不加反而可以超过99.99%，我猜可能测试用例
                // 答案是1的比较少，所以出现这样的结果。
                // if (left == right)
                //     return 1;
                minLength  = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }

        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
