package chapter_13;

import java.util.ArrayList;
import java.util.List;

/*
* 78. 子集
* */
public class thirteen_79 {
    /**
     画图。
     一道题看不出什么规律，继续做吧。
     一层其实只卡一个点！！
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        // 1.确定递归树
        backtrack(0, nums, res, temp);

        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, List<Integer> temp) {
        // 2.确定结束条件。此题没有条件，直接添加。
        res.add(new ArrayList<>(temp));

        // 3.确定选择列表。
        for (int j = i; j < nums.length; j++) {
            // 4.判断是否需要剪枝。此题不需要

            // 5.做出选择
            temp.add(nums[j]);
            backtrack(j + 1, nums, res, temp);

            // 6.撤销选择
            temp.remove(temp.size() - 1);
        }
    }
}
