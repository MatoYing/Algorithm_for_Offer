package chapter_13;

import java.util.ArrayList;
import java.util.List;

/*
* 131. 分割回文串
* */
public class thirteen_86 {
    /**
     不是很难，独立做出。
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        String str = "";
        backtrack(0, res, temp, s, str);
        return res;
    }

    public void backtrack(int n, List<List<String>> res, List<String> temp, String s, String str) {
        if (n == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = n; i <= s.length() - 1; i++) {
            str += s.charAt(i);
            if (check(str)) {
                temp.add(str);
                backtrack(i + 1, res, temp, s, "");
                // 要按序号删除，因为按str的话，会可能删除前面相同的str
                // temp.remove(str);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean check(String temp) {
        int right = temp.length() - 1;
        int left = 0;
        while (left < right) {
            if (temp.charAt(left) != temp.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
