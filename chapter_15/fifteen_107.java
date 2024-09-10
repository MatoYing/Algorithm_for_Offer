package chapter_15;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* 542. 01 矩阵
* */
public class fifteen_107 {
    /**
     刚开始想到的是动态规划，但是这个最开始的边界不知道怎么处理。
     解决办法，从左上角开始一个，从右下角开始一个。

     重点说BFS，首先对于不是树的BFS，其实也差不多，主要就是要用到queue。

     该题思路：
     1.把0的坐标存到queue
     2.将1改为-1，用来标注是否处理过，每次处理的-1还要在放回queue，这样才可以使得每个元素得到赋值
     3.开始poll，每次改这个元素的上下左右
     */
    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }


        while (queue.size() != 0) {
            int[] temp = queue.poll();
            if (temp[0] - 1 >= 0 && temp[1] >= 0 && temp[0] - 1 < mat.length && temp[1] < mat[0].length) {
                if (mat[temp[0] - 1][temp[1]] == -1) {
                    mat[temp[0] - 1][temp[1]] = mat[temp[0]][temp[1]] + 1;
                    queue.offer(new int[] {temp[0] - 1, temp[1]});
                }
            }
            if (temp[0] + 1 >= 0 && temp[1] >= 0 && temp[0] + 1 < mat.length && temp[1] < mat[0].length) {
                if (mat[temp[0] + 1][temp[1]] == -1) {
                    mat[temp[0] + 1][temp[1]] = mat[temp[0]][temp[1]] + 1;
                    queue.offer(new int[] {temp[0] + 1, temp[1]});
                }
            }
            if (temp[0] >= 0 && temp[1] - 1 >= 0 && temp[0] < mat.length && temp[1] - 1 < mat[0].length) {
                if (mat[temp[0]][temp[1] - 1] == -1) {
                    mat[temp[0]][temp[1] - 1] = mat[temp[0]][temp[1]] + 1;
                    queue.offer(new int[] {temp[0], temp[1] - 1});
                }
            }
            if (temp[0] >= 0 && temp[1] + 1 >= 0 && temp[0] < mat.length && temp[1] + 1 < mat[0].length) {
                if (mat[temp[0]][temp[1] + 1] == -1) {
                    mat[temp[0]][temp[1] + 1] = mat[temp[0]][temp[1]] + 1;
                    queue.offer(new int[] {temp[0], temp[1] + 1});
                }
            }
        }
        return mat;
    }
}
