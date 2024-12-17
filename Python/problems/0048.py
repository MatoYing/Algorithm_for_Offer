from typing import List

"""
死记住，先根据对角线进行翻转，然后reverse每行。
"""
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix[0])

        # 这是一个正方形
        for i in range(n):
            for j in range(i, n):
                # swap(matrix[i][j], matrix[j][i])
                # Python语法糖
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

        for row in matrix:
            row.reverse()