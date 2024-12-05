package chapter_13;

import java.util.ArrayList;
import java.util.List;

/*
* 46. 全排列
* */
public class thirteen_83 {
    /**
     自己想的时候最大的问题是不知道怎么标注已经选过的元素。解决方式就是在add和remove时，用一个数组
     来标注该元素是否使用过。
     整体还不是太好想，不过代码的格式和之前的没什么变化。
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
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
