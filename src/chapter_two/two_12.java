package chapter_two;

/*
* 724. 寻找数组的中心下标
* */
public class two_12 {
    /**
     经过前几道题的洗礼，这个很简单。思路就是先算出总和，然后从左开始遍历，声明个变量存储遍历
     过的值的和，用sum减遍历到位置处的和，和index所对应的值，看看相不相等。
     */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num: nums)
            sum += num;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (temp - nums[i] == sum - temp)
                return i;
        }
        return -1;
    }
}
