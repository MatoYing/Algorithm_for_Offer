package chapter_13;

import java.util.ArrayList;
import java.util.List;

/*
* 22. 括号生成
* */
public class thirteen_85 {
    /**
     这道题的关键就是发现一个规律：只有一直保证左括号数小于等于右括号数就可以。
     因为肯定现有左括号，一旦右括号的数量多于左括号说明前面的左括号已经无法满足右括号了。

     这里有个注意点String是介于基本数据类型和对象中一种对象。它每次变动会创建新的对象，所以不用
     remove
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String temp = "";
        backtrack(res, temp, n, n);
        return res;
    }

    public void backtrack(List<String> res, String temp, int left, int right) {
        // 结束条件
        if (left == 0 && right == 0) {
            res.add(temp);
            return;
        }

        if (left == right) {
            // 相等只能放（
            backtrack(res, temp + "(", left - 1, right);
        } else if (left < right) {
            // 小于可以放两种，一起写上就行，走完一个退回来走另一个
            if (left > 0) {
                backtrack(res, temp + "(", left - 1, right);
            }
            backtrack(res, temp + ")", left, right - 1);
        } else
            return;
    }
}
