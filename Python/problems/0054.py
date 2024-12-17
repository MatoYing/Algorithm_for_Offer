from typing import List

"""
看labuladong的图会很好理解，每次卡一“边”。
"""
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        upper_bound = 0
        lower_bound = len(matrix) - 1
        left_bound = 0
        right_bound = len(matrix[0]) - 1

        res = []

        while True:
            # 注意四个的顺序
            for i in range(left_bound, right_bound + 1):
                res.append(matrix[upper_bound][i])
            upper_bound += 1
            # 因为upper_bound变了，所以判断一下符不符合
            # 四个if其实对应着不同的终止情况，比如最后一条线是“横着”，也可能“竖着”
            if upper_bound > lower_bound:
                break

            for i in range(upper_bound, lower_bound + 1):
                res.append(matrix[i][right_bound])
            right_bound -= 1
            if left_bound > right_bound:
                break

            # 这里是倒着走；left_bound记得减1
            for i in range(right_bound, left_bound - 1, -1):
                res.append(matrix[lower_bound][i])
            lower_bound -= 1
            if upper_bound > lower_bound:
                break

            for i in range(lower_bound, upper_bound - 1, -1):
                res.append(matrix[i][left_bound])
            left_bound += 1
            if left_bound > right_bound:
                break

        return res
