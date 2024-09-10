package chapter_13;

import java.util.ArrayList;
import java.util.List;

/*
* 77. 组合
* */
public class thirteen_80 {
    /**
     在上一题基础上稍加改动，很容易。
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(1, n, k, res, temp);
        return res;
    }

    public void backtrack(int i, int n, int k, List<List<Integer>> res, List<Integer> temp) {
        // 剪枝（只剪掉了后面）如果后面长度已经不够k了，直接剪掉
        if (temp.size() + (n - i + 1) < k) {
            return;
        }
        // 获得满足题意的答案
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
        }
        for (int j = i; j <= n; j++) {
            temp.add(j);
            backtrack(j + 1, n, k, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
