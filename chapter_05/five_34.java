package chapter_5;

/*
* 953. 验证外星语词典
* */
public class five_34 {
    /**
     思路比较简单。看见全是字母先想-'a'，不行在哈希表。要注意的就是offer，offen，这种你需要继续往后判断。
     */
    public boolean isAlienSorted(String[] words, String order) {
        // char[] orders = order.toCharArray();
        // 只有英文字母率先想这个
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;
        for (int i = 0; i < words.length - 1; i++) {
            int front = words[i].length();
            int back = words[i + 1].length();
            int length;
            // 来标志是循环是break（已经没问题了）出去的，还是顺序出去的
            boolean flag = true;
            if (front > back)
                length = back;
            else
                length = front;
            for (int k = 0; k < length; k++) {
                if (index[words[i].charAt(k) - 'a'] < index[words[i + 1].charAt(k) - 'a']) {
                    // 防止这种["kuvp","q"]，直接就出去了，但front大于back，return false
                    // 只有呢种一直等于才是front > back反false
                    flag = false;
                    break;
                }
                else if (index[words[i].charAt(k) - 'a'] == index[words[i + 1].charAt(k) - 'a'])
                    continue;
                else if (index[words[i].charAt(k) - 'a'] > index[words[i + 1].charAt(k) - 'a'])
                    return false;
            }
            // ["apple","app"]，这种回一直顺序出来
            if (front > back && flag)
                return false;
        }
        return true;
    }
}
