package chapter_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 47. 全排列 II
* */
public class thirteen_84 {
    /**
     和“组合总和 II”大同小异，不同之处是，呢道题每次都是从j开始，而这个每次都是从0开始。
     只需要下面if continue处的语句。
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, res, temp, used);
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] used) {
        // 结束条件
        if (temp.size() == nums.length) {
            // 这里要new ArrayList一个temp，你直接添加temp，它是个对象，一变全变，最后只有一个值
            res.add(new ArrayList<>(temp));
            return;
        }

        // i每次都从0开始，应为人家要全排列
        for (int i = 0; i < nums.length; i++) {
            // 前两个很容易理解；主要是!used[i - 1]
            // 很巧妙，不好想。拿1、1、2为例。当到了第二个1时，如果检测到第一个1可以使用，那么直接
            // 跳过。如果第一个1正在使用，说明现在这个1是可以使用的。
            // 解释一下前半句，如果前面的1可以用，说明我已经考虑完前面1在这个位置所有情况了，所
            // 以当到了第二个1来填补前面1的当初这个位置时，它的情况已经考虑过了（就是第一个1和第
            // 二个1换了位置），可以直接跳过
            /*
            * 这个其实和82题有异曲同工之妙
            * "j > i && candidates[j] == candidates[j - 1]"
            * 唯一的差别就是j!=i换成了!used[i - 1]。
            * j!=i的作用是控制同一层，也就是同一个位置；而!used[i - 1]也是同样的。
            * 假设[1,2,2,2]
            * 首先取了1、2，之后进入第三层，选2时!used[i - 1]为false，之后成了1、2、2；
            * 本层改变第二了2换成另一个2，发现!used[i - 1]为true（remove上面改成了false），直接跳过。
            * ENDING
            * */
            if (i != 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            if (used[i] == false) {
                temp.add(nums[i]);
                // 注意这里的操作（来标注元素有没有用过），正好和这个add和remove相对应
                used[i] = true;

                backtrack(nums, res, temp, used);

                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
