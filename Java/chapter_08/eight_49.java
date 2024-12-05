package chapter_8;

/*
* 129. 求根节点到叶节点数字之和
* */
public class eight_49 {
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
     使用前序遍历，看着二叉树走一遍就知道为啥用中序遍历了。
     真难想。
     我刚开始想一直在想怎么传递和，不好想。
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            //防止下面dfs(root.left, sum)，这里的oot.left活right为null
            return 0;
        }
        // 为什么不会重复加：比如说head的头，从这里走过后就不会在乘10了
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            // 提前保存好sum，如果利用进入root.left，之后root == null，return sum，这样prevSum会多乘一次10
            return sum;
        } else {
            // 很巧妙，正好最后两个分叉算完加起来回到倒数第二个，然后倒数第二行算完和起来在往上
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}

class eight_49_2 {
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

    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode root, int minSum) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            this.sum += minSum * 10 + root.val;
        }
        dfs(root.left, minSum * 10 + root.val);
        dfs(root.right, minSum * 10+ root.val);
    }
}
