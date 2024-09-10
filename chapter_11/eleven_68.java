package chapter_11;

/*
* 35. 搜索插入位置
* */
public class eleven_68 {
    /**
     书上主要是去卡(数组0开始)nums[mid]>=t,和nums[mid-1]<t，我这个其实也是，只不过
     是分开写了。i
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // 因为没法确定最后是low还是high打破while条件，所以mid最终可能在呢个最接近它
        // 的值的左边或右边
        if (nums[mid] > target) {
            return mid;
        } else {
            return mid + 1;
        }
    }
}
