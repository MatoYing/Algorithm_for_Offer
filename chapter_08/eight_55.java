package chapter_8;

import java.util.ArrayList;
import java.util.List;

/*
* 173. 二叉搜索树迭代器
* */
public class eight_55 {
    public static class TreeNode {
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

    int index;
    List<Integer> list;

    /**
     不难刚开始一下子还没想出来，一直想怎么迭代。
     他有两个函数，没法迭代的写。
     做树记得使用列表和队列
     */
    public eight_55(TreeNode root) {
        index = 0;
        list = new ArrayList<>();
        recursionInorderTraversal(root, list);
    }

    public int next() {
        // 这个index++写法很妙
        return list.get(index++);
    }

    public boolean hasNext() {
        if (index == list.size())
            return false;
        else
            return true;
    }

    public void recursionInorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            recursionInorderTraversal(root.left, list);
            list.add(root.val);
            recursionInorderTraversal(root.right, list);
        }
    }
}
