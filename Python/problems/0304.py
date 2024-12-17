from typing import List

"""
比较直观的前缀和题目。
要注意的点就是，在计算preSum时，我们给它多加了一行0和一列0。
"""
class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        # 多了一行0和一列0，这样下面在构建时不用额外判断有没有out of index。
        self.preSum = [[0 for _ in range(len(matrix[0]) + 1)] for _ in range(len(matrix) + 1)]

        for i in range(1, len(matrix) + 1):
            for j in range(1, len(matrix[0]) + 1):
                # 一维加个if还比较容易，但这个加if判断有没有越界太麻烦
                self.preSum[i][j] = self.preSum[i - 1][j] + self.preSum[i][j - 1] -  self.preSum[i - 1][j - 1] + matrix[i - 1][j - 1]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        return self.preSum[row2 + 1][col2 + 1] - self.preSum[row2 + 1][col1] - self.preSum[row1][col2 + 1] + self.preSum[row1][col1]