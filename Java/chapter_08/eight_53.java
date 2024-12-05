package chapter_8;

/*
* 剑指 Offer II 053. 二叉搜索树中的中序后继
* */
public class eight_53 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /**
     第一道自己独立完成的中等难度的树的题，记念一下。
     重大发现：递归里只会用到之前的root，从头节点输进来，这个root的遍历顺序已经卡死了，
     除非呢两个递归传值你不传root.left和root.right。
     */
    // 来标志是否找到了p，它的下一个就是答案
    boolean flag = false;
    // 来保留res，防止res二次更改
    boolean second = false;
    // 这个值只是为了接受递归返回的值，没用，要不就另写一个函数，就不需要使用这个了
    TreeNode temp;
    // 真正的答案
    TreeNode res;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (flag == true && second == true) {
            // 不写这部也是对的，这个的话可以更快一些
            // res变了，会不会一直局部递归？
            // 不会！因为你根本不会用到res，它只是为了结束，和最后的最后返回答案。递归里只会用到之前的root，从头节点输进来，这个root的遍历顺序 已经卡死了，除非呢两个递归传值你不传root.left和root.right！！！！！！
            // ！！！！！！！！这是很重要的一点！！！！！！！！！重大发现！！！！！！！！！
            return res;
        }
        if (root != null) {
            temp = inorderSuccessor(root.left, p);
            if (flag == true && second == false) {
                res = root;
                second = true;
                return res;
            }
            if (root.val == p.val)
                flag = true;
            temp = inorderSuccessor(root.right, p);
        }
        // 没找到res的时候一直为null，不会影响程序
        // 找到后，也没有可能会在改变res，一直递归到退出程序
        return res;
    }
}
