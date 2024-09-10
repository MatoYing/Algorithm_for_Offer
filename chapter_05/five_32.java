package chapter_5;

import java.util.Arrays;

/*
* 242. 有效的字母异位词
* */
public class five_32 {
    /**
     这个用下面的方法更简单，没必要上哈希表。
     */
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }
}
