package chapter_8;

import java.util.TreeMap;

/*
 * 729. 我的日程安排表 I
 * */
public class eight_58 {
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

    TreeMap<Integer, Integer> map;

    /**
     ------！！！！-----！！！！！------
     ---------！！！！！！！-----------
     如上图，很简单，就是比两个端点。
     */
    public eight_58() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // 注意细节，这里用Integer，用int的话就是0
        Integer first = map.floorKey(start);

        // 第一种写法
        // Integer middle = map.ceilingKey(start);
        // if ((first == null || map.get(first) <= start) && (middle == null || middle >= end)) {
        //     map.put(start, end);
        //     return true;
        // }

        // 第二种写法
        // [20,29][14,20]，end记得减一，很坑
        Integer last = map.floorKey(end - 1);
        if ((first == null || map.get(first) <= start) && (last == null || start >= map.get(last))) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}
