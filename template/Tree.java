package template;

import java.util.*;

public class Tree {
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

    // 广度优先搜索
    public List<Integer> BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 在这里加个queue.size()，然后通过for循环，卡这个size可以达到层分隔的效果
            TreeNode node = queue.poll();
            result.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    // 深度优先搜索：中序遍历、前序遍历、后序遍历
    // 中序遍历(递归)
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs1(root, nodes);
        return nodes;
    }
    public void dfs1(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            dfs1(root.left, nodes);
            nodes.add(root.val);
            dfs1(root.right, nodes);
        }
    }

    // 中序遍历(栈)
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            nodes.add(cur.val);
            cur = cur.right;
        }
        return nodes;
    }



    // 前序遍历(递归)
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs2(root, nodes);
        return nodes;
    }
    public void dfs2(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            nodes.add(root.val);
            dfs1(root.left, nodes);
            dfs1(root.right, nodes);
        }
    }

    // 前序遍历(栈)
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                nodes.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return nodes;
    }



    // 后序遍历(递归)
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs3(root, nodes);
        return nodes;
    }
    public void dfs3(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            dfs1(root.left, nodes);
            dfs1(root.right, nodes);
            nodes.add(root.val);
        }
    }

    // 后序遍历(栈)
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != prev) {
                cur = cur.right;
            } else {
                stack.pop();
                nodes.add(cur.val);
                prev = cur;
                cur = null;
            }
        }
        return nodes;
    }
    
}
