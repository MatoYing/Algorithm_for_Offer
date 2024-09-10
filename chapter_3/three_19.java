package chapter_3;

/*
* 680. 验证回文字符串 Ⅱ
* */
public class three_19 {
    /**
     基本的思路，就是双指针比相不相同，遇到不同的，就移个left或right继续看相不相同。
     坑："cupxpucu"，因为我默认一边优先匹配了，就不再考虑另一边的情况，像这个会先删了
     左c，不会在考虑删u的情况，u也是可以的，这样就漏判一种情况
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int sub_left = 0;  // 来保存left多走时的left的right
        int sub_right = 0;
        // 标志是否已经删除一个字符
        // 0:还没删； 1：删过左边的； 2:左右都删过了
        int flag = 0;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (flag == 0) {
                    if (s.charAt(left + 1) == s.charAt(right)) {
                        left++;
                        sub_left = left - 1;
                        sub_right = right;
                        // 标志左边改过了
                        flag = 1;
                    }
                    else if (s.charAt(left) == s.charAt(right - 1)) {
                        // 标志右边改过了
                        right--;
                        flag = 2;
                    } else {
                        // 左右都改过都不行，那就是真的不行
                        return false;
                    }
                } else if (flag == 1) {
                    // 回到改left时的保存点，改right
                    left = sub_left;
                    right = sub_right;
                    if (s.charAt(left) == s.charAt(right - 1)) {
                        right--;
                        flag = 2;
                        continue;
                    }
                    return false;
                } else {
                    // flag为2时，真的不行了
                    return false;
                }
            }
        }
        return true;
    }
}
