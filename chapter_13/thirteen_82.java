package chapter_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 40. 组合总和 II
* */
public class thirteen_82 {
    /**
     和上一题39对比，上一题是无重复元素，可以多次选；这题是有重复元素不可以多次选。
     最需要考虑的问题就是像事例2中的例子[2,5,2,1,2]，[1,2,2]和另一个[1,2,2]，你要做的就是避免
     这种情况发生。
     第一种方法用排序后用Set（第一种显然因为没有剪枝时间会更长）
     第二种方法回溯剪枝，比如上面的例子[1,2,2,2,5]，参考图：https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/，选
     了1和2后它下来调用backtrace有三种情况backtrack(2)->在往下判断2和5;backtrack(2)->再往下
     判断5;backtrack(5)。如果第一个2不行，那第二个2肯定也不行，因为第一个2之后遍历的组合会包含
     第二个2遍历的组合（因为第一个二还能调用backtrack(2)和backtrack(5)；第二个2只能调用
     backtrack(5)，所以第一个2已经包含了第二个2）。（第一个2会调backtrack(2)从而选了2，这是
     不同层的；第二个2是选不了2的）
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

        // 这是一层！！！！backtrack会进入新的一层！！！！
        for (int j = i; j < candidates.length; j++) {

            // 大剪枝
            if (target - candidates[j] < 0) {
                break;
            }

            // 小剪枝（结合图更好理解）
            // j != 0：因为candidates防止越界
            // j != i：因为这是新的一层，能取的就是i和i后面的
            // 这俩结合可以写成j > i(“因为这是新的一层，能取的就是i和i后面的”，这点也能得出)
            /*
            * 多年后再次理解：
            * 以[1,2,2,2,3]，5为例子
            * 这个j!=i可以理解为，每次只能进入下一层的时候add上2，同一层（也就是一个for里）不能2之后再2。
            * 因为同层它改变的是同一个位置的数，比如说第一层，首先会在第一个位置add上1，之后递归出来后，会remove掉1，再在第一个位置上add上2；
            * 而backtrack是控制的不同位置的数，第一层发动backtrack后，进入第二层，而这层就是去控制第二个位置。
            * 而这个j!=i就是为了卡同一层的，因为同一层只能改变值add进去的"位置"（同一层的位置是固定的），
            * 所以，比如说第二层（第一层假设固定为1），(1,2),(1,2),(1,2),(1,3)，也就是你之前add过2，你在add2，这是重复的，
            * 因为，第一个(1,2)后，进入第三层，它的选择可以是2，2，3；第二个(1,2)，进入第三层，它的选择可以是2，3。选择已经被被第一个包含。
            * ENDING
            * */
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }

            temp.add(candidates[j]);
            backtrack(j + 1, candidates, res, temp, target - candidates[j]);
            temp.remove(temp.size() - 1);
        }
    }
}
