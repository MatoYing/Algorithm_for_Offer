package chapter_8;

/*
* 538. 把二叉搜索树转换为累加树
* */
public class eight_54 {
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
    /**
     二叉搜索树：就是左孩子比父节点小，右孩子比父节点大。
     这个思路真的不错，因为它是二叉搜索树，所以如果中序遍历，那就是从小到达出来。如果把root.left和
     root.right反过来一下，那正好出来就是从大到小！！！
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            // 重大发现！！居然可以不接收返回值
            convertBST(root.right);
            root.val = root.val + sum;
            sum = root.val;
            convertBST(root.left);
        }
        // 结合右图，这里返回的的是8，15，21，26...：因为一个点root.right和root.left全走了，会继续往下走
        // return什么不是不影响吗，为什么不能是null：是不影响，那最后答案也是null

        // 这个写法为什么不对
        // if (root != null && root.val == 36)
        //     return root;
        // return null;
        // 因为：最终返回的root不是在走完0出去的，是在4出去的！！
        // 又因为：这个root是对象，root.val改完之后就不变了，在哪出都一样！！
        return root;
    }
}
