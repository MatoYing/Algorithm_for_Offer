package chapter_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 15. 三数之和
* */
public class two_7 {
    /**
     思路：
        依然是双指针，因为是三数之和，所以你得先固定一个数，然后在左右双指针一个一个无脑比。
        书上是分开写的，我这个和了起来，感觉更好理解。
     注意：
        因为可能数字重复，所以你得加个while来避开重复的判断，while里一定得记得加个“越界”
        的判断，如果都是重复值，像j一直++，“nums[j] == nums[j - 1]”就会越界。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)
            return res;
        Arrays.sort(nums);
        int i = 0;
        //卡住一个值，让剩下两个值等于它的负数
        while (i <= nums.length - 3) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //可能之后还有新的组合等于nums[i]
                    k--;
                    j++;
                    //k是right，如[-2,0,1(a),1(b),2]，b比完后k--，到了a，所以一定是k和k+1比
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                }
                else if (nums[i] + nums[j] + nums[k] > 0)
                    k--;
                else
                    j++;
            }
            //一定要先判断越界
            while (i <= nums.length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }
        return res;
    }
}
