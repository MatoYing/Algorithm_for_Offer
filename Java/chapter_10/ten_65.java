package chapter_10;

import java.util.Arrays;

/*
* 820. 单词的压缩编码
* */
public class ten_65 {
    /**
     核心：把字符串倒过来（随便想一下就明白了）
     这道题其实一开始思路就没什么问题。我当时想到了先排序，但我觉得没必要。最终没能解决。

     下面注释的代码最大的问题是无法解决["time","atime","btime"]，下面代码的逻辑是如果有了time那
     么atime和btime都会算成1。这是错误的，可以看一下官方给的呢个字典树的图。
     之后看了官方的图后大改思路，插入是不变的，最后变成求有多少个节点，然后又实用了BFS，这个会超时。
     而且其实这个不是求多少个节点，而是求每条枝的长度和。

     为什么要排序？（脑子要有呢个图）
     这样可以避免了一个判断，如果没new了新的Trie，那说明此时这个str的轨迹完全重复在了Trie树中
     不需加长度。如果new了新的Trie，说明树又分叉了（像“atime”和“btime”是没法和的；“atime”和
     “time”是可以和的）
     如果你不排，当你有了“time”，来了“atime”，或者顺序相反，就会有了一个判断，长度到底加多少。而且
     当有了“btime”，你没发法判断了。所以你要考虑的点有首先new没new，new的话有覆盖原来短的，覆盖
     了几回（"time","atime","btime"），解决不了的！要排序！排序就保证了，不用考虑覆盖了几回这个
     问题。
     */
    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        Trie1 trie = new Trie1();
        // 长度大到小
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (String word : words) {
            String reverse_word = new StringBuilder(word).reverse().toString();
            res += trie.insert(reverse_word);
        }
        return res;
    }
}

class Trie1 {
    Trie1[] children;
    boolean isEnd;

    public Trie1() {
        this.children = new Trie1[26];
        this.isEnd = false;
    }
    public int insert(String word) {
        Trie1 cur = this;
        boolean flag = false;
        for(int i = 0; i < word.length(); i++){
            int cIdx = word.charAt(i) - 'a';
            if(cur.children[cIdx] == null){
                flag = true;
                cur.children[cIdx] = new Trie1();
            }
            cur = cur.children[cIdx];
        }
        // 如果new了就说明有新的分支
        if (flag)
            return word.length() + 1;
            // 没new说明被覆盖了
        else
            return 0;
    }
}

// 没排序的错误，浪费了三个小时

// class Solution {
//     public int minimumLengthEncoding(String[] words) {
//         int len = 0;
//         Trie trie = new Trie();
//         for (String word : words) {
//         String reverse_word = new StringBuilder(word).reverse().toString();
//         int excess = trie.insert(reverse_word);
//         // if (excess == 0)
//         if (excess == word.length())
//             len += 1 + excess;
//         else
//             len += excess;
//         }
//             return len;
//         }
//     }

// class Trie {
//     Trie[] children;
//     boolean isEnd;

//     public Trie() {
//         this.children = new Trie[26];
//         this.isEnd = false;
//     }

//     public int insert(String word) {
//         Trie cur = this;
//         int excess_count = 0;
//         boolean flag1 = false;
//         boolean flag2 = false;
//         for(int i = 0; i < word.length(); i++){
//             int cIdx = word.charAt(i) - 'a';
//             if(cur.children[cIdx] == null){
//                 flag2 = true;
//                 cur.children[cIdx] = new Trie();
//             }
//             if (cur.isEnd) {
//                 flag1 = true;
//             }
//             if (flag1) {
//                 excess_count++;
//             }
//             cur = cur.children[cIdx];
//         }
//         cur.isEnd = true;
//         if (excess_count != 0) {
//             // 为什么不用减1？
//             // 因为在cur.isEnd其实晚了一轮
//             // eg：['me','time']
//             // 第一轮i为e，isEnd为false，由root指向e
//             // 第二轮i为m，isEnd为false，由root指向m
//             // 第二轮i为i，isEnd为true，excess_count开始++
//             return excess_count;
//         }
//         else if (flag2 == false)
//             return 0;
//         else
//             return word.length();
//     }
// }
