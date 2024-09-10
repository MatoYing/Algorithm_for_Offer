package template;

import java.util.ArrayList;
import java.util.List;

public class Recall {

    // 最基本形态
    public List<List<Integer>> main2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        // 1.确定递归树（看看到底放什么）
        backtrack2(0, nums, res, temp);

        return res;
    }

    private void backtrack2(int i, int[] nums, List<List<Integer>> res, List<Integer> temp) {
        // 2.确定结束条件。此题没有条件，直接添加。
        res.add(new ArrayList<>(temp));

        // 3.确定选择列表。（这里经常变，j到底等于什么）
        for (int j = i; j < nums.length; j++) {
            // 4.判断是否需要剪枝。此题不需要（for外面也可以剪枝）

            // 5.做出选择，继续回溯
            temp.add(nums[j]);
            backtrack2(j + 1, nums, res, temp);

            // 6.撤销选择
            temp.remove(temp.size() - 1);
        }
    }

    /////////////////////////////////////////////////////////////

    // 复杂形态
    public List<String> main(String s) {
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        String str = "";
        backtrack1(0, res, temp, s, str);
        return res;
    }

    public void backtrack1(int n, List<String> res, List<String> temp, String s, String str) {

        if (n == s.length()) {
            if (temp.size() != 4) {
                return;
            }
            String ans = String.join(".", temp);
            res.add(ans);
            return;
        }

        for (int i = n; i <= s.length() - 1; i++) {
            str += s.charAt(i);
            if (str.length() != 1 && str.charAt(0) == '0') {
                return;
            }
            temp.add(str);
            backtrack1(i + 1, res, temp, s, "");
            temp.remove(temp.size() - 1);
        }
    }
}
