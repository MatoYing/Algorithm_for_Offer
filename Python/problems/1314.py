from typing import List

"""
基于“304. 二维区域和检索 - 矩阵不可变”，先把“区域和”算出来（看呢道题）。
而这道题，根据题意，其实就是算(r-k, c-k)到(r+k, c+k)这个框内的和，然后将这个和赋给(r,c)。
框的坐标已经有了，如何求框内的和？可以抄304的思路。
"""
class Solution:
    def matrixBlockSum(self, mat: List[List[int]], k: int) -> List[List[int]]:
        #########304#########
        self.preSum = [[0 for _ in range(len(mat[0]) + 1)] for _ in range(len(mat) + 1)]
        for i in range(1, len(mat) + 1):
            for j in range(1, len(mat[0]) + 1):
                self.preSum[i][j] = self.preSum[i - 1][j] + self.preSum[i][j - 1] -  self.preSum[i - 1][j - 1] + mat[i - 1][j - 1]
        #######################

        res = [[0 for _ in range(len(mat[0]))] for _ in range(len(mat))]

        for i in range(len(mat)):
            for j in range(len(mat[0])):
                # 注意边界
                row1 = max(i - k, 0)
                col1 = max(j - k, 0)
                row2 = min(i + k, len(mat) - 1)
                col2 = min(j + k, len(mat[0]) - 1)
                res[i][j] = self.sumRegion(row1, col1, row2, col2)

        return res


    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        return self.preSum[row2 + 1][col2 + 1] - self.preSum[row2 + 1][col1] - self.preSum[row1][col2 + 1] + self.preSum[row1][col1]