package chapter_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 438. 找到字符串中所有字母异位词
* */
public class three_15 {
    /**
     和上一题一摸一样
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList();
        int n = p.length();
        int m = s.length();
        if (n > m)
            return indices;
        int[] first = new int[26];
        int[] second = new int[26];
        for (int i = 0; i < n; i++) {
            first[p.charAt(i) - 'a']++;
            second[s.charAt(i) - 'a']++;
        }
        // 要在外面先写一次这个if，例如“a”和“ab”
        if (Arrays.equals(first, second))
            indices.add(0);
        for (int i = n; i < m; i++) {
            second[s.charAt(i) - 'a']++;
            second[s.charAt(i - n) - 'a']--;
            if (Arrays.equals(first, second))
                indices.add(i - n + 1);
        }
        return indices;
    }
}
