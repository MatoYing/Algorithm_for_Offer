package chapter_10;

import java.util.List;

public class ten_63_2 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String dict : dictionary) {
            trie.insert(dict);
        }
        String ans = "";
        for (String word : sentence.split(" ")) {
            ans += " ";
            ans += trie.searchPrefix(word);
        }
        return ans.trim();
    }
}
class Trie2 {
    Trie2[] children;
    String word;

    public Trie2() {
        this.children = new Trie2[26];
    }
    public void insert(String word) {
        Trie2 cur = this;
        for (char letter : word.toCharArray()) {
            if (cur.children[letter - 'a'] == null) {
                cur.children[letter - 'a'] = new Trie2();
            }
            cur = cur.children[letter - 'a'];
        }
        cur.word = word;
    }
    public String searchPrefix(String prefix) {
        Trie2 cur = this;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            System.out.println(prefix.charAt(i));
            if (cur.children[index] == null) {
                return prefix;
            } else {
                if (cur.children[index].word != null) {
                    return cur.children[index].word;
                }
                cur = cur.children[index];
            }
        }
        return prefix;
    }
}
