package chapter_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 39. 组合总和
* */
public class thirteen_81 {
    /**
     和之前两题一样的模版代码，比较简单。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // 为了for循环里的剪枝
        Arrays.sort(candidates);
        backtrack(0, candidates, res, temp, target);
        return res;
    }
    public void backtrack(int i, int[] candidates, List<List<Integer>> res, List<Integer> temp, int target) {
        // 结束条件
        if (target < 0)
            return;

        // 满足条件的
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }

        for (int j = i; j < candidates.length; j++) {
            // 剪枝：因为排过序了（从小到大），这里不满足，之后的更不满足
            if (target - candidates[j] < 0) {
                break;
            }
            temp.add(candidates[j]);
            // 注意这里传的是j和target - candidates[j]
            // j：因为它是可以重复选的。那为什么不能0，你如果写0，意味着2选3，之后3还能选2，会重复
            // target - candidates[j]：如果不这样写你每次都得遍历temp求和。这样的话只用比是不是小于0
            backtrack(j, candidates, res, temp, target - candidates[j]);
            temp.remove(temp.size() - 1);
        }
    }
}
