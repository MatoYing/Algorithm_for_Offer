package chapter_10;

/*
* 208. 实现 Trie (前缀树)
* */
public class ten_62 {
    // 存的是一个新的自己（怎么还有点像递归）
    private ten_62[] children;
    private boolean isEnd;

    /**
     结合呢个前缀树的图，每个点都是一个对象。
     这个写法还是挺变态的，但还算是比较好理解。很屌的写法！！！
     想想确实得这么写，因为你每个“节点”都需要存好children和isEnd。这是两个完全不一样的东西，
     也只能用对象的方式。

     可能会产生一个问题，每次怎么回到头呢？
     可以看最下面的调用代码：
     Trie obj = new Trie();
     obj.insert(word);
     boolean param_2 = obj.search(word);
     boolean param_3 = obj.startsWith(prefix);
     它先创了一个obj，这个也就是头节点（为空），每次都是调用这个空的头节点。
     */
    public ten_62() {
        // 自己可能会接26个字母
        children = new ten_62[26];
        // false表示不成单词，true表示成单词（比图i，is，这个i就是true，防止找不到）
        isEnd = false;
    }

    public void insert(String word) {
        // 第一次见，高级；正常写Trie node = new Trie()，但这个不是自己，是新的。
        ten_62 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new ten_62();
            }
            // 移动到当前节点
            node = node.children[index];
        }
        // 告知这个节点这里有单词
        node.isEnd = true;
    }

    public boolean search(String word) {
        ten_62 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node = null;
                return false;
            }
            node = node.children[index];
        }
        if (node.isEnd)
            return true;
        else
            return false;
    }

    public boolean startsWith(String prefix) {
        ten_62 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}
