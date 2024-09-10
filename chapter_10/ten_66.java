package chapter_10;

import java.util.HashMap;
import java.util.Map;

/*
* 677. 键值映射
* */
public class ten_66 {
    Trie trie;
    Map<String, Integer> map;

    /**
     还算比较简单吧，虽然刚开始不会。这道题的题意我在下面一长串注释已经解释清楚。主要的核心i就是
     apple为5的话，每个字母都是5，取ap时，取最后一个字母p处的值。解释一下后半句，你比入insert
     apple，app，a，取ap，所以就是取apple和app，也就是ap的p。这也凸显出了前缀树的意义。

     这里主要就是HashMap结合Trie的应用。第一次结合，其实跟HashMap没啥关系，它的作用也就是算出
     在inset时Trie值的变化量。

     class里居然还能写class，第一次这么写。
     */
    public ten_66() {
        trie = new Trie();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        trie.insert(key, val);
    }

    public int sum(String prefix) {
        return trie.searchPrefix(prefix);
    }

    class Trie {
        Trie[] children;
        int val;

        public Trie() {
            this.children = new Trie[26];
            this.val = 0;
        }
        public void insert(String word, int val) {
            Trie cur = this;
            // “如果键key已经存在，那么原来的键值对将被替代成新的键值对”
            // 为什么要以这样的形式？
            // eg：apple为5，那么a为5，p为5等等。现在来了个ap为3，那么a为8，p为8，p还为5
            // 如果又来一个apple为3，那么原来的为5的apple将被替代所以之前的apple都要减2
            // 也就是a成了6，p成了6，p成了3等
            int curr = val - map.getOrDefault(word, 0);  // 可能是负数（变小）
            map.put(word, val);
            for (int i = 0; i < word.length(); i++){
                int cIdx = word.charAt(i) - 'a';
                if (cur.children[cIdx] == null) {
                    cur.children[cIdx] = new Trie();
                }
                cur = cur.children[cIdx];
                cur.val += curr;
            }
        }
        public int searchPrefix(String prefix) {
            Trie cur = this;
            for(int i = 0; i < prefix.length(); i++){
                int cIdx = prefix.charAt(i) - 'a';
                if(cur.children[cIdx] == null){
                    return 0;
                }
                cur = cur.children[cIdx];
            }
            return cur.val;
        }
    }
}
