package chapter_3;

import java.util.Arrays;

/*
* 567. 字符串的排列
* */
public class three_14 {
    /**
     起初我一直无法理解这个思路，直到用“ab”，和“[cd]eba”照的写了一遍，原来这就是传说中的
     滑动窗口([])，一直以为它和双指针是一个东西。
     来源网络：
     双指针：以r为基础指针并根据题目要求来移动l或者保持l不动，同时ans由每一步的r-l来更新。
     滑动窗口：以l为基础指针，并且l~r看做一个窗口，r不断右移，根据题目要求来右移一次l或者
     保持l不动，特点是r-l始终不减，ans为最终的r-l
     区别：双指针算法当需要移动l指针时，可能移动多个单位以满足要求。而滑动窗口算法当需要移
     动l指针时，每次必定只移动一个单位！
     下面这个思路其实和书上是一模一样的。如果你用暴力法，你需要每次移动窗口，将窗口里的内容排序，
     然后再比是否相等。如果你用下面的思路，因为不需要考虑顺序，所以你只需比各个元素的个数即可，把
     他们转成数字在比就很巧妙。
     下次看到字母，就要想转成数字。

     其实下面这个思路也是滑动窗口，只不过是不用每次排序比。
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m)
            return false;
        int[] first = new int[26];
        int[] second = new int[26];
        for (int i = 0; i < n; i++) {
            first[s1.charAt(i) - 'a']++;
            second[s2.charAt(i) - 'a']++;
        }
        // 要在外面先写一次这个if，例如“a”和“ab”
        if (Arrays.equals(first, second))
            return true;
        for (int i = n; i < m; i++) {
            second[s2.charAt(i) - 'a']++;
            second[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(first, second))
                return true;
        }
        return false;
    }
}
