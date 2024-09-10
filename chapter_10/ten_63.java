package chapter_10;

import java.util.List;

/*
* 648. 单词替换
* */
public class ten_63 {
    /**
     思路不难，对比上一个前缀树题目“208. 实现 Trie (前缀树)”，可以对前缀树有更加深刻理解。
     其实上一道题也应该用这种格式写，就是新做一个class，这样更好理解。
     把这道题当成模版！！！！
     注意区分class里什么时候放isEnd，什么时候放word。
     */
    public String replaceWords(List<String> roots, String sentence) {
        // -----------模版-------------
        // 创建前缀树
        TrieNode trie = new TrieNode();
        for (String root: roots) {
            // 每次都从头找
            TrieNode cur = trie;
            for (char letter: root.toCharArray()) {
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                cur = cur.children[letter - 'a'];
            }
            cur.word = root;
        }
        // -----------模版-------------

        StringBuilder ans = new StringBuilder();
        for (String word: sentence.split(" ")) {
            ans.append(" ");
            // 找另一个单词时，回到根
            TrieNode cur = trie;
            for (char letter : word.toCharArray()) {
                // 前缀树没有直接出，ans里添加原单词
                if (cur.children[letter - 'a'] == null)
                    break;
                // cur.word一找到就出，没找到继续找
                if (cur.word != null)
                    break;
                cur = cur.children[letter - 'a'];
            }
            if (cur.word != null) {
                ans.append(cur.word);
            } else {
                ans.append(word);
            }
        }
        // StirngBuilder转String
        return ans.toString().trim();
    }
}

class TrieNode {
    TrieNode[] children;
    // 可以对比上个题目，它这里放的是isEnd，那是因为题上只要求返回true和false
    // 而这个题目是要返回词的，所以这样会更加方便些。否则还得专门拿个变量存
    String word;
    TrieNode() {
        children = new TrieNode[26];
    }
}
