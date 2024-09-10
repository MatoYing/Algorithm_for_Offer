package chapter_3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
* 76. 最小覆盖子串
* */
public class three_17 {
    /**
     反正思路就是滑动窗口，看一下leetcode的呢个动图也能懂。代码比较多，思路简单，不带了
     看书上怎么写的了，自己直接写了。
     后记：很不容易，改了五六个小时bug。我陷入了一个错误的想法中，就是下面check那里。
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right;
        String res = "";
        Map<Character, Integer> t_map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            t_map.put(ch, t_map.getOrDefault(ch, 0) + 1);
        }
        for (right = 0; right < s.length(); right++) {
            // 右移判断
            if (check(t_map)) {
                if (t_map.containsKey(s.charAt(right))) {
                    int temp = t_map.get(s.charAt(right));
                    temp--;
                    t_map.put(s.charAt(right), temp);
                }
            }
            // 左移判断，并且获得min值
            while (left <= right && !check(t_map)) {
                if (min != Math.min(right - left + 1, min)) {
                    min = right - left + 1;
                    // substring不分割最右面的
                    res = s.substring(left, right + 1);
                }
                if (t_map.containsKey(s.charAt(left))) {
                    int temp = t_map.get(s.charAt(left));
                    temp++;
                    t_map.put(s.charAt(left), temp);
                }
                left++;
            }
        }
        return res;
    }

    // 主要为了用一下迭代器
    // 判断移动条件（t_map全为0左移，其他右移）
    public boolean check(Map<Character, Integer> map) {
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            // Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            // 这里右移判断，必须是>0（不能>=0），比如abbdad（“ad”），指到第二个a left只会移
            // 一次，指到第二个b，left仍然只会移一次。
            // 我之前考虑的问题，多移动了left可能就不满足了？首先我已经卡了min了；其次
            // 这个主要是为了过滤b
            if (val > 0) {
                // 移right or 更新min
                return true;
            }
        }
        return false;
    }
}
