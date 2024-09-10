package template;

public class Trie {
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
