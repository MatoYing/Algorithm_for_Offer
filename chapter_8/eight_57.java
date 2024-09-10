package chapter_8;

import java.util.TreeSet;

/*
* 220. 存在重复元素 III
* */
public class eight_57 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /**
     abs(nums[i] - nums[j]) <= t
     这个可以转化成nums[i] - t <= j <= t + nums[i](注释掉的那段代码我刚开始一直不理解)，
     如果你直接abs(nums[i] - nums[j])，通过控制nums[j]，这样也能做，就是分别找刚刚大
     于等于nums[i]的值，和刚刚小于等于nums[i]的值，这样能保证减出来的值是最小的（更好理解）

     这个for循环第一个if很关键，卡住abs(i - j) <= k
     里面取ceiling和比大小卡住abs(nums[i] - nums[j]) <= t
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // Long是因为有一个测试用例故意难为你
        TreeSet<Long> set = new TreeSet<>();
        int n = nums.length;
        // 每次只找自己左面的，一步步扩大窗口，到了极限，窗口跟着移动
        for (int i = 0; i < n; i++) {
            // abs(i - j) <= k：这里就是呢个滑动窗口
            if (i > k) {
                set.remove((long)nums[i - k - 1]);
            }
            // 法一
            // Long low = set.ceiling((long) nums[i] - t);
            // if (low != null && low <= (long) nums[i] + t)
            //     return true;

            // 法二
            Long ceiling = set.ceiling((long) nums[i]);
            Long floor = set.floor((long) nums[i]);
            if (ceiling != null && Math.abs(nums[i] - ceiling) <= t)
                return true;
            if (floor != null && Math.abs(nums[i] - floor) <= t)
                return true;

            // add要放后面，比如i=0，你要找大于等于nums[i] - t，那么就会算上你自己，也就是0，也就一定满足
            set.add((long) nums[i]);
        }
        return false;
    }
}
