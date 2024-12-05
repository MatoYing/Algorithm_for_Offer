package chapter_8;

import java.util.HashSet;
import java.util.Set;

/*
* 653. 两数之和 IV - 输入 BST
* */
public class eight_56 {
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

    Set<Integer> set = new HashSet<Integer>();
    // List<Integer> set = new LinkedList<>();
    boolean flag = false;

    /**
     乍一看，好像完全遍历完，存到list里，在一个一个遍历看有没有。
     答案里用了HashSet，我也第一次用用。
     BST:二叉搜索树
     感觉也没必要用Set，因为它是二叉搜索树，本身就不可能有相同值，而且就算有对于这道题也没事。
     收回上面的话，试了一下，List用了29ms，Set用了2ms
     Why：
     Set检索元素效率低下，删除和插入效率高；
     List查找元素效率高，插入删除元素效率低。
     List虽然用get(index)方法查询效率高，但是若用contains方法查询对象元素，Set集合比List效率更高，我们证明出了，Set()的时间复杂度是O(1)，而List.contain的时间复杂度是O(n)。
     https://www.baeldung.com/java-hashset-arraylist-contains-performance
     简单来说，对于contains()，List是根据indexOf()，也就是一个一个比，时间复杂度是O(n)
     而，Set是根据HashCode()，时间复杂度是O(1)
     */
    public boolean findTarget(TreeNode root, int k) {
        recursionInorderTraversal(root, k);
        if (flag == true)
            return true;
        else
            return false;
    }

    public void recursionInorderTraversal(TreeNode root, int k) {
        if (flag == true)
            return;
        if (root != null) {
            recursionInorderTraversal(root.left, k);
            // 每次都得先比了，在add，因为例如[2],1,这种你2-1=1，在找1，发现有，会返回true
            if (set.contains(k - root.val)) {
                flag = true;
                return;
            }
            set.add(root.val);
            recursionInorderTraversal(root.right, k);
        }
    }
}
