package chapter_8;

import java.util.ArrayList;
import java.util.List;

/*
* 897. 递增顺序搜索树
* */
public class eight_52 {
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
     终于来了道简单题，舒服。
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return new TreeNode();
        }
        List<Integer> list = new ArrayList<>();
        recursionInorderTraversal(root, list);

        TreeNode res = new TreeNode();
        TreeNode head = res;
        for (int i = 0; i < list.size(); i++) {
            res.right = new TreeNode(list.get(i));
            res = res.right;
        }
        return head.right;
    }

    public void recursionInorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        recursionInorderTraversal(root.left, list);
        list.add(root.val);
        recursionInorderTraversal(root.right, list);
    }
}
class eight_52_2 {
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
     * 多年后重写。
     */
    TreeNode first;
    TreeNode pre;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return this.first;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            // System.out.println(root.val);
            if (pre != null) {
                pre.right = root;
            } else {
                // System.out.println(root.val);
                this.first = root;
            }
            root.left = null;
            pre = root;
            dfs(root.right);
        }
    }
}
