package chapter_3;

/*
* 647. 回文子串
* */
public class three_20 {
    /**
     下面这个方法学名叫做“中心扩展”，说白了，就是挨个遍历，只不过，中心可能是1个字符
     也可能是2个字符而已。不可能出现3个字符作为中心的情况，因为3个字符作为中心的话，
     他就是回文了，等于1个字符作为中心的情况。
     说上原话解释：“如果存在一个长度为m的回文字符串，则分别向该回文的两端延伸一个字符，
     并判断是否相同”；“回文的长度既可以是奇数，也可以是偶数。长度为奇数的回文对称中心只
     有一个字符，而长度为偶数的回文对称中心有两个字符”。
     单看“aaa”这个例子，怎么理解呢？每个a都是不一样的可以看成“a1、a2、a3”，这样可以更好的理解。
     */
    public int countSubstrings(String s) {
        if (s.length() == 0)
            return 0;
        int count = 0;
        int right;
        int left;
        // 中心点为1个
        for (int i = 0; i < s.length(); i++) {
            // 自身就是一个
            count++;
            left = i - 1;
            right = i + 1;
            while (left >=0 && right <= s.length() - 1) {
                if (s.charAt(left) == s.charAt(right)) {
                    count++;
                    left--;
                    right++;
                    continue;
                }
                break;
            }
        }
        // 中心点为2个
        for (int i = 0; i < s.length() - 1; i++) {
            // 这里要先判断一下这两个中心点
            left = i;
            right = i + 1;
            while (left >=0 && right <= s.length() - 1) {
                if (s.charAt(left) == s.charAt(right)) {
                    count++;
                    left--;
                    right++;
                    continue;
                }
                break;
            }
        }
        return count;
    }
}
