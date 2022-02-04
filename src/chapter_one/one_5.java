package chapter_one;

/*
* 318. 最大单词长度乘积
* */
public class one_5 {
    /**
     思路：
        书中给了两种写法，第一种是先声明一个长度为26的二维数组，利用数组把每个
        单词的字母输进去，然后一个一个比有没有重复字母，没有的话乘出来，在一个
        一个比大小。第二种，就是将这个长度为26的二维数组变为26位的二进制，其他
        都一样。
     注意：
        1.char - ‘a’，这种能直接得到0（两个char相减位整数）
        2.我突然想到>>变号的问题，只有>>会考虑正负数，<<只会补0（110 >> 2——11110）
     */
    public int maxProduct(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            // toCharArray像python中list(str)
            for (char ch: words[i].toCharArray()) {
                // 这里像是把1往前推
                flags[i] |= 1 << (ch - 'a');
            }
        }
        int res = 0;
        // 无脑一个一个比
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1;j < words.length; j++) {
                if ((flags[i] & flags[j]) == 0) {
                    int temp = words[i].length() * words[j].length();
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }
}
