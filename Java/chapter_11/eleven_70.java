package chapter_11;

/*
* 540. 有序数组中的单一元素
* */
public class eleven_70 {
    /**
     手写一下会很好理解

     1.异或
     2.（1，1）（2，3）（3，4）（4）就像这样两两的走，第一次不同的就是答案
     基于这种思路，那二分查找的大体思路就是相同的mid往右走，不同mid往左走

     官方的应该更好一些，它的大意就是如果这个改，一定是偶数位，所以就比偶数位与前后的关系。
     */
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int left = 0;
        // 两个视为一组
        int right = (nums.length - 1) / 2;
        int mid = -1;
        // 因为你无法确定最后打破while时是因为left还是right
        boolean flag = true;
        while (left < right) {
            mid = (left + right) / 2;
            // 一组里的第二个值
            int back_mid = mid * 2 + 1;
            int front_mid = mid * 2;
            if (back_mid == nums.length)
                return nums.length - 1;
            if (nums[front_mid] == nums[back_mid]) {
                left = mid + 1;
                flag = true;
            }
            else {
                // 若果不等与就让right=mid，因为此时mid可能就是答案，mid-1会错过答案
                right = mid;
                flag = false;
            }
        }
        // 打破因为left；因为right
        if (flag)
            return nums[mid * 2 + 2];
        else
            return nums[mid * 2];
    }
}
