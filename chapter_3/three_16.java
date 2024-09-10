package chapter_3;

/*
* 3. 无重复字符的最长子串
* */
public class three_16 {
    /**
     这道题用了比较巧的一个小方法吧。正常写你就双指针走一步判断一下，如果你用之前数组标记的方式，
     你每次移动需要便利整个数组是否为1。下面这个巧的方式就省的便利所有，每次把大于1的标记出来，然
     移动left把大于1的消掉。
     没必要哈希表，数组就能很好解决，当然哈希表也行。
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int res = 0;
        int left = 0;
        boolean temp = false;
        // 不是自由英文字母，一共有256个字符
        int[] counts = new int[256];
        for (int right = 0; right < s.length(); right++) {
            // 不用减‘a’了
            counts[s.charAt(right)]++;
            if (counts[s.charAt(right)] == 2)
                temp = true;
            while (temp) {
                // 注意下面这两句话顺序
                counts[s.charAt(left)]--;
                left++;
                if (counts[s.charAt(right)] == 1)
                    temp = false;
            }
            res = Math.max(right - left + 1, res);
        }
        return res;
    }
}
