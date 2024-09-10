package chapter_10;

/*
* 676. 实现一个魔法字典
* */
public class ten_64 {

    Trie trie;

    /**
     这是目前最好的模版（下面）！！！
     思路其实很简单，就是暴力遍历，将原单词一个一个换，换成其它25个字母，再循环试。
     */
    /** Initialize your data structure here. */
    public ten_64() {
        this.trie = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for(String word : dictionary){
            trie.insert(word);
        }
    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        StringBuilder sb = new StringBuilder(searchWord);
        // 其实就是暴力遍历
        for(int i = 0; i < len; i++){
            int chIdx = sb.charAt(i) - 'a';
            // 两个for，将当前字符替换为其他25个字符
            for(int j = 0; j < chIdx; j++){
                // (char) (j + 97)：直接变字母
                sb.setCharAt(i, (char) (j + 97));
                if(trie.searchPrefix(sb.toString()))
                    return true;
            }
            for(int j = chIdx + 1; j < 26; j++){
                sb.setCharAt(i, (char) (j + 97));
                if(trie.searchPrefix(sb.toString()))
                    return true;
            }
            // 记得换回来
            sb.setCharAt(i, (char) (chIdx + 97));
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */

// 因为只包含小写字母，可以用大小为26的Trie数组实现
class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }
    public void insert(String word) {
        Trie cur = this;
        for(int i = 0; i < word.length(); i++){
            int cIdx = word.charAt(i) - 'a';
            if(cur.children[cIdx] == null){
                cur.children[cIdx] = new Trie();
            }
            cur = cur.children[cIdx];
        }
        cur.isEnd = true;
    }
    public boolean searchPrefix(String prefix) {
        Trie cur = this;
        for(int i = 0; i < prefix.length(); i++){
            int cIdx = prefix.charAt(i) - 'a';
            if(cur.children[cIdx] == null){
                return false;
            }
            cur = cur.children[cIdx];
        }
        return cur.isEnd;
    }
}
