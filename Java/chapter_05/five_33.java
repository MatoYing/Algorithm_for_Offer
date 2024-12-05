package chapter_5;

import java.util.*;

/*
* 49. 字母异位词分组
 * */
public class five_33 {
    /**
     还是使用数组排序的方法。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // 数组变String的方法（因为题上要返回）
            String sorted = new String(charArray);
            groups.putIfAbsent(sorted, new ArrayList<String>());
            groups.get(sorted).add(str);
        }
        // 直接获取去value
        return new ArrayList<>(groups.values());
    }
}
