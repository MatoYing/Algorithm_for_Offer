package chapter_7;

import java.util.LinkedList;
import java.util.Queue;

/*
* 919. 完全二叉树插入器
* */
public class seven_43 {
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

    TreeNode root;
    Queue<TreeNode> q;
    /**
     题目并不是让我们实现一个完全二叉树，而是给定一个完全二叉树的头，实现符合要求的插入器。
     这个初始化类的目的是是为了找到第一个左或右为空的节点！！！
     想了半天，最重要的是跟着代码画图。
     */
    public seven_43(TreeNode root) {
        this.root = root;
        q = new LinkedList();
        q.offer(root);
        //bfs
        while(!q.isEmpty()){
            TreeNode temp=q.peek();
            // 在广度优先遍历下（因为这是完全二叉树）找到第一个子节点有空的节点
            if(temp.left==null || temp.right==null){
                break;
            }
            q.offer(temp.left);
            q.offer(temp.right);
            q.poll();
        }
        // 现在队列最右边的就是第一个子节点有空的节点
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode temp = q.peek();
        if(temp.left == null){
            temp.left = node;
        }else{
            temp.right = node;
            q.offer(temp.left);
            q.offer(temp.right);
            //出队，转移到下一个不完全的节点
            q.poll();
        }
        // 按题目返回父节点的值
        return temp.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
