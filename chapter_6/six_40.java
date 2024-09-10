package chapter_6;

import java.util.ArrayDeque;
import java.util.Deque;

/*
* 85. 最大矩形
* */
public class six_40 {
    /**
     困难题不写了，和面试题39差不多。
     每一层看作是柱状图，可以套用84题柱状图的最大面积。
     第一层柱状图的高度["1","0","1","0","0"]，最大面积为1；
     第二层柱状图的高度["2","0","2","1","1"]，最大面积为3；
     第三层柱状图的高度["3","1","3","2","2"]，最大面积为6；
     第四层柱状图的高度["4","0","0","3","0"]，最大面积为4；
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int col = matrix.length;
        int row = matrix[0].length;
        int[] heights = new int[row];
        int ans = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}
