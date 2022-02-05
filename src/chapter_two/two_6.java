package chapter_two;

/*
* 167. 两数之和 II - 输入有序数组
* */
public class two_6 {
    /**
        思路：
            这道题非常简单，就最基本的双指针一个一个找就行。
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target)
                return new int[]{left + 1, right + 1};
            else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
