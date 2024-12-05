package chapter_12;

import java.util.Arrays;

/*
* 1122. 数组的相对排序
* */
public class twelve_76 {
    /**
     直接用函数了，改天复习排序方式时，来这儿写写。
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
