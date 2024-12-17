from typing import List

"""
和“48. 旋转图像”不一样。48是正方形，所以你可以原地转置。
而这道题不行，比方说3x2的矩阵，转置之后会变成 2x3 的，你不new一个新数组出来怎么可能做到呢？

下面两个for那里怎么想呢？
照着这两个例子想：
1 2 3
4 5 6
变成
1 4
2 5
3 6
"""
class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        m = len(matrix)
        n = len(matrix[0])

        new_matrix = [[0 for _ in range(m)] for _ in range(n)]

        for i in range(m):
            for j in range(n):
                # 注意i和j的顺序
                new_matrix[j][i] = matrix[i][j]

        return new_matrix