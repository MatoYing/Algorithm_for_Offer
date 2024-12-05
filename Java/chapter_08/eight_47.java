package chapter_8;


import chapter_7.seven_43;

/*
* 814. 二叉树剪枝
* */
public class eight_47 {
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
     真难想，记住呢四个遍历，不要想呢么多递归的过程。
     */
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // 两个等于null很重要，因为是从最底部遍历，所以如果有个不为null但等于0，说明它的下面有1，也不能删。
        if(root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}


class eight_47_2 {
    /**
     * 多年后用自己习惯的方式重写，更好理解。
     */
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
    public TreeNode pruneTree(TreeNode root) {
        // 这里必须root接一下，否则像[0,0,0,0]这种，头节点最后return null，但没有东西接，所以头节点还是没有删除
        // dfs(root);
        root = dfs(root);
        return root;
    }

    public TreeNode dfs(TreeNode root) {
        if (root != null) {
            root.left = dfs(root.left);
            root.right = dfs(root.right);
            if (root.right == null && root.left == null && root.val == 0) {
                return null;
            }
        } else {
            return null;
        }
        return root;
    }
}
