package chapter_two;

public class two_13 {
    private int[][] sum;
    /**
     我起初觉得吧，你用这二维前缀和的方式也时间上不会减少，因为你要都算一变；甚至直接求还更简单。
     但是这个题是一下给好几组坐标一起求。
     写的非常清楚：https://leetcode-cn.com/problems/range-sum-query-2d-immutable/solution/er-wei-qian-zhui-he-jian-dan-tui-dao-tu-sqekv/
     画个图会一清二楚
     例：
     输入：
     // [3,0,1,4,2]
     // [5,6,3,2,1]
     // [1,2,0,1,5]
     // [4,1,0,1,7]
     // [1,0,3,0,5]
     所求：
     // [2,1,4,3]
     // [1,1,2,2]
     // [1,2,2,4]
     答案：
     [8,11,12]
     sum矩阵：
     // 3	3	4	8	10
     // 8	14	18	24	27
     // 9	17	21	28	36
     // 13	22	26	34	49
     // 14	23	30	38	58
     */
    public two_13(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            // 这是构造函数，你也返回不了别的
            return;
        }
        // 根据下面我们求前缀和的公式，就比如，第一行第一个，它是要加自己左面的和上面的，
        // 所以多声明一行一列（为0）
        sum = new int[matrix.length + 1][matrix[0].length + 1];  // 行｜列
        for (int i = 1; i <= matrix.length; i++) {
            for (int k = 1; k <= matrix[0].length; k++) {
                sum[i][k] = sum[i - 1][k] + sum[i][k - 1] + matrix[i - 1][k - 1] - sum[i - 1][k - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row1][col1] + sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] -sum[row1][col2 + 1];
    }
}
